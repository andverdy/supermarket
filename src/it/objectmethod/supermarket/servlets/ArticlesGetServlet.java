package it.objectmethod.supermarket.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.objectmethod.supermarket.dao.ArticleDao;
import it.objectmethod.supermarket.dao.impl.ArticleDaoImpl;
import it.objectmethod.supermarket.model.Article;

public class ArticlesGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArticlesGetServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		List<Article> listArticles = new ArrayList<>();

		ArticleDao articleDao = new ArticleDaoImpl();
		listArticles = articleDao.getArticles();

		request.setAttribute("articlesList", listArticles);
		request.getRequestDispatcher("WEB-INF/pages/home.jsp").forward(request, response);

	}

	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
		


		
		
	}

}
