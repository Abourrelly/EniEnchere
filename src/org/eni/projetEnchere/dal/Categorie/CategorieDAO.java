/**
 * 
 */
package org.eni.projetEnchere.dal.Categorie;

import java.util.List;

import org.eni.projetEnchere.bo.Categorie;


/**
 * @author var_dump
 *
 */
public interface CategorieDAO {

	public List<Categorie> getAll() throws Exception;
	public Categorie getById(int id) throws Exception;

}
