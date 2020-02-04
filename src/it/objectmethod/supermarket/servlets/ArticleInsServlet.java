package it.objectmethod.supermarket.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.supermarket.dao.ArticleDao;
import it.objectmethod.supermarket.dao.impl.ArticleDaoImpl;
import it.objectmethod.supermarket.model.Article;

public class ArticleInsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cod = request.getParameter("codice");
		String descr = request.getParameter("descriz");
		int pzCart = Integer.parseInt(request.getParameter("pezziCart"));
		int iVa = Integer.parseInt(request.getParameter("iva"));
		int fms = Integer.parseInt(request.getParameter("fam"));

		Article newArticle = new Article();
		newArticle.setCodArt(cod);
		newArticle.setDescrizione(descr);
		newArticle.setPzCart(pzCart);
		newArticle.setIdIva(iVa);
		newArticle.setIdFamAss(fms);

		ArticleDao artDaoImpl = new ArticleDaoImpl();
		artDaoImpl.insArticle(newArticle);

		RequestDispatcher forward = request.getServletContext().getRequestDispatcher("/GetArticles");
		forward.forward(request, response);

	}

}
