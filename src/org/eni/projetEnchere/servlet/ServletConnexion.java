package org.eni.projetEnchere.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.eni.projetEnchere.bll.UserManager;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

		String input = request.getParameter("identifiant");
		String password = request.getParameter("password");

		UserManager userManager = new UserManager();

		try {
			int id = userManager.connect(input, password);
			if(id != 0) {
				// recuperation de la session
				HttpSession session = request.getSession();

				int connect = 0;

				if(session.getAttribute("connect") == null) {
					connect = 1;
					session.setAttribute("connect", connect);
					session.setAttribute("utilisateur", userManager.getInfosProfile(id));
				}
				RequestDispatcher rd = request.getRequestDispatcher("/accueil");
		        rd.forward(request, response);
			} else {
				String message = "Votre identifiant/mot de passe est erroné";
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		        rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	doGet(request, response);
        
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
        rd.forward(request, response);
    }
}
