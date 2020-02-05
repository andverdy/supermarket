package it.objectmethod.supermarket.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.supermarket.dao.ArticleDao;
import it.objectmethod.supermarket.dao.FamAssortDao;
import it.objectmethod.supermarket.dao.impl.ArticleDaoImpl;
import it.objectmethod.supermarket.dao.impl.FamAssortDaoImpl;
import it.objectmethod.supermarket.model.Article;
import it.objectmethod.supermarket.model.FamAssort;

public class ArticlesGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ArticlesGetServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		Map<Article,String> mapArticles = null;

		ArticleDao articleDao = new ArticleDaoImpl();
		mapArticles = articleDao.getArticles();

		System.out.println("sono nel doGet ");
		
		FamAssortDao fmsDao = new FamAssortDaoImpl();
		List<FamAssort> listFamAssort = fmsDao.getFamAssort();
		
		request.setAttribute("mapArticles", mapArticles);
		request.setAttribute("listFamAssort", listFamAssort);
		request.getRequestDispatcher("WEB-INF/pages/home.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
