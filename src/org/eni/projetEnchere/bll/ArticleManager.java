/**
 * 
 */
package org.eni.projetEnchere.bll;

import org.eni.projetEnchere.dal.Article.DAOFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eni.projetEnchere.bo.ArticleVendu;
import org.eni.projetEnchere.bo.Categorie;
import org.eni.projetEnchere.bo.Enchere;
import org.eni.projetEnchere.bo.Retrait;
import org.eni.projetEnchere.bo.Utilisateur;
import org.eni.projetEnchere.dal.Article.ArticleDAO;

/**
 * @author var_dump
 *
 */
public class ArticleManager {
	
	private List<ArticleVendu> listeArticleVendu= new ArrayList<>();
	
	private ArticleDAO articleDao;

	public ArticleManager() {
		articleDao = DAOFactory.getArticleDAO();
	}
	
	public ArticleVendu saleArtilce(int id, String nom, String description, String dateDebutEncheres, String dateFinEncheres, int prixInitial, int prixVente, int idCategorie, String rue, String codePostal, String ville) throws Exception {
		
//		En tant qu’utilisateur, 
//		je peux vendre un article sur la plateforme ENI-Enchères. 
//		
//		Pour cela je donne les informations sur l’article vendu : 
//			
//		nom, 
//		description 
//		et catégorie 
//		j’indique un prix de départ ( en points ), 
//		une date et 
//		une heure d’ouverture de l’enchère, 
//		une date et une heure de fin d’enchères 
//		et les modalités du retrait :  adresse (par défaut celle du vendeur). 
		
		    
		
		ArticleVendu article = new ArticleVendu(nom, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente);

		UserManager userManager = new UserManager();
		
		Utilisateur user = userManager.getInfosProfile(id);
		
		Retrait retrait = null;
		
		if(rue != "" && codePostal != "" && ville != "") {
		
			retrait = new Retrait(rue, codePostal, ville);
			
		} else {
			// les champs non pas été remplis 
			
		}
		
		return articleDao.saleArticle(user, article, retrait, idCategorie);
		
	}
	
	public List<ArticleVendu> getAllArticleUserDisconnect() throws Exception {
		
		listeArticleVendu.addAll(articleDao.getAllArticleUserDisconnect());
		return listeArticleVendu;
		
//		En tant qu’utilisateur non connecté, 
//		je peux lister les enchères en cours. 
//		Je peux filtrer ma recherche par catégorie, et par nom d’article (l’article est affiché si il contient le critère saisi)
		
		
	}
	
	
	public List<ArticleVendu> getAllArticleUserConnect() throws Exception { //int id
		
		listeArticleVendu.addAll(articleDao.getAllArticleUserConnect()); //id
		return listeArticleVendu;
		
	}
	
	public void sendPayement(Utilisateur user, int idArticle, int miseAPrit, int meilleurOffre, int proposition) throws Exception{
		
		if((user.getCredit() >= proposition) && (proposition >= miseAPrit) && (proposition > meilleurOffre)) {
			// le reliquat est superieur ou egale a la propistion faite pour encherire
			// si la proposition est superieur ou egale a la mise a prit 
			// la propostion est superieur a la meilleur offre et la meilleur offre 
					
			ArticleVendu article= new ArticleVendu(); 
			article.setIdArticle(idArticle);
			
			LocalDate now = LocalDate.now();
	
			Enchere enchere = new Enchere(now, proposition);
			
			articleDao.sendPayement(user, article, enchere);
	
		} else {
			// pas assez de monaie pour encherire
			
		}

	}
	
	public ArticleVendu getInfosArticle(int id) throws Exception{
		
		return articleDao.getInfosArticle(id);
		
	}
	
	public Enchere getInfosUserBestEnchereForArticle(int id) throws Exception{
		
		return articleDao.getInfosUserBestEnchereForArticle(id);
		
	}
	
	public Retrait getInfosRetraitForArticle(int id) throws Exception{
		
		return articleDao.getInfosRetraitForArticle(id);
		
	}
	
	public ArticleVendu selectByIdUser(int id) throws Exception{
		
		return articleDao.selectByIdUser(id);
		
	}
	
}
