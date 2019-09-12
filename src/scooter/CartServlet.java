package scooter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	ProductEAO productEAO = new ProductEAO();
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesjon = null;
//		if (request.getSession() == null) {
//			response.sendRedirect("webshop");
//		}
		
		
		if(request.getSession().getAttribute("language") == null || request.getSession().getAttribute("language") == "") {
			request.getSession().setAttribute("language", "nb_NO");
		} else {
			System.out.println("Locale has been set by user");
		}
		request.getRequestDispatcher("WEB-INF/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String removeThis = request.getParameter("prodnr");
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		if(productEAO.findProduct(removeThis) != null) {
			System.out.println("whaaat");
		cart.removeItem(productEAO.findProduct(removeThis));
		
		request.getSession().setAttribute("cart", cart);
		} else {
			response.sendRedirect("cart");
		}
		response.sendRedirect("cart");
		
	}

}
