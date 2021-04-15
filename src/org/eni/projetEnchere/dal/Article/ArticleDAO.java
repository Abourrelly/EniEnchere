/**
 * 
 */
package org.eni.projetEnchere.dal.Article;

import java.util.Collection;
import java.util.List;

import org.eni.projetEnchere.bo.ArticleVendu;
import org.eni.projetEnchere.bo.Enchere;
import org.eni.projetEnchere.bo.Retrait;
import org.eni.projetEnchere.bo.Utilisateur;

/**
 * @author var_dump
 *
 */
public interface ArticleDAO {

	public ArticleVendu saleArticle(Utilisateur user, ArticleVendu article, Retrait retrait, int idCategorie) throws Exception;
	
	public List<ArticleVendu> getAllArticleUserConnect() throws Exception; //int id

	public List<ArticleVendu> getAllArticleUserDisconnect() throws Exception;
	
	public ArticleVendu sendPayement(Utilisateur user, ArticleVendu article, Enchere enchere) throws Exception;

	public ArticleVendu getInfosArticle(int id) throws Exception;
	
	public Enchere getInfosUserBestEnchereForArticle(int id) throws Exception;
	
	public Retrait getInfosRetraitForArticle(int id) throws Exception;
	
	public ArticleVendu selectByIdUser(int id) throws Exception;

}
