/**
 * 
 */
package org.eni.projetEnchere.dal.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eni.projetEnchere.bo.ArticleVendu;
import org.eni.projetEnchere.dal.ConnectionProvider;

/**
 * @author var_dump
 *
 */
public class ArticleDaoJDBCImpl implements ArticleDAO {
	
	
	private static final String INSERT_ARTILCE = "INSERT INTO ENCHERE_GRP1.ARTILCES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente) VALUES(?, ?, ?, ?, ?, ?)";
	

	@Override
	public ArticleVendu sale_article(ArticleVendu article) throws Exception {
		// TODO Auto-generated method stub
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmtArtilce = cnx.prepareStatement(INSERT_ARTILCE, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmtArtilce.setString(1, article.getNom_article());
			pStmtArtilce.setString(2, article.getDescription());
			pStmtArtilce.setString(3, article.getDate_debut_encheres());
			pStmtArtilce.setString(4, article.getDate_fin_encheres());
			pStmtArtilce.setInt(5, article.getPrix_initial());
			pStmtArtilce.setInt(6, article.getPrix_vente());
			
			pStmtArtilce.executeUpdate();
			
			ResultSet rsArtilce = pStmtArtilce.getGeneratedKeys();
			if(rsArtilce.next()) {
				article.setNo_article(rsArtilce.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return article;
		
	}
	
}
