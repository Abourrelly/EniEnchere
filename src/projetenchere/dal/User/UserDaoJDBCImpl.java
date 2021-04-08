/**
 *
 */
package projetenchere.dal.User;

import projetenchere.bo.Utilisateur;
import projetenchere.dal.ConnectionProvider;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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

	
	private static final String GET_USER_FOR_EMAIL = "SELECT email, mot_de_passe FROM ENCHERE_GRP1.UTILISATEURS WHERE email = ?";
	
	private static final String GET_USER_FOR_PSEUDO = "SELECT pseudo, mot_de_passe FROM ENCHERE_GRP1.UTILISATEURS WHERE pseudo = ?";
	
	private static final String SELECT_BY_PSEUDO_AND_EMAIL = "SELECT pseudo, email FROM ENCHERE_GRP1.UTILISATEURS WHERE pseudo = ? AND email = ?";
	
	private static final String INSERT_USER = "INSERT INTO ENCHERE_GRP1.UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public boolean connect(String input, String password, boolean choice_requete) throws Exception {
		// TODO Auto-generated method stub
		
		String requete = null;
		
		if (choice_requete == true) {
		    // si c'est un email
			requete = GET_USER_FOR_EMAIL;
			
		} else {
			// sinon c'est un pseudo
			requete = GET_USER_FOR_PSEUDO;
		    //throw new IllegalArgumentException("String " + string + " does not contain -");
		
		}
		
		if(requete != null) {
			
			try(Connection cnx = ConnectionProvider.getConnection()) {
				
				PreparedStatement pStmtUser = cnx.prepareStatement(requete);
				pStmtUser.setString(1, input);
				
				ResultSet rs = pStmtUser.executeQuery();
				
				if (rs.next()) {
					// resultat pas vide
					String password_in_db = rs.getString("mot_de_passe");
					
					MessageDigest msg = MessageDigest.getInstance("SHA-256");
			        byte[] hash = msg.digest(password.getBytes(StandardCharsets.UTF_8));
			        // convertir bytes en hexadécimal
			        StringBuilder s = new StringBuilder();
			        for (byte b : hash) {
			            s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			        }
			        String singleString = s.toString();
			        
			        if(singleString.equals(password_in_db)) {
			        	// password correct
			        	return true;
			        	
			        } else {
			        	// password incorrect
			        	return false;
			        	
			        }
					
				} else {
					// Aucun resultat / vide
					return false;
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return false;

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
			pStmtUser.setString(7, newUser.getCode_postal());
			pStmtUser.setString(8, newUser.getVille());
			
			String mdp = newUser.getMot_de_passe();

	        MessageDigest msg = MessageDigest.getInstance("SHA-256");
	        byte[] hash = msg.digest(mdp.getBytes(StandardCharsets.UTF_8));
	        // convertir bytes en hexadécimal
	        StringBuilder s = new StringBuilder();
	        for (byte b : hash) {
	            s.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
	            
	        }
	        String singleString = s.toString();
	        pStmtUser.setString(9, singleString);
	        pStmtUser.setInt(10, 0);
	        pStmtUser.setInt(11, 0);
			
			pStmtUser.executeUpdate();
			
			ResultSet rsUser = pStmtUser.getGeneratedKeys();
			if(rsUser.next()) {
				newUser.setNo_utilisateur(rsUser.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newUser;
	}

	@Override
	public boolean check_unique_pseudo_and_email(String pseudo, String email) {
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
	
}
