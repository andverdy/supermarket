package it.objectmethod.supermarket.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.supermarket.dao.ArticleDao;
import it.objectmethod.supermarket.dao.impl.ArticleDaoImpl;
import it.objectmethod.supermarket.model.Article;
import it.objectmethod.supermarket.model.ArticleCart;

public class AddArticleToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleDao articleDao = new ArticleDaoImpl();

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codArt = request.getParameter("codArt");

		ArticleCart articleCart = null;

		HttpSession session = request.getSession();
		String message = null;
		Map<String, ArticleCart> cart = new HashMap<String, ArticleCart>();
		if (session.getAttribute("cart") != null) {
			cart = (Map<String, ArticleCart>) session.getAttribute("cart");
		}

		if (cart.containsKey(codArt)) {
			articleCart = cart.get(codArt);
		} else {
			Article article = this.articleDao.getArticleByCode(codArt);
			articleCart = (ArticleCart) article;
		}
		articleCart.setQuantita(articleCart.getQuantita() + 1);
		cart.put(codArt, articleCart);
		session.setAttribute("cart", cart);
		message = "ARTICOLO AGGIUNTO AL CARRELLO!";

		request.setAttribute("messageInsert", message);
		RequestDispatcher forward = request.getServletContext().getRequestDispatcher("/GetArticles");
		forward.forward(request, response);

	}

}
