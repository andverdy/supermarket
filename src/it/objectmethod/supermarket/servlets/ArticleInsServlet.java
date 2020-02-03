package it.objectmethod.supermarket.servlets;

import java.io.IOException;
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
		
		String codArt = request.getParameter("codart");
		String descrizione = request.getParameter("descrizione");
		int pzCart = Integer.parseInt(request.getParameter("pzcart"));
		int idIva = Integer.parseInt(request.getParameter("idiva"));
		int idStatoArt = Integer.parseInt(request.getParameter("idstatoArt"));
		int idFamAss = Integer.parseInt(request.getParameter("idfamAss"));

		Article newArticle = new Article(codArt, descrizione, pzCart, idIva, idStatoArt, idFamAss);
		ArticleDao artDaoImpl = new ArticleDaoImpl();
		artDaoImpl.insArticle(newArticle);
		response.sendRedirect("viewIns");
		
		
		
	}

}
