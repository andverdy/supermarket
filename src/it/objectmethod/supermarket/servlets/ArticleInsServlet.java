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
		
		String cod = request.getParameter("codice");
		String descr = request.getParameter("descriz");
		int pzCart = Integer.parseInt(request.getParameter("pezziCart"));
		int iVa = Integer.parseInt(request.getParameter("iva"));
		int fms = Integer.parseInt(request.getParameter("fam"));

		Article newArticle;
		ArticleDao artDaoImpl = new ArticleDaoImpl();
		artDaoImpl.insArticle(new Article(cod, descr, pzCart, iVa, fms));
		
		
		/*System.out.println("parametro codice passato??? " + cod);
		System.out.println("parametro descrizione passato??? " + descr);
		System.out.println("parametro pezzi cartone passato??? " + pzCart);
		System.out.println("parametro iva passato??? " + iVa);
		System.out.println("parametro fms passato??? " + fms);*/
		
		
		request.getRequestDispatcher("WEB-INF/pages/home.jsp").forward(request, response);
		
		
		
	}

}
