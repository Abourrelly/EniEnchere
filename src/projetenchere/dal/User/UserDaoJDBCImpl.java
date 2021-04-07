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

	
	private static final String INSERT_USER= "INSERT INTO ENCHERE_GRP1.UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public Utilisateur connect(String email, String mot_de_passe) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur subscribe(Utilisateur newUser) throws Exception {
		// TODO Auto-generated method stub
		
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
	            s.append(Integer.toString((b & 0xff) + 0x100, 2).substring(1));
	            
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
	
}
