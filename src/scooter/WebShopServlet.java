package scooter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WebShopServlet
 */
@WebServlet("/products")
public class WebShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductEAO productEAO = new ProductEAO();
	Cart cart;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WebShopServlet() {
		super();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjon = null;
		if (request.getSession(false) == null) {
			sesjon = request.getSession(true);
		} else {
			sesjon = request.getSession(false);
		}

		if (request.getSession().getAttribute("cart") == null) {
			cart = new Cart();
		} else {
			cart = (Cart) request.getSession().getAttribute("cart");
		}


		request.getSession().setAttribute("cart", cart);

		String localeString = "";
		//kjør en liten sjekk på cookie her
		if (request.getCookies() != null) {
			Cookie[] cookies = request.getCookies();
			Cookie langCookie = cookies[0];
			localeString = langCookie.getValue();
		} else {
			String acceptLanguage = request.getHeader("Accept-Language");
			localeString = acceptLanguage.substring(0, 2) + "_" + acceptLanguage.substring(3, 5).toUpperCase();
		}
		
		request.getSession().setAttribute("language", localeString);

		
		String langCode = "";
		double currencyMultiplier = 1;
		if (localeString.equals("nb_NO")) {
			langCode = "NB";
			currencyMultiplier = 9.936;
		} else if (localeString.equals("en_US")) {
			langCode = "EN";
			currencyMultiplier = 1.108;
		} else {
			langCode = "DE";
		}
		

		DescriptionEAO descriptionEAO = new DescriptionEAO();
		ArrayList<Description> descriptions = descriptionEAO.getDescriptionsByLangCode(langCode);
		productEAO = new ProductEAO();
		ArrayList<Product> rightPriceTiles = productEAO.getProducts();
		for (Product p : rightPriceTiles) {
			p.setPris(p.getPris()*currencyMultiplier);
		}
		request.getSession().setAttribute("products", rightPriceTiles);
		request.getSession().setAttribute("descriptions", descriptions);

		request.getRequestDispatcher("WEB-INF/products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cart = (Cart) request.getSession().getAttribute("cart");
		Product cartItem;
//		if (request.getParameter("language") != null) {
//			String locale = (String) request.getParameter("language");
//			request.getSession().setAttribute("language", locale);
//		}
		if (request.getParameter("prodnr") != null) {
			try {

				cartItem = productEAO.getProduct(Integer.parseInt(request.getParameter("prodnr")));
				System.out.println(cartItem);
				cart.addItem(cartItem);
			} catch (Exception e) {
				System.out.println("Hmm.. dette ser ikke ut som et gyldig produkt.");
			}
		}
		request.getSession().setAttribute("cart", cart);
		response.sendRedirect("products");

	}

}
