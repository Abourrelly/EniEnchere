package org.eni.projetEnchere.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eni.projetEnchere.bll.ArticleManager;

/**
 * Servlet implementation class ServletCreationCompte
 */
@WebServlet("/creationEnchere")
public class ServletCreationEnchere extends HttpServlet {
	private static final long serialVersionUID = 4L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCreationEnchere() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/newEnchere.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleManager articlemanager = new ArticleManager();
		try {
			articlemanager.saleArticle(
					Integer.parseInt(request.getParameter("idUser")) , 
					request.getParameter("nom"), 
					request.getParameter("description"), 
					request.getParameter("dateDebutEnchere"), 
					request.getParameter("dateFinEnchere"), 
					0, 
					Integer.parseInt(request.getParameter("prix")), 
					Integer.parseInt(request.getParameter("categorie")), 
					request.getParameter("rue"),
					request.getParameter("codePostale"), 
					request.getParameter("ville"));
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/accueil");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
