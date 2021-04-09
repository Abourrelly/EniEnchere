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
//		articleDao.sale_article(17 ,new ArticleVendu("article_2", "blablablalblabla", "2020-11-12", "2020-11-12", 1, 15), 1);
//		articleDao.sale_article(17 ,new ArticleVendu("article_3", "aaaaaaaa", "2021-04-04", "2021-04-30", 1, 15), 1);
//		articleDao.sale_article(17 ,new ArticleVendu("article_4", "ccccccccccc", "2022-11-12", "2022-11-12", 1, 15), 1);
//	
		
//		1 = mes ventes, 
//		2 = non commencées, 
//		3 = en-cours 
//		4 = terminées
//		System.out.println(articleManager.get_all_article_user_connect(17, 4));
		
		articleManager.send_payement(17, 3, 1, 0, 1000, 300);
	
	}

}
