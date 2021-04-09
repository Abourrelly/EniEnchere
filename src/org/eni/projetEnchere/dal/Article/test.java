/**
 * 
 */
package org.eni.projetEnchere.dal.Article;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;

import org.eni.projetEnchere.bll.ArticleManager;
import org.eni.projetEnchere.bo.ArticleVendu;
import org.eni.projetEnchere.dal.Article.DAOFactory;
import org.eni.projetEnchere.dal.Article.ArticleDAO;

/**
 * @author var_dump
 *
 */
public class test {

	/**
	 * @param args
	 */
	static ArticleDAO articleDao = DAOFactory.getArticleDAO();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ArticleManager articleManager = new ArticleManager();
		
		//Date now = new Date();
//		
//		SimpleDateFormat formater = null;
//		
//		Date now = new Date();
//		
//		formater = new SimpleDateFormat("yyyy-MM-dd");
//		
//		String now_format_string = formater.format(now);
//		
//		articleDao.sale_article(17 ,new ArticleVendu("article_1", "blablablalblablablalblablablalblablablal", now_format_string, now_format_string, 1, 15), 1);
//	
		System.out.println(articleDao.get_all_article());
	
	}

}
