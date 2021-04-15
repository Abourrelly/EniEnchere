/**
 *
 */
package org.eni.projetEnchere.dal.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eni.projetEnchere.bo.ArticleVendu;
import org.eni.projetEnchere.bo.Enchere;
import org.eni.projetEnchere.bo.Utilisateur;
import org.eni.projetEnchere.dal.ConnectionProvider;


/**
 * @author var_dump
 *
 */
public class UserDaoJDBCImpl implements UserDAO {
	
//  private int no_utilisateur;
//  private String pseudo;
//  private String nom;
//  private String prenom;
//  private String email;
//  private String telephone;
//  private String rue;
//  private String code_postal;
//  private String ville;
//  private String mot_de_passe;
//  private int credit;
//  private int administrateur;
	
	private static final String SELECT_BY_PSEUDO_AND_EMAIL = "SELECT pseudo, email FROM ENCHERE_GRP1.UTILISATEURS WHERE pseudo = ? AND email = ?";
	
	private static final String GET_USER_FOR_EMAIL = "SELECT no_utilisateur, email, mot_de_passe FROM ENCHERE_GRP1.UTILISATEURS WHERE email = ?";
	
	private static final String GET_USER_FOR_PSEUDO = "SELECT no_utilisateur, pseudo, mot_de_passe FROM ENCHERE_GRP1.UTILISATEURS WHERE pseudo = ?";
	
	private static final String INSERT_USER = "INSERT INTO ENCHERE_GRP1.UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SELECT_BY_ID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM ENCHERE_GRP1.UTILISATEURS WHERE no_utilisateur = ?";

	private static final String UPDATE_USER = "UPDATE ENCHERE_GRP1.UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE no_utilisateur = ?";

	private static final String UPDATE_USER_EMPTY_MDP = "UPDATE ENCHERE_GRP1.UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ? WHERE no_utilisateur = ?";
	
	
	private static final String SELECT_ENCHERE_BY_ID_USER = "SELECT no_article, no_utilisateur FROM ENCHERE_GRP1.ENCHERES WHERE no_utilisateur = ?";
	
	private static final String DELETE_ENCHERE = "DELETE FROM ENCHERE_GRP1.ENCHERES WHERE no_utilisateur = ?";
	
	private static final String DELETE_ARTICLE = "DELETE FROM ENCHERE_GRP1.ARTICLE_VENDUS WHERE no_article AND no_utilisateur = ?";
	
	private static final String DELETE_USER = "DELETE FROM ENCHERE_GRP1.UTILISATEURS WHERE no_utilisateur = ?";
	
	@Override
	public int connect(String input, String password, boolean choiceRequete) throws UserDALException, Exception {
		// TODO Auto-generated method stub
		int id = 0;
		
		String requete = null;
		
		if (choiceRequete == true) {
		    // si c'est un email
			requete = GET_USER_FOR_EMAIL;
			
		} else {
			// sinon c'est un pseudo
			requete = GET_USER_FOR_PSEUDO;
		    //throw new IllegalArgumentException("String " + string + " does not contain -");
		
		}
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmtUser = cnx.prepareStatement(requete);
			pStmtUser.setString(1, input);
			
			ResultSet rs = pStmtUser.executeQuery();
			
			if (rs.next()) {
				
				String passwordInDb = rs.getString("mot_de_passe");
				String passwordEncrypt = encryptPassword(password);
				
				if (passwordEncrypt.equals(passwordInDb)) {
					
					id = rs.getInt("no_utilisateur");
					
					return id;
					
				} else {
					
					return id;
					
				}
			} else {
				
				return id;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserDALException("Nous ne trouvons personne avec c'est identifiant !");
		}

	}

