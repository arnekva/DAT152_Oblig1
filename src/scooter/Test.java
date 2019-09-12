package scooter;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		ProductEAO productEAO = new ProductEAO();
		Cart cart = new Cart();
		
		Locale en_US = Locale.US;
		Locale nb_NO = new Locale("nb");
		Locale ge_GE = Locale.GERMAN;
		
		ArrayList<Product> products = productEAO.createAllProducts();

		Scanner tast = new Scanner(System.in);
		String help = "call: See alle varer \nadd:Skriv add, trykk enter, så følg opp med varenummeret og trykk enter."
				+ "\ncart: Se carten din";

		System.out.println("Velkommen til The Big Cup Store! Skriv 'help' for en liste over kommandoer:");
		
		String added ="";
		String error ="";
		String itemsincart = "";
		
		
		Locale currentLocale = nb_NO;
		
		boolean finished = false;
		while (!finished) {

			String input = tast.nextLine();

			switch (input) {
			case "call":
				for (int i = 0; i < products.size(); i++) {
					System.out.println(products.get(i).toString());
				}
				break;
			case "add":
				try {
					int nr = tast.nextInt();
					tast.nextLine();
					for (int j = 0; j < products.size(); j++) {
						if (products.get(j).getProdnr() == nr) {
							cart.addItem(products.get(j));
							System.out.println("Vare lagt til");
						}
					}

				} catch (Exception e) {
					System.out.println("fuck you");
				}
				break;
			case "cart":
				System.out.println("Du har følgende varer i handlekurven: ");
				for (int i = 0; i < cart.getItems().size(); i++) {
					System.out.println(cart.getItems().get(i));
				}
				break;
			case "help":
				System.out.println(help);
				break;
			case "done":
				finished = true;
				System.out.println("Takk for besøket, velkommen igjen :-)");
				break;
			default:
				System.out.println("Denne kommandoen gjenkjente vi ikke. Prøv på ny. Skriv 'help' for listen igjen.");
				break;
			}

		}

	}

}
