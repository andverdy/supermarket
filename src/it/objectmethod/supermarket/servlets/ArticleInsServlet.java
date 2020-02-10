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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cod = request.getParameter("codice");
		String descr = request.getParameter("descriz");
		int pzCart = Integer.parseInt(request.getParameter("pezziCart"));
		int iVa = Integer.parseInt(request.getParameter("iva"));
		int fms = Integer.parseInt(request.getParameter("fam"));

		int result = 0;
		String message;

		Article newArticle = new Article();
		newArticle.setCodArt(cod);
		newArticle.setDescrizione(descr);
		newArticle.setPzCart(pzCart);
		newArticle.setIdIva(iVa);
		newArticle.setIdFamAss(fms);

		ArticleDao artDaoImpl = new ArticleDaoImpl();

		if (artDaoImpl.getArticleByCode(newArticle.getCodArt()) != null) {
			result = artDaoImpl.update(newArticle);
		} else {
			result = artDaoImpl.insert(newArticle);
		}

		if (result == 1) {
			message = "INSERIMENTO AVVENUTO CON SUCCESSO!";
		} else {
			message = "ERRORE INSERIMENTO!";
		}

		request.setAttribute("messageInsert", message);
		RequestDispatcher forward = request.getServletContext().getRequestDispatcher("/GetArticles");
		forward.forward(request, response);

	}

}
