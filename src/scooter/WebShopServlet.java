package scooter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

		if (request.getSession().getAttribute("language") == null
				|| request.getSession().getAttribute("language") == "") {
			request.getSession().setAttribute("language", "nb_NO");
		} else {
			System.out.println("Locale has been set by user");
		}

		String locale = (String) request.getSession().getAttribute("language");
		String langCode = "";
		double currencyMultiplier = 1;
		if (locale.equals("nb_NO")) {
			langCode = "NB";
			currencyMultiplier = 9.936;
		} else if (locale.equals("en_US")) {
			langCode = "EN";
			currencyMultiplier = 1.108;
		} else {
			langCode = "DE";
		}
		System.out.println(locale);
		System.out.println(langCode);

		DescriptionEAO descriptionEAO = new DescriptionEAO();
		ArrayList<Description> descriptions = new ArrayList<Description>();
		for (Description d : descriptionEAO.getDescriptions()) {
			if (d.getLangCode().equals(langCode)) {
				descriptions.add(d);
			}
		}
		Collections.sort(descriptions);
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
		if (request.getParameter("language") != null) {
			String locale = (String) request.getParameter("language");
			request.getSession().setAttribute("language", locale);
		}
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
