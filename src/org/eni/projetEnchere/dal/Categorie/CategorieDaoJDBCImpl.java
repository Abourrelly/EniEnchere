/**
 * 
 */
package org.eni.projetEnchere.dal.Categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eni.projetEnchere.bo.Categorie;
import org.eni.projetEnchere.dal.ConnectionProvider;

/**
 * @author var_dump
 *
 */
public class CategorieDaoJDBCImpl implements CategorieDAO {
	
	private static final String SELECT_ALL_CATEGORIE = "SELECT no_categorie, libelle FROM ENCHERE_GRP1.CATEGORIES";

	private static final String SELECT_CATEGORIE_BY_ID = "SELECT no_categorie, libelle FROM ENCHERE_GRP1.CATEGORIES WHERE no_categorie = ?";
	
	public List<Categorie> getAll() throws Exception {
		
		List<Categorie> result = new ArrayList<>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_ALL_CATEGORIE);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {	
				result.add(new Categorie(rs.getInt("no_categorie"), rs.getString("libelle")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Categorie getById(int id) throws Exception{

		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_CATEGORIE_BY_ID);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {	
				return new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
