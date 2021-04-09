/**
 * 
 */
package org.eni.projetEnchere.dal.Article;

import java.util.Collection;
import java.util.List;

import org.eni.projetEnchere.bo.ArticleVendu;
import org.eni.projetEnchere.bo.Enchere;
import org.eni.projetEnchere.bo.Utilisateur;

/**
 * @author var_dump
 *
 */
public interface ArticleDAO {

	public ArticleVendu sale_article(int id, ArticleVendu article, int id_categorie) throws Exception;
	
	public List<ArticleVendu> get_all_article_user_connect(int id) throws Exception;

	public List<ArticleVendu> get_all_article_user_disconnect() throws Exception;
	
	public ArticleVendu send_payement(Utilisateur user, ArticleVendu article, Enchere enchere) throws Exception;

}
