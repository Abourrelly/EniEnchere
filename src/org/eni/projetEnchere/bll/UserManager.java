/**
 * 
 */
package org.eni.projetEnchere.bll;

import org.eni.projetEnchere.bo.Utilisateur;
import org.eni.projetEnchere.dal.User.DAOFactory;
import org.eni.projetEnchere.dal.User.UserDALException;
import org.eni.projetEnchere.dal.User.UserDAO;

/**
 * @author var_dump
 *
 */
public class UserManager {
	private UserDAO userDao;

	public UserManager() {
		userDao = DAOFactory.getUserDAO();
	}
	
	public Utilisateur subscribe(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, int credit, int administrateur) {
		// TODO Auto-generated method stub
//			  private String pseudo;
//			  private String nom;
//			  private String prenom;
//			  private String email;
//			  private String telephone;
//			  private String rue;
//			  private String code_postal;
//			  private String ville;
//			  private String mot_de_passe;
//			  private int credit;
//			  private int administrateur;

		try {

			boolean v = userDao.checkUniquePseudoAndEmail(pseudo, email);
			
			//System.out.println(v);
			// si v la valeur de retours est true donc il n'y a pas de resultat en base
			if(v == true) {
				
				// si le pseudo n'est pas null et que c'est caractere soit tous alphanumerique
				if(pseudo != null && pseudo.matches("\\p{Alpha}+")){ // "\\p{Alpha}+"  // "\\p{Alnum}"
					
					Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 0, 0);
					userDao.subscribe(user);
					
				}
				
			} else {
				
				
			}
				
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return null;
				
	}

	public int connect(String input, String password) throws UserDALException {
		// TODO Auto-generated method stub
		try {
			boolean choiceRequete = false;
			// si le pseudo n'est pas null et que ses caracteres sont tous alphanumerique
			if(input != null){ // "\\p{Alpha}+"  // "\\p{Alnum}"
				
				if(input.contains("@")) {
					// requete par adresse mail
					choiceRequete = true;
					
				} else {
					// requete par pseudo
					choiceRequete = false;
				}
				
				int id = userDao.connect(input, password, choiceRequete);
				
				if(id != 0) {
					// connexion en cours
					return id;

				} else {
					// connexion refusée
					
					//throw new UserDALException("Nous ne trouvons personne avec c'est identifiant !");
					//return 0;
					
				}
				
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			//System.out.println(e.getMessage());
			//throw new UserDALException("Nous ne trouvons personne avec c'est identifiant !");
			
		}
		
		return 0;

	}
	
	public Utilisateur getInfosProfile(int id) throws Exception {
		
		return userDao.getInfosProfile(id);
		
	}
	
	public void updateUser(int id, String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse) throws Exception {
		//TODO : gestion des erreurs
		userDao.updateUser(id, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
	
	}
	
	public void deleteUser(int id) throws Exception {
		//TODO : gestion des erreurs
		userDao.deleteUser(id);
	
	}
	
}
