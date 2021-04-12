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

/**
 * Servlet implementation class ServletSuppressionCompte
 */
@WebServlet("/ServletSuppressionCompte")
public class ServletSuppressionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSuppressionCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserManager userManager = new UserManager();
		
		try {
			
			// recuperation de la session
			HttpSession session = request.getSession();
			
			String id = (String)session.getAttribute("no_utilisateur");
			
			int id_int = Integer.parseInt(id);
			
			if(id_int != 0) {
			
				request.getSession().invalidate();
			
				userManager.deleteUser(id_int);
				
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/accueil.jsp");
	        rd.forward(request, response);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
