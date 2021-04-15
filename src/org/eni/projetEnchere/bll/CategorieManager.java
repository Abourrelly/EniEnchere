/**
 * 
 */
package org.eni.projetEnchere.bll;

import java.util.List;

import org.eni.projetEnchere.bo.Categorie;
import org.eni.projetEnchere.dal.Categorie.CategorieDAO;
import org.eni.projetEnchere.dal.Categorie.DAOFactory;
/**
 * @author var_dump
 *
 */
public class CategorieManager {
	private CategorieDAO catDAO;

	public CategorieManager() {
		catDAO = DAOFactory.getCategorieDAO();
	}

	public List<Categorie> getAll() throws Exception {
		return catDAO.getAll();
	}
	
	public Categorie getById(int id) throws Exception {
		return catDAO.getById(id);
	}
}
