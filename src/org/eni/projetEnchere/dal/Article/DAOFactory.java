/**
 * 
 */
package org.eni.projetEnchere.dal.Article;

import org.eni.projetEnchere.dal.Article.ArticleDAO;
import org.eni.projetEnchere.dal.Article.ArticleDaoJDBCImpl;

/**
 * @author var_dump
 *
 */
public class DAOFactory {
	public static ArticleDAO getArticleDAO() {
		return new ArticleDaoJDBCImpl();
	}
}
