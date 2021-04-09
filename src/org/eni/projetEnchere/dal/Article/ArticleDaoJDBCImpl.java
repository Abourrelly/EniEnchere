/**
 * 
 */
package org.eni.projetEnchere.dal.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eni.projetEnchere.bo.ArticleVendu;
import org.eni.projetEnchere.bo.Categorie;
import org.eni.projetEnchere.bo.Utilisateur;
import org.eni.projetEnchere.dal.ConnectionProvider;

/**
 * @author var_dump
 *
 */
public class ArticleDaoJDBCImpl implements ArticleDAO {
		
	private static final String INSERT_ARTILCE = "INSERT INTO ENCHERE_GRP1.ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur ,no_categorie) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String SELECT_ALL_ARTICLE = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ENCHERE_GRP1.ARTICLES_VENDUS WHERE date_debut_encheres >= ? AND date_fin_encheres <= ?";

	@Override
	public ArticleVendu sale_article(int id, ArticleVendu article, int id_categorie) throws Exception {
		// TODO Auto-generated method stub
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmtArtilce = cnx.prepareStatement(INSERT_ARTILCE, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmtArtilce.setString(1, article.getNom_article());
			pStmtArtilce.setString(2, article.getDescription());
			pStmtArtilce.setDate(3, java.sql.Date.valueOf(article.getDate_debut_encheres()));
			pStmtArtilce.setDate(4, java.sql.Date.valueOf(article.getDate_fin_encheres()));
			pStmtArtilce.setInt(5, article.getPrix_initial());
			pStmtArtilce.setInt(6, article.getPrix_vente());
			pStmtArtilce.setInt(7, id);
			pStmtArtilce.setInt(8, id_categorie);
			
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


	@Override
	public List<ArticleVendu> get_all_article() throws Exception{
		// TODO Auto-generated method stub		
		// Date now = new Date();
		
		String now_format_string = now_date();
				
		List<ArticleVendu> result = new ArrayList<ArticleVendu>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_ALL_ARTICLE);
			
			pStmt.setDate(1, java.sql.Date.valueOf(now_format_string));
			pStmt.setDate(2, java.sql.Date.valueOf(now_format_string));
			
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				ArticleVendu articleVendu = new ArticleVendu(rs.getString("nom_article"), rs.getString("description"), rs.getString("date_debut_encheres"), rs.getString("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"));
				articleVendu.setNo_article(rs.getInt("no_article"));
				Utilisateur user = new Utilisateur(); 
				user.setNo_utilisateur(rs.getInt("no_utilisateur"));
				articleVendu.setNo_utilisateur(user);
				
				Categorie categorie = new Categorie(); 
				categorie.setNo_categorie(rs.getInt("no_categorie"));
				articleVendu.setNo_categorie(categorie);
				//articleVendu.getNo_categorie();
				
				result.add(articleVendu);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	private String now_date() {
		
		Date now = new Date();
		
		SimpleDateFormat formater = null;
		
		formater = new SimpleDateFormat("yyyy-MM-dd");
		
		String now_format_string = formater.format(now);
		
		return now_format_string;
	}
	
}
