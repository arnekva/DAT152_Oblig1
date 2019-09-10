package no.hvl.dat152;

//import static no.hvl.dat108.UrlMappings.LOGOUT_URL;
//import static no.hvl.dat108.UrlMappings.LOGIN_URL;
//import static no.hvl.dat108.UrlMappings.SHOPPINGCART_URL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/webshop")
public class WebShopServlet extends HttpServlet {
	public static final String LOGIN_URL = "login";
	public static final String SHOPPINGCART_URL = "webshop";
	public static final String LOGOUT_URL = "logout";
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Validering av sesjon. Hvis brukeren ikke har aktiv session blir han
		// redirected til LOGIN_URL for å logge på.
		HttpSession sesjon = request.getSession(false);
		if (sesjon == null || sesjon.getAttribute("bruker") == null) {

			response.sendRedirect(LOGIN_URL + "?requiresLogin");

		} else {

			String requiresValue = request.getParameter("requiresValue"); // Hvis brukeren har tastet inn en tom streng
			String alreadyExists = request.getParameter("alreadyExists"); // Hvis objektet som ble lagt til er en
																			// duplikat
//			String itemnameExists = request.getParameter("itemName");
			String itemNr = request.getParameter("itemNr"); // Hvis duplikat, hvilket duplikatnummer er det
			String invalidCharacter = request.getParameter("invalidCharacter"); // Hvis bruker taster inn ugyldig tegn
			String unknownAction = request.getParameter("unknownAction"); // Hvis bruker gjør en ulovlig handling.
			String feilmelding = "";

			if (requiresValue != null) {

				// Vi vet at det stod at det ikke skal vises feilmelding for dette, men vi mener
				// at applikasjonen burde det. Denne fjernes i så fall.
				feilmelding = "Du kan ikke legge til et tomt element. Ingenting har blitt lagret.";

			}
			if (invalidCharacter != null) {
				feilmelding = "Ugyldig tegn. Vennligst bruk <i>kun</i> bokstaver og tall";

			}
			if (unknownAction != null) {
				feilmelding = "Ukjent eller ulovlig handling. Vennligst prøv på ny.";
			}
			if (alreadyExists != null && !itemNr.equals("1")) {
				feilmelding = "Elementet " + alreadyExists
						+ " finnes allerede i handlekurven. Elementet er lagret, og er nummer " + itemNr
						+ " lagt til i listen.";
			}
			// Denne feilmeldingen viser bare at elementet allerede eksisterer, og
			// hvor mange duplikater som finnes
			String bruker = (String) sesjon.getAttribute("bruker");
			Cart cart = (Cart) sesjon.getAttribute("cart");

			response.setContentType("text/html; charset=ISO-8859-1");

			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<title>Handleliste</title>");
			out.println(
					"<style> .input { display: inline-block; -webkit-box-sizing: content-box; -moz-box-sizing: content-box; box-sizing: content-box; padding: 10px 20px; border: 1px solid #b7b7b7; -webkit-border-radius: 3px; border-radius: 3px; font: normal 16px/normal \"Lucida Console\", Monaco, monospace; color: rgba(0,0,0,1); -o-text-overflow: clip; text-overflow: clip; background: rgba(252,252,252,1); -webkit-box-shadow: 2px 2px 9px 1px rgba(0,0,0,0.2) inset; box-shadow: 2px 2px 9px 1px rgba(0,0,0,0.2) inset; -webkit-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1); -moz-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1); -o-transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1); transition: all 200ms cubic-bezier(0.42, 0, 0.58, 1);} .knapp { background-color:#44c767; -moz-border-radius:21px; -webkit-border-radius:21px; border-radius:21px; border:2px solid #066610; display:inline-block; cursor:pointer; color:#ffffff; font-family:Trebuchet MS; font-size:16px; padding:14px 24px; text-decoration:none; text-shadow:-2px 2px 4px #2f6627; } .knapp:hover { background-color:#5cbf2a; } .knapp:active { position:relative; top:1px; } .fjernKnapp { -moz-box-shadow:inset 0px -1px 0px 0px #cf866c; -webkit-box-shadow:inset 0px -1px 0px 0px #cf866c; box-shadow:inset 0px -1px 0px 0px #cf866c; background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #d0451b), color-stop(1, #bc3315)); background:-moz-linear-gradient(top, #d0451b 5%, #bc3315 100%); background:-webkit-linear-gradient(top, #d0451b 5%, #bc3315 100%); background:-o-linear-gradient(top, #d0451b 5%, #bc3315 100%); background:-ms-linear-gradient(top, #d0451b 5%, #bc3315 100%); background:linear-gradient(to bottom, #d0451b 5%, #bc3315 100%); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#d0451b', endColorstr='#bc3315',GradientType=0); background-color:#d0451b; -moz-border-radius:6px; -webkit-border-radius:6px; border-radius:6px; border:2px solid #942911; display:inline-block; cursor:pointer; color:#ffffff; font-family:Arial; font-size:14px; padding:6px 15px; text-decoration:none; text-shadow:0px 1px 0px #854629; } .fjernKnapp:hover { background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #bc3315), color-stop(1, #d0451b)); background:-moz-linear-gradient(top, #bc3315 5%, #d0451b 100%); background:-webkit-linear-gradient(top, #bc3315 5%, #d0451b 100%); background:-o-linear-gradient(top, #bc3315 5%, #d0451b 100%); background:-ms-linear-gradient(top, #bc3315 5%, #d0451b 100%); background:linear-gradient(to bottom, #bc3315 5%, #d0451b 100%); filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#bc3315', endColorstr='#d0451b',GradientType=0); background-color:#bc3315; } .fjernKnapp:active { position:relative; top:1px; }");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");

			out.println("<p>Du er innlogget som " + bruker + "</p>");

			out.println("<br/>");
			out.println("<form action=\"" + SHOPPINGCART_URL + "\" method=\"post\">");
			out.println("<fieldset>");
			out.println("<legend>Handleliste</legend>");
			out.println(
					"<input class=\"input\" type=\"text\" name=\"vareNavn\" placeholder=\"Varenavn\" onfocus=\"this.placeholder='Varenavn'\" onblur=\"this.placeholder='F.eks melk, brød'\" autofocus/><br/>");
			out.println("<p>" + feilmelding + "</p>");
			out.println(
					"<p><input class=\"knapp\" type=\"submit\" name=\"leggTil\" value=\"Legg i handlekurv\" /></p>");
			out.println("</form>");

			int i = 0;
			/*
			 * En for-løkke for å printe ut alle elementer ved hver get-request. Telleren og
			 * if-setningen gjør bare kosmetiske endringer slik at det skal se bedre ut.
			 * "Fjern Alle"-knappen er gjemt helt til det blir 2 eller flere elementer.
			 * 
			 * Kjører egen <form> for alle elementer, slik at "fjern"-knappen blir koblet
			 * opp til rett hidden value.
			 * 
			 * Dersom vi ikke kjører egne forms, vil det første elementet i listen bli
			 * fjernet, uavhengig av hvilken knapp som ble trykket på.
			 */
			for (CartItem item : cart.getItems()) {

				if (i == 0) {
					out.println("<hr>");
					out.println(
							"<p style=\"float:left; margin-left:20%;display:inline; width: 80%;font: normal 16px/normal Lucida Console, Monaco, monospace;\"> Varer i handlelisten: </p>");
				}
				i++;
				out.println("<form action=\"" + SHOPPINGCART_URL + "\" method=\"post\">");
				// Ny form for hver fjern-knapp, slik at den henter rett verdi

				out.println(
						"<input style=\"float:left; display:inline;width:15%;\" class=\"fjernKnapp\" type=\"submit\" name=\"fjern\" value=\"fjern\" /> ");

				out.println(
						"<p style=\"float:left; margin-left:5%;display:inline; width: 80%;font: normal 16px/normal Lucida Console, Monaco, monospace;\" name=\"verdi\" >"
								+ item.getName() + "</p>");

				// Hidden paramater for å sende navnet på gjenstanden/item.
				out.println("<input type=\"hidden\" name=\"hiddenValue\" value=\"" + item.getName() + "\"/>");

				out.println("</form>");

			}
			if (i > 1) {
				out.println("<p><input class=\"knapp\" type=\"submit\" name=\"fjernAlle\" value=\"Fjern Alle\" /></p>");
			}
			out.println("</fieldset>");
			out.println("</form>");

			// Logout er bare en del av testing, og skal ikke være med i oppgaven
			out.println("<form action=\"" + LOGOUT_URL + "\" method=\"get\">");
			out.println("<fieldset>");
			out.println("<p><input type=\"submit\" value=\"Logg ut\" /></p>");
			out.println("</fieldset>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tillatChars = "^[a-zæøåA-ZÆØÅ0-9 .]+$"; // regex-uttrykk som definerer lovlige characters.

		// Validering av session.
		HttpSession sesjon = request.getSession(false);
		if (sesjon == null || sesjon.getAttribute("bruker") == null) {
			if (sesjon == null) {
				response.sendRedirect(LOGIN_URL + "?sessionTimeout");
			} else {
				response.sendRedirect(LOGIN_URL + "?requiresLogin");
			}

		} else {

			// Sjekk om bruker har trykket på fjern-, LeggTil eller FjernAlle-knapp
			if (request.getParameter("fjern") != null) {
//				Cart cart = (Cart) sesjon.getAttribute("cart");

				CartItem cartG = new CartItem(request.getParameter("hiddenValue"));
				// her oppretter vi et nytt element med verdien til hidden parameter i form-en
				// til
				// knappen som ble trykket på. Må være cartItem slik at vi kan sammenligne i
				// CartItem-klassen.

				
				response.sendRedirect(SHOPPINGCART_URL);

			} else if (request.getParameter("leggTil") != null) {
				if (!(request.getParameter("vareNavn") == null)) {
					// sjekker at dersom "leggTil"-knappen blir trykket på, så MÅ det sendes en
					// parameter ved navn "vareNavn". På den måten kan ikke brukeren tukle med
					// parameterene.
					if (request.getParameter("vareNavn").trim().isEmpty()) {
						response.sendRedirect(SHOPPINGCART_URL + "?requiresValue");

					} else if (!request.getParameter("vareNavn").matches(tillatChars)) {

						response.sendRedirect(SHOPPINGCART_URL + "?invalidCharacter");
					} else {

//						Cart cart = (Cart) sesjon.getAttribute("cart");
						CartItem item = new CartItem(request.getParameter("vareNavn"));
						/*
						 * Å sjekke om item allerede eksisterer er ikke nødvendig, men tenkt at det er
						 * en veldig lang liste (mtp at mange jobber på den samtidig) kan det være greit
						 * å gi brukeren beskjed ved duplikater.
						 */
//						if (cart.doesExistsInt(item) > 0) {
//							cart.addItem(item);
//							
//							int nummer = cart.doesExistsInt(item);
//							response.sendRedirect(
//									SHOPPINGCART_URL + "?alreadyExists=" + item.getName() + "&itemNr=" + nummer);
//						} else {
//							cart.addItem(item);
//							// henter ut value fra input field vareNavn som vi sender.
//							response.sendRedirect(SHOPPINGCART_URL);
//						}
	
					}
				} else {
					response.sendRedirect(SHOPPINGCART_URL + "?unknownAction");
					// igjen, hvis bruker har tuklet med paramatere vil det ikke bli godkjent.
				}
			} else if (request.getParameter("fjernAlle") != null) {
//				Cart cart = (Cart) sesjon.getAttribute("cart");
//				cart.removeAll();
				response.sendRedirect(SHOPPINGCART_URL);
			} else {
				response.sendRedirect(SHOPPINGCART_URL + "?unknownAction");
			}

		}
	}

	public boolean isAllowed(String string) {
		String tillatChars = "^[a-zæøåA-ZÆØÅ0-9 .]+$";
		if (string.matches(tillatChars) && !string.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
