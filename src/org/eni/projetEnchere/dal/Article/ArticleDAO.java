/**
 * 
 */
package org.eni.projetEnchere.dal.Article;

import org.eni.projetEnchere.bo.ArticleVendu;

/**
 * @author var_dump
 *
 */
public interface ArticleDAO {

	public ArticleVendu sale_article(ArticleVendu article) throws Exception;

}
