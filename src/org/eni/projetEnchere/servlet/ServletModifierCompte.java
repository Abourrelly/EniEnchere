package org.eni.projetEnchere.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eni.projetEnchere.bll.UserManager;
import org.eni.projetEnchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletModifierCompte
 */
@WebServlet("/modifierCompte")
public class ServletModifierCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserManager userManager = new UserManager();
		
		// recuperation de la session
		HttpSession session = request.getSession();

		if(session.getAttribute("connect") != null) {
		
			Utilisateur profil = (Utilisateur) session.getAttribute("utilisateur");
			
			int id = profil.getId();
			
			try {

				Utilisateur user = userManager.getInfosProfile(id);
				request.setAttribute("user", user);
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		UserManager userManager = new UserManager();
		
		try {
			
			// recuperation de la session
			HttpSession session = request.getSession();
			
			Utilisateur profil = (Utilisateur) session.getAttribute("utilisateur");
		
			int id = profil.getId();
			
			if(id != 0) {
				
				//recuperation de tout les parametre
				String pseudo = request.getParameter("pseudo");
		    	String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String email = request.getParameter("email");
				String telephone = request.getParameter("telephone");
				String rue = request.getParameter("rue");
				String codePostal = request.getParameter("cp");
				String ville = request.getParameter("ville");
				String motDePasse = request.getParameter("newPassword");

				userManager.updateUser(id, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
			
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/accueil.jsp");
	        rd.forward(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
