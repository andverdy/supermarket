package it.objectmethod.supermarket.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String idIva = "1";
		String descrizIva = "esente";
		
		
		request.setAttribute("iva", idIva);
		request.getRequestDispatcher("WEB-INF/pages/formIns.jsp").forward(request, response);
		
	}

	
	
	
	

}
