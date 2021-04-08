/**
 * 
 */
package org.eni.projetEnchere.bll;

import org.eni.projetEnchere.dal.Article.DAOFactory;
import org.eni.projetEnchere.bo.ArticleVendu;
import org.eni.projetEnchere.bo.Utilisateur;
import org.eni.projetEnchere.dal.Article.ArticleDAO;

/**
 * @author var_dump
 *
 */
public class ArticleManager {
	
	private ArticleDAO articleDao;

	public ArticleManager() {
		articleDao = DAOFactory.getArticleDAO();
	}
	
	public ArticleVendu sale_artilce(String nom_article, String description, String date_debut_encheres, String date_fin_encheres, int prix_initial, int prix_vente) throws Exception {
		
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
		
		    
		
		ArticleVendu article = new ArticleVendu(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente);

		return articleDao.sale_article(article);
		
	}
	
}
