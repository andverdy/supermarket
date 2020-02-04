package it.objectmethod.supermarket.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.supermarket.dao.FamAssortDao;
import it.objectmethod.supermarket.dao.IvaDao;
import it.objectmethod.supermarket.dao.impl.FamAssortDaoImpl;
import it.objectmethod.supermarket.dao.impl.IvaDaoImpl;
import it.objectmethod.supermarket.model.FamAssort;
import it.objectmethod.supermarket.model.Iva;

public class FormViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		List<Iva> listIva;
		List<FamAssort> listFamAssort = new ArrayList<>();

		IvaDao ivaDao = new IvaDaoImpl();
		FamAssortDao fmsDao = new FamAssortDaoImpl();

		listIva = ivaDao.getIva();
		listFamAssort = fmsDao.getFamAssort();

		request.setAttribute("ivaList", listIva);
		request.setAttribute("listFms", listFamAssort);
		request.getRequestDispatcher("WEB-INF/pages/formIns.jsp").forward(request, response);

	}

}
