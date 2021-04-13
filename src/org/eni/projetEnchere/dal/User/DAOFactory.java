/**
 *
 */
package org.eni.projetEnchere.dal.User;

/**
 * @author var_dump
 *
 */
public class DAOFactory {

	public static UserDAO getUserDAO() {
		return new UserDaoJDBCImpl();
	}

}
