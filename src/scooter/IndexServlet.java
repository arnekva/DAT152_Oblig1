package scooter;

import java.io.IOException;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
		request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//TODO: skrive kode for å hente language attributt fra jsp og sende den videre som cookie.
		// sjekk om det finnes cookie, hvis ikke opprett ny
		// hvis finnes, kjør cookie.setValue(atributten du hentet fra jsp)
		doGet(request, response);
	}

}
