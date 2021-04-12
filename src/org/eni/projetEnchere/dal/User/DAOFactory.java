/**
 *
 */
package org.eni.projetEnchere.dal.User;

import org.eni.projetEnchere.dal.User.UserDAO;
import org.eni.projetEnchere.dal.User.UserDaoJDBCImpl;

/**
 * @author var_dump
 *
 */
public class DAOFactory {

	public static UserDAO getUserDAO() {
		return new UserDaoJDBCImpl();
	}

}
