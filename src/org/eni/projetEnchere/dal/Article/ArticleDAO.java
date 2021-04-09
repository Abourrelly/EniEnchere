/**
 * 
 */
package org.eni.projetEnchere.dal.Article;

import java.util.Collection;
import java.util.List;

import org.eni.projetEnchere.bo.ArticleVendu;

/**
 * @author var_dump
 *
 */
public interface ArticleDAO {

	public ArticleVendu sale_article(int id, ArticleVendu article, int id_categorie) throws Exception;
	
	public List<ArticleVendu> get_all_article() throws Exception;

}
