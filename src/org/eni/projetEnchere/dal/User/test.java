/**
 *
 */
package org.eni.projetEnchere.dal.User;

import org.eni.projetEnchere.dal.User.DAOFactory;
import org.eni.projetEnchere.dal.User.UserDAO;
import org.eni.projetEnchere.bll.UserManager;
import org.eni.projetEnchere.bo.Utilisateur;

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
		
		UserManager userManager = new UserManager();
		
		//userManager.deleteUser(16);
				
		//userManager.updateUser(17, "gatoww", "saav", "gaetan", "g@gss.co", "0658454545", "9", "35000", "dinan", "azerty");
		
		
		//Utilisateur user = userManager.getInfosProfile(17);
		//System.out.println(user);
		
		//Utilisateur user = userManager.subscribe("gatowsss", "saav", "gaetan", "g@gss.co", "0658454545", "9", "35000", "dinan", "bla", 0, 0);
		
//		boolean v = userManager.connect("g@gss.co", "bla");
//		
//		System.out.println(v);
		
		//userDao.subscribe(new Utilisateur("gatow", "saav", "gaetan", "g@g.co", "0658454545", "9", "35000", "dinan", "bla", 0, 0));		

	}

}
