package org.eni.projetEnchere.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		
//		Cookie[] cookies = request.getCookies();
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		UserManager userManager = new UserManager();

		try {
			int id = userManager.connect(input, password);
			
//			Integer idPrim = new Integer(id); 
			
			if(id != 0) {
				
//				String idStr = idPrim.toString();
//				
//				if(cookies == null){
//					
//					Cookie cId = new Cookie("idUser", idStr);
//					cId.setMaxAge(9999999);
//					response.addCookie(cId);
//					
//				} else {
					
//					
//					for(Cookie cId:cookies){
//						
//						System.out.println(cId.getName() + "=" + cId.getValue());
//					
//					}
//				}

				// recuperation de la session
				HttpSession session = request.getSession();

				int connect = 0;

				if(session.getAttribute("connect") == null) {
					connect = 1;
					session.setAttribute("connect", connect);
					session.setAttribute("utilisateur", userManager.getInfosProfile(id));
				}
				RequestDispatcher rd = request.getRequestDispatcher("/accueil.jsp");
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