	@Override
	public Utilisateur subscribe(Utilisateur newUser) throws Exception {
		// TODO Auto-generated method stub
		
//		En tant qu’utilisateur, 
//		je peux m’inscrire sur la plateforme Enchères.org. 
//		Le pseudo doit être unique sur toute la plateforme, ainsi que l’email. 
//		Le pseudo n’accepte que des caractères alphanumériques. 
//		Si la création du profil est validée, 
//		l’utilisateur est dirigé vers la page d’accueil (liste des enchères). 
//		Le crédit initial est de 0 
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmtUser = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmtUser.setString(1, newUser.getPseudo());
			pStmtUser.setString(2, newUser.getNom());
			pStmtUser.setString(3, newUser.getPrenom());
			pStmtUser.setString(4, newUser.getEmail());
			pStmtUser.setString(5, newUser.getTelephone());
			pStmtUser.setString(6, newUser.getRue());
			pStmtUser.setString(7, newUser.getCodePostal());
			pStmtUser.setString(8, newUser.getVille());
			
			String password = encryptPassword(newUser.getMotDePasse());
			
			pStmtUser.setString(9, password);
			
	        pStmtUser.setInt(10, 0);
	        pStmtUser.setInt(11, 0);
			
			pStmtUser.executeUpdate();
			
			ResultSet rsUser = pStmtUser.getGeneratedKeys();
			if(rsUser.next()) {
				newUser.setId(rsUser.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newUser;
	}

	@Override
	public boolean checkUniquePseudoAndEmail(String pseudo, String email){
		// TODO Auto-generated method stub
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_PSEUDO_AND_EMAIL);
			pStmt.setString(1, pseudo);
			pStmt.setString(2, email);
			
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				// resultat pas vide
				return false;
			} else {
				// Aucun resultat / vide
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
			
	}

	@Override
	public Utilisateur getInfosProfile(int id) throws Exception {
		// TODO Auto-generated method stub
		
		Utilisateur user = null;
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_ID);
			pStmt.setInt(1, id);
			
			ResultSet rs = pStmt.executeQuery();
			
			if (rs.next()) {
				// resultat pas vide
				user = mapUser(rs);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	@Override
	public void updateUser(int id, String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse) throws Exception {
		
		String requete = null;
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			if(motDePasse != "") {
				
				requete = UPDATE_USER;
				
			} else {
				
				requete = UPDATE_USER_EMPTY_MDP;
				
			}
			
			PreparedStatement pStmtUser = cnx.prepareStatement(requete);
			
			pStmtUser.setString(1, pseudo);
			pStmtUser.setString(2, nom);
			pStmtUser.setString(3, prenom);
			pStmtUser.setString(4, email);
			pStmtUser.setString(5, telephone);
			pStmtUser.setString(6, rue);
			pStmtUser.setString(7, codePostal);
			pStmtUser.setString(8, ville);
			
			if(motDePasse != "") {
				
				String password = encryptPassword(motDePasse);
				
				pStmtUser.setString(9, password);
				pStmtUser.setInt(10, id);
				
			} else {
				
				pStmtUser.setInt(9, id);
				
			}

			pStmtUser.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void deleteUser(int id, ArticleVendu article) {
		
		int idArticle = 0;
		
//		boolean condition_enchere = false;
//		boolean condition_article = false;
		
		if(article != null) {
			
			idArticle = article.getIdArticle();
			
		}
		
		System.out.println(id);
		
		System.out.println(idArticle);
		

//		private static final String SELECT_ENCHERE_BY_ID_USER = "SELECT no_article, no_utilisateur FROM ENCHERE_GRP1.UTILISATEURS WHERE no_article = ? AND no_utilisateur = ?";
//		
//		private static final String DELETE_USER = "DELETE FROM ENCHERE_GRP1.UTILISATEURS WHERE no_utilisateur = ?";
//		
		try(Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmtEnchere = cnx.prepareStatement(SELECT_ENCHERE_BY_ID_USER);
			pStmtEnchere.setInt(1, id);
			
			ResultSet rsEnchere = pStmtEnchere.executeQuery();
			
			if (rsEnchere.next()) {
				// resultat pas vide
				PreparedStatement pStmt = cnx.prepareStatement(DELETE_ENCHERE);
				pStmt.setInt(1, id);
//				
				pStmt.executeUpdate();
				
			} else {
//				Resultat vide
			}
			
			if(article != null) {
				
				// resultat pas vide
				PreparedStatement pStmt = cnx.prepareStatement(DELETE_ARTICLE);
				pStmt.setInt(1, idArticle);
				pStmt.setInt(2, id);
//				
				pStmt.executeUpdate();
				
			}
			
			PreparedStatement pStmt = cnx.prepareStatement(DELETE_USER);
			pStmt.setInt(1, id);

			pStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private String encryptPassword(String password) throws Exception {
		
		MessageDigest msg = MessageDigest.getInstance("SHA-256");
        byte[] hash = msg.digest(password.getBytes(StandardCharsets.UTF_8));
        // convertir bytes en hexadécimal
        StringBuilder s = new StringBuilder();
        for (byte b : hash) {
            s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            
        }
        String singleString = s.toString();
        return singleString;
        
	}
	
	private Utilisateur mapUser(ResultSet rs) throws SQLException {
				
		int idUser = rs.getInt("no_utilisateur");
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String rue = rs.getString("rue");
		String codePostal = rs.getString("code_postal");
		String ville = rs.getString("ville");
		String motDePasse = rs.getString("mot_de_passe");
		
		int credit = rs.getInt("credit");
		int administrateur = rs.getInt("administrateur");
		
		return new Utilisateur(idUser, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
	
	}
	
}
