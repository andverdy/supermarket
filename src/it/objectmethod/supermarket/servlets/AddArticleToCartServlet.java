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

		Article article = this.articleDao.getArticleByCode(codArt);

		ArticleCart articleCart = new ArticleCart();
		articleCart.setCodArt(article.getCodArt());
		articleCart.setDescrizione(article.getDescrizione());
		articleCart.setFamAssDesc(article.getFamAssDesc());
		articleCart.setIdFamAss(article.getIdFamAss());
		articleCart.setIdIva(article.getIdIva());
		articleCart.setIvaDesc(article.getIvaDesc());
		articleCart.setPzCart(articleCart.getPzCart());

		HttpSession session = request.getSession();
		String message = null;

		if (session.getAttribute("cart") == null) {
			Map<String, ArticleCart> cart = new HashMap<String, ArticleCart>();
			articleCart.setQuantita(articleCart.getQuantita() + 1);
			cart.put(codArt, articleCart);
			session.setAttribute("cart", cart);
		}

		else if (session.getAttribute("cart") != null) {
			Map<String, ArticleCart> cart = (Map<String, ArticleCart>) session.getAttribute("cart");
			if (cart.containsKey(codArt)) {
				cart.get(codArt).setQuantita(cart.get(codArt).getQuantita() + 1);
			} else {
				articleCart.setQuantita(articleCart.getQuantita() + 1);
				cart.put(codArt, articleCart);
			}
			session.setAttribute("cart", cart);
		}

		message = "ARTICOLO AGGIUNTO AL CARRELLO!";

		request.setAttribute("messageInsert", message);
		RequestDispatcher forward = request.getServletContext().getRequestDispatcher("/GetArticles");
		forward.forward(request, response);

	}

}
