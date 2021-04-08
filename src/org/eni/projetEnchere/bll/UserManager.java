/**
 * 
 */
package org.eni.projetEnchere.bll;

import org.eni.projetEnchere.bo.Utilisateur;
import org.eni.projetEnchere.dal.User.DAOFactory;
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
	
	public Utilisateur subscribe(String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe, int credit, int administrateur) {
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

			boolean v = userDao.check_unique_pseudo_and_email(pseudo, email);
			
			//System.out.println(v);
			// si v la valeur de retours est true donc il n'y a pas de resultat en base
			if(v == true) {
				
				// si le pseudo n'est pas null et que c'est caractere soit tous alphanumerique
				if(pseudo != null && pseudo.matches("\\p{Alpha}+")){ // "\\p{Alpha}+"  // "\\p{Alnum}"
					
					Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, 0, 0);
					userDao.subscribe(user);
					
				}
				
			} else {
				
				
			}
				
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return null;
				
	}

	public boolean connect(String input, String password) {
		// TODO Auto-generated method stub
		try {
			boolean choice_requete = false;
			// si le pseudo n'est pas null et que c'est caractere soit tous alphanumerique
			if(input != null){ // "\\p{Alpha}+"  // "\\p{Alnum}"
				
				if(input.contains("@")) {
					// requete par adresse mail
					choice_requete = true;
					
				} else {
					// requete par pseudo
					choice_requete = false;
				}
				
				//Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, 0, 0);
				boolean v = userDao.connect(input, password, choice_requete);
				
				if(v == true) {
					// connexion en cours
					return true;

				} else {
					// connexion refuser
					return false;
					
				}
				
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return false;

	}
}
