package it.objectmethod.supermarket.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.supermarket.dao.ArticleDao;
import it.objectmethod.supermarket.dao.FamAssortDao;
import it.objectmethod.supermarket.dao.IvaDao;
import it.objectmethod.supermarket.dao.impl.ArticleDaoImpl;
import it.objectmethod.supermarket.dao.impl.FamAssortDaoImpl;
import it.objectmethod.supermarket.dao.impl.IvaDaoImpl;
import it.objectmethod.supermarket.model.Article;
import it.objectmethod.supermarket.model.FamAssort;
import it.objectmethod.supermarket.model.Iva;

public class FormViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Article article = null;
		String codArt = request.getParameter("getCod");

		if (codArt != null) {
			ArticleDao articleDao = new ArticleDaoImpl();
			article = articleDao.getArticleByCode(codArt);
		}

		List<Iva> listIva;
		List<FamAssort> listFamAssort;

		IvaDao ivaDao = new IvaDaoImpl();
		FamAssortDao fmsDao = new FamAssortDaoImpl();

		listIva = ivaDao.getIva();
		listFamAssort = fmsDao.getFamAssort();

		request.setAttribute("ivaList", listIva);
		request.setAttribute("listFms", listFamAssort);
		request.setAttribute("articleFormRefresh", article);
		request.getRequestDispatcher("WEB-INF/pages/formIns.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
