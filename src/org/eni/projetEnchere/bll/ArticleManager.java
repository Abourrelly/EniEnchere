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
	
	public ArticleVendu sale_artilce(int id, String nom_article, String description, String date_debut_encheres, String date_fin_encheres, int prix_initial, int prix_vente, int id_categorie) throws Exception {
		
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

		return articleDao.sale_article(id, article, id_categorie);
		
	}
	
	public List<ArticleVendu> get_all_article_user_disconnect() throws Exception {
		
		listeArticleVendu.addAll(articleDao.get_all_article_user_disconnect());
		return listeArticleVendu;
		
//		En tant qu’utilisateur non connecté, 
//		je peux lister les enchères en cours. 
//		Je peux filtrer ma recherche par catégorie, et par nom d’article (l’article est affiché si il contient le critère saisi)
		
		
	}
	
	
	public List<ArticleVendu> get_all_article_user_connect(int id) throws Exception {
		
		listeArticleVendu.addAll(articleDao.get_all_article_user_connect(id));
		return listeArticleVendu;
		
	}
	
	public void send_payement(int id_user, int id_article, int mise_a_prit, int meilleur_offre, int reliquat, int proposition) throws Exception{

		if(reliquat >= proposition) {
			// le reliquat est superieur ou egale a la propistion faite pour encherire
			
			if(proposition >= mise_a_prit) {
				// si la proposition est superieur ou egale a la mise a prit 
				
				if(proposition > meilleur_offre) {
					// la propostion est superieur a la meilleur offre et la meilleur offre 
					
					Utilisateur user = new Utilisateur(); 
					user.setNo_utilisateur(id_user);
					
					ArticleVendu article= new ArticleVendu(); 
					article.setNo_article(id_article);
					
					LocalDate now = LocalDate.now();
			
					Enchere enchere = new Enchere(now, proposition);
					
					articleDao.send_payement(user, article, enchere);
					
				}

			}
			
		} else {
			// pas assez de monaie pour encherire
			
		}

	}
	
}
