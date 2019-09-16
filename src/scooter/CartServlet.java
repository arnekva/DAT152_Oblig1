package scooter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesjon = null;
//		if (request.getSession() == null) {
//			response.sendRedirect("webshop");
//		}

		String localeString = "";
		// kjør en liten sjekk på cookie her

		Cookie[] cookies = request.getCookies();
		if (request.getCookies() != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("locale")) {
					localeString = cookie.getValue();
					System.out.println("The locale " + localeString + " has been found in the cookie, and is valid.");
				}
			}
		}
		if (localeString.equals("")) {
			Locale locale = request.getLocale();
			System.out
					.println("No valid cookie found, using Accept-Language from request header: " + locale.toString());
			localeString = locale.toString();
		}

		request.getSession().setAttribute("language", localeString);

		String langCode = "";
		double currencyMultiplier = 1;
		if (localeString.equals("nb_NO")) {
			System.out.println("Norwegian locale being used");
			langCode = "NB";
			currencyMultiplier = 9.936;
		} else if (localeString.equals("en_US")) {
			System.out.println("English locale being used");
			langCode = "EN";
			currencyMultiplier = 1.108;
		} else {
			System.out.println("German locale being used");
			langCode = "DE";
		}

		DescriptionEAO descriptionEAO = new DescriptionEAO();
		ArrayList<Description> allDescriptions = descriptionEAO.getDescriptions();
		Cart cart;
		if (request.getSession().getAttribute("cart") == null) {
			cart = new Cart();
		} else {
			cart = (Cart) request.getSession().getAttribute("cart");
		}
		ArrayList<Product> cartItems = cart.getItems();
		ArrayList<Description> descriptions = new ArrayList<Description>();
		for (Product p : cartItems) {
			for (int i = 0; i < allDescriptions.size(); i++) {
				if (p.getProdnr() == allDescriptions.get(i).getProdnr()
						&& allDescriptions.get(i).getLangCode().equals(langCode)) {
					descriptions.add(allDescriptions.get(i));
					i = allDescriptions.size();
				}
			}

		}

		productEAO = new ProductEAO();
		ArrayList<Product> rightPriceTiles = cartItems;
		// setter prisene i handlevognen tilbake til euro for så å konvertere mellom
		// valutaene
		for (Product p : rightPriceTiles) {
			Product defaultPrice = productEAO.getProduct(p.getProdnr());
			p.setPris(defaultPrice.getPris());
			p.setPris(p.getPris() * currencyMultiplier);
		}
		cart.setItems(rightPriceTiles);
		request.getSession().setAttribute("cart", cart);
		request.getSession().setAttribute("descriptions", descriptions);

		request.getRequestDispatcher("WEB-INF/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String removeThis = "";

		Cart cart = (Cart) request.getSession().getAttribute("cart");

		String newLanguage = request.getParameter("language");
		if (newLanguage != null) {
			if (request.getCookies() != null) {
				System.out.println("POST Request for language update. Locale selected was: " + newLanguage + ".");

				Cookie[] cookies = request.getCookies();
				boolean found = false;
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("locale")) {
						found = true;
						cookie.setValue(newLanguage);
						response.addCookie(cookie);
						System.out.println(cookie.getValue());

						System.out.println("Valid value in cookie was found. Updating locale");
					}
				}
				if (!found) {
					System.out.println("No valid cookie was found. Generating new cookie.");
					Cookie newLang = new Cookie("locale", newLanguage);
					System.out.println("Cookie created with name 'Locale' and value " + newLanguage);
					response.addCookie(newLang);
				}

			}
		}
//		if (request.getParameter("language") != null) {
//			String locale = (String) request.getParameter("language");
//			request.getSession().setAttribute("language", locale);
//		}
		if (request.getParameter("prodnr") != null) {
			removeThis = request.getParameter("prodnr");
			if (productEAO.findProduct(removeThis) != null) {
				System.out.println("whaaat");
				cart.removeItem(productEAO.findProduct(removeThis));

				request.getSession().setAttribute("cart", cart);
			} else {
				response.sendRedirect("cart");
			}
		}

		response.sendRedirect("cart");

	}

}
