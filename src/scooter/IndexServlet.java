package scooter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/home")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

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

		request.getSession().setAttribute("language", localeString);
		request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

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
		response.sendRedirect("home");
	}

}
