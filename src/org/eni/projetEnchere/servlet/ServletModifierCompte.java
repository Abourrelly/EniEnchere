package org.eni.projetEnchere.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eni.projetEnchere.bll.UserManager;

/**
 * Servlet implementation class ServletModifierCompte
 */
@WebServlet("/ServletModifierCompte")
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		UserManager userManager = new UserManager();
		
		try {
			
			// recuperation de la session
			HttpSession session = request.getSession();
			
			String id = (String)session.getAttribute("no_utilisateur");
			
			int id_int = Integer.parseInt(id);
			
			if(id_int != 0) {
				
				// recuperation de tout les parametre
				String pseudo = request.getParameter("pseudo");
		    	String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String email = request.getParameter("email");
				String telephone = request.getParameter("telephone");
				String rue = request.getParameter("rue");
				String code_postal = request.getParameter("code_postal");
				String ville = request.getParameter("ville");
				String mot_de_passe = request.getParameter("mot_de_passe");
				
				userManager.update_user(id_int, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe);
			
			}	
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
