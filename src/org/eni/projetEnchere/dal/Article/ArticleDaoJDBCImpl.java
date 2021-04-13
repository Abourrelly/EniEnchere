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

import org.eni.projetEnchere.bll.UserManager;
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

	private static final String INSERT_RETRAIT = "INSERT INTO ENCHERE_GRP1.RETRAITS(no_article, rue, code_postal, ville) VALUES(?, ?, ?, ?)";

	
	private static final String SELECT_ALL_ARTICLE_USER_DISCONNECT = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ENCHERE_GRP1.ARTICLES_VENDUS WHERE date_debut_encheres >= ? AND date_fin_encheres <= ?";

	private static final String SELECT_ALL_ARTICLE_USER_CONNECT = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ENCHERE_GRP1.ARTICLES_VENDUS WHERE no_utilisateur = ?";                            

	//private static final String SELECT_ALL_ARTICLE_USER_CONNECT = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ENCHERE_GRP1.ARTICLES_VENDUS INNER JOIN ENCHERE_GRP1.ENCHERES ON ENCHERE_GRP1.ARTICLES_VENDUS.no_article = ENCHERE_GRP1.ENCHERES.no_article AND ENCHERE_GRP1.ARTICLES_VENDUS.no_utilisateur = ENCHERE_GRP1.ENCHERES.no_utilisateur WHERE no_utilisateur = ?";                            

	
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
	public ArticleVendu saleArticle(Utilisateur user, ArticleVendu article, int idCategorie) throws Exception {
		// TODO Auto-generated method stub
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmtArtilce = cnx.prepareStatement(INSERT_ARTILCE, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmtArtilce.setString(1, article.getNom());
			pStmtArtilce.setString(2, article.getDescription());
			pStmtArtilce.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
			pStmtArtilce.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
			pStmtArtilce.setInt(5, article.getPrixInitial());
			pStmtArtilce.setInt(6, article.getPrixVente());
			pStmtArtilce.setInt(7, user.getId());
			pStmtArtilce.setInt(8, idCategorie);
			
			pStmtArtilce.executeUpdate();
			
			ResultSet rsArtilce = pStmtArtilce.getGeneratedKeys();
			if(rsArtilce.next()) {
				article.setIdArticle(rsArtilce.getInt(1));
			}
			
			PreparedStatement pStmtRetrait= cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmtRetrait.setInt(1, article.getIdArticle());
			pStmtRetrait.setString(2, user.getRue());
			pStmtRetrait.setString(3, user.getCodePostal());
			pStmtRetrait.setString(4, user.getVille());
			
			pStmtRetrait.executeUpdate();
			
			ResultSet rsRetrait = pStmtRetrait.getGeneratedKeys();
			if(rsRetrait.next()) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return article;
		
	}


	@Override
	public List<ArticleVendu> getAllArticleUserConnect(int id) throws Exception{
		// TODO Auto-generated method stub
		
		String nowFormatString = nowDate();
				
		List<ArticleVendu> result = new ArrayList<ArticleVendu>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {	
					
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_ALL_ARTICLE_USER_CONNECT);
			pStmt.setInt(1, id);

			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				ArticleVendu articleVendu = new ArticleVendu(rs.getString("nom_article"), rs.getString("description"), rs.getString("date_debut_encheres"), rs.getString("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"));
				articleVendu.setIdArticle(rs.getInt("no_article"));
				Utilisateur user = new Utilisateur(); 
				user.setId(rs.getInt("no_utilisateur"));
				articleVendu.setIdUser(user);
				
				Categorie categorie = new Categorie(); 
				categorie.setIdCategorie(rs.getInt("no_categorie"));
				articleVendu.setIdCategorie(categorie);
				
				result.add(articleVendu);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

	@Override
	public List<ArticleVendu> getAllArticleUserDisconnect() throws Exception {
		// TODO Auto-generated method stub
		String nowFormatString = nowDate();
		
		List<ArticleVendu> result = new ArrayList<ArticleVendu>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_ALL_ARTICLE_USER_DISCONNECT);
			
			pStmt.setDate(1, java.sql.Date.valueOf(nowFormatString));
			pStmt.setDate(2, java.sql.Date.valueOf(nowFormatString));
			
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				ArticleVendu articleVendu = new ArticleVendu(rs.getString("nom_article"), rs.getString("description"), rs.getString("date_debut_encheres"), rs.getString("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"));
				articleVendu.setIdArticle(rs.getInt("no_article"));
				Utilisateur user = new Utilisateur(); 
				user.setId(rs.getInt("no_utilisateur"));
				articleVendu.setIdUser(user);
				
				Categorie categorie = new Categorie(); 
				categorie.setIdCategorie(rs.getInt("no_categorie"));
				articleVendu.setIdCategorie(categorie);
				
				result.add(articleVendu);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public ArticleVendu sendPayement(Utilisateur user, ArticleVendu article, Enchere enchere) throws Exception{
		
		
//		En tant qu’utilisateur, 
//		je peux faire une enchère sur un article si je propose un prix (en points) supérieur au tarif actuel 
//		et si mon compte de points ne devient pas négatif. 
//		Si l’enchère est possible, 
//		mon crédit de points est débité du montant proposé. 
//		Le meilleur enchérisseur précédent si il existe est re-crédité de son offre.
		
		
//		mon crédit de points est débité du montant proposé. 
//		
//		Le meilleur enchérisseur précédent si il existe est re-crédité de son offre.
		
		//String now_format_string = now_date();

		try(Connection cnx = ConnectionProvider.getConnection()) {
			
			int totale = 0;
			
			int totaleReversement = 0;
			
			int bestMontant = enchere.getMontantEnchere();
			//System.out.println(bestMontant);
			
			int credit = user.getCredit();
			//System.out.println(credit);
			
			totale = credit - bestMontant;
			//System.out.println(totale);
			
			PreparedStatement pStmtBestMontant= cnx.prepareStatement(UPDATE_FIRST_USER_BEST_MONTANT);
			pStmtBestMontant.setInt(1, totale);
			pStmtBestMontant.setInt(2, user.getId());
			pStmtBestMontant.executeUpdate();
			
			PreparedStatement pStmtEnchere = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmtEnchere.setInt(1, user.getId());
			pStmtEnchere.setInt(2, article.getIdArticle());
			pStmtEnchere.setDate(3, java.sql.Date.valueOf(enchere.getDateEnchere()));
			pStmtEnchere.setInt(4, enchere.getMontantEnchere());
			
			pStmtEnchere.executeUpdate();
			
			ResultSet rsEnchere = pStmtEnchere.getGeneratedKeys();
			
			//if(rsEnchere.next()) {
				//article.setNo_article(rsEnchere.getInt(1));
			//}
			
			PreparedStatement pStmtSelectEnchere = cnx.prepareStatement(SELECT_LAST_USER_BEST_ENCHERE, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			pStmtSelectEnchere.setInt(1, bestMontant);
			pStmtSelectEnchere.setInt(2, article.getIdArticle());
			
			ResultSet rsSelectEnchere = pStmtSelectEnchere.executeQuery();
			
			int idLastUser = 0;
			int montantEnchere = 0;
			
			while(rsSelectEnchere.next()) {
				
				if(rsSelectEnchere.isLast()) {
				// is last row in ResultSet
				// resultat pas vide
					
					idLastUser = rsSelectEnchere.getInt("no_utilisateur");
					//System.out.println(idLastUser);
					
					// recupere le credit 
					
					UserManager userManager = new UserManager();
					
					Utilisateur lastEnchereUser = userManager.getInfosProfile(idLastUser);
					
					int lastEnchereUserCredit = lastEnchereUser.getCredit();
					
					montantEnchere = rsSelectEnchere.getInt("montant_enchere");
					//System.out.println(montantEnchere);
					
					totaleReversement = montantEnchere + lastEnchereUserCredit;
					//System.out.println(totaleReversement);
					
					PreparedStatement pStmtUpdateCreditUser = cnx.prepareStatement(UPDATE_LAST_USER_BEST_ENCHERE);
					
					pStmtUpdateCreditUser.setInt(1, totaleReversement);
					pStmtUpdateCreditUser.setInt(2, idLastUser);
					
					pStmtUpdateCreditUser.executeUpdate();
				
				} else {
					// resultat vide
					
				}
	
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String nowDate() {
		
		Date now = new Date();
		
		SimpleDateFormat formater = null;
		
		formater = new SimpleDateFormat("yyyy-MM-dd");
		
		String nowFormatString = formater.format(now);
		
		return nowFormatString;
	}


}
