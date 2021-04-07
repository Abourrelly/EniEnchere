/**
 *
 */
package projetenchere.dal.User;


import projetenchere.bo.Utilisateur;

/**
 * @author var_dump
 *
 */
public class test {

	/**
	 * @param args
	 * @throws Exception
	 */

	static UserDAO userDao = DAOFactory.getUserDAO();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		userDao.subscribe(new Utilisateur("gatow", "saav", "gaetan", "g@g.co", "0658454545", "9", "35000", "dinan", "bla", 0, 0));

	}

}
