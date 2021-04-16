package org.eni.projetEnchere.servlet;

import org.eni.projetEnchere.bll.UserManager;
import org.eni.projetEnchere.bo.Utilisateur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletCreationCompte
 */
@WebServlet("/creation")
public class ServletCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCreationCompte() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/creationCompte.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter("pseudo");
    	String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("newPassword");
		String confirmPass = request.getParameter("confirmPass");
		
		UserManager userManager = new UserManager();
		
			try {
							
				//Utilisateur user = 
				userManager.subscribe(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 0, 0);
			
				// recuperation de la session
				HttpSession session = request.getSession();
				
				int connect = 0;
				
				if(session.getAttribute("connect") == null) {
					
					connect = 1;
					
					session.setAttribute("connect", connect);
				
				}

				RequestDispatcher rd = request.getRequestDispatcher("/accueil");
		        rd.forward(request, response);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
