/**
 * 
 */
package org.eni.projetEnchere.dal.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eni.projetEnchere.bo.ArticleVendu;
import org.eni.projetEnchere.bo.Categorie;
import org.eni.projetEnchere.bo.Enchere;
import org.eni.projetEnchere.bo.Utilisateur;
import org.eni.projetEnchere.dal.ConnectionProvider;

/**
 * @author var_dump
 *
 */
public class ArticleDaoJDBCImpl implements ArticleDAO {
		
	private static final String INSERT_ARTILCE = "INSERT INTO ENCHERE_GRP1.ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur ,no_categorie) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String SELECT_ALL_ARTICLE_USER_DISCONNECT = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ENCHERE_GRP1.ARTICLES_VENDUS WHERE date_debut_encheres >= ? AND date_fin_encheres <= ?";

	private static final String SELECT_ALL_ARTICLE_USER_CONNECT = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ENCHERE_GRP1.ARTICLES_VENDUS WHERE no_utilisateur = ?";                            

//	date_debut_encheres <= ? AND date_fin_encheres >= ?
//	private static final String SELECT_ALL_ARTICLE_USER_CONNECT_OPTION_MES_VENTES= "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ENCHERE_GRP1.ARTICLES_VENDUS WHERE no_utilisateur = ?";
//
//	private static final String SELECT_ALL_ARTICLE_USER_CONNECT_OPTION_NON_COMMENCER = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ENCHERE_GRP1.ARTICLES_VENDUS WHERE date_debut_encheres > ?";
//	
//	private static final String SELECT_ALL_ARTICLE_USER_CONNECT_OPTION_TERMINES = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ENCHERE_GRP1.ARTICLES_VENDUS WHERE date_fin_encheres < ?";
	
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERE_GRP1.ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?)";
	
	private static final String SELECT_LAST_USER_BEST_ENCHERE = "SELECT no_utilisateur, montant_enchere FROM ENCHERE_GRP1.ENCHERES WHERE montant_enchere < ? AND no_article = ?";
	
	private static final String UPDATE_LAST_USER_BEST_ENCHERE = "UPDATE ENCHERE_GRP1.UTILISATEURS SET credit = ? WHERE no_utilisateur = ?";
	
	private static final String UPDATE_FIRST_USER_BEST_MONTANT = "UPDATE ENCHERE_GRP1.UTILISATEURS SET credit = ? WHERE no_utilisateur = ?";
	
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
	public List<ArticleVendu> get_all_article_user_connect(int id) throws Exception{
		// TODO Auto-generated method stub
		
		String now_format_string = now_date();
				
		List<ArticleVendu> result = new ArrayList<ArticleVendu>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {	
					
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_ALL_ARTICLE_USER_CONNECT);
			pStmt.setInt(1, id);

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
				
				result.add(articleVendu);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

	@Override
	public List<ArticleVendu> get_all_article_user_disconnect() throws Exception {
		// TODO Auto-generated method stub
		String now_format_string = now_date();
		
		List<ArticleVendu> result = new ArrayList<ArticleVendu>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_ALL_ARTICLE_USER_DISCONNECT);
			
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
				
				result.add(articleVendu);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public ArticleVendu send_payement(Utilisateur user, ArticleVendu article, Enchere enchere) throws Exception{

//		mon crédit de points est débité du montant proposé. 
//		
//		Le meilleur enchérisseur précédent si il existe est re-crédité de son offre.
		
		//String now_format_string = now_date();

		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			int best_montant = enchere.getMontant_enchere();
			int credit = user.getCredit();
			
			int totale = credit - best_montant;
			
			PreparedStatement pStmtBestMontant= cnx.prepareStatement(UPDATE_FIRST_USER_BEST_MONTANT);
			pStmtBestMontant.setInt(1, totale);
			pStmtBestMontant.setInt(2, user.getNo_utilisateur());
			pStmtBestMontant.executeUpdate();
			
			PreparedStatement pStmtEnchere = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmtEnchere.setInt(1, user.getNo_utilisateur());
			pStmtEnchere.setInt(2, article.getNo_article());
			pStmtEnchere.setDate(3, java.sql.Date.valueOf(enchere.getDate_enchere()));
			pStmtEnchere.setInt(4, enchere.getMontant_enchere());
			
			pStmtEnchere.executeUpdate();
			
			ResultSet rsEnchere = pStmtEnchere.getGeneratedKeys();
			
			//if(rsEnchere.next()) {
				//article.setNo_article(rsEnchere.getInt(1));
			//}
			
			PreparedStatement pStmtSelectEnchere = cnx.prepareStatement(SELECT_LAST_USER_BEST_ENCHERE);
			
			//pStmtSelectEnchere.setInt(1, user.getNo_utilisateur());
			pStmtSelectEnchere.setInt(1, best_montant);
			pStmtSelectEnchere.setInt(2, article.getNo_article());
			
			ResultSet rsSelectEnchere = pStmtSelectEnchere.executeQuery();
			
			int id_last_user = 0;
			int montant_enchere = 0;
			
			while(rsSelectEnchere.next()) {
				id_last_user = rsSelectEnchere.getInt("no_utilisateur");
				montant_enchere = rsSelectEnchere.getInt("montant_enchere");
			}
//			
			PreparedStatement pStmtUpdateCreditUser = cnx.prepareStatement(UPDATE_LAST_USER_BEST_ENCHERE);
			
			pStmtUpdateCreditUser.setInt(1, montant_enchere);
			pStmtUpdateCreditUser.setInt(2, user.getNo_utilisateur());
			
			ResultSet rsUpdateCreditUser = pStmtUpdateCreditUser.executeQuery();			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String now_date() {
		
		Date now = new Date();
		
		SimpleDateFormat formater = null;
		
		formater = new SimpleDateFormat("yyyy-MM-dd");
		
		String now_format_string = formater.format(now);
		
		return now_format_string;
	}


}
