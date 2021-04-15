/**
 * 
 */
package org.eni.projetEnchere.dal.Categorie;

/**
 * @author var_dump
 *
 */
public class DAOFactory {
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDaoJDBCImpl();
	}
}
