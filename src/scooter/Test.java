package scooter;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		ProductEAO productEAO = new ProductEAO();
		Cart cart = new Cart();
		
		System.out.println("Current Locale: " + Locale.getDefault());
		ResourceBundle storeBundle = ResourceBundle.getBundle("store");
		
		
		ArrayList<Product> products = productEAO.createAllProducts();

		Scanner tast = new Scanner(System.in);


		System.out.println(storeBundle.getString("welcome_message"));
		
		
		
		Locale currentLocale = Locale.getDefault();
		
		
		boolean finished = false;
		while (!finished) {
			
			
			System.out.println(storeBundle.getString("new_input_message"));
			
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
							System.out.println(storeBundle.getString("vare_added_message"));
						}
					}

				} catch (Exception e) {
					System.out.println("fuck you");
				}
				break;
			case "cart":
				System.out.println(storeBundle.getString("varer_i_kurv_message"));
				for (int i = 0; i < cart.getItems().size(); i++) {
					System.out.println(cart.getItems().get(i));
				}
				break;
			case "help":
				System.out.println(storeBundle.getString("help_message"));
				break;
			case "done":
				finished = true;
				System.out.println(storeBundle.getString("welcome_back_message"));
				break;
			case "german":
				System.out.println("Wechselt zu Deutsch");
				Locale.setDefault(new Locale("de", "DE"));
				storeBundle = ResourceBundle.getBundle("store");
				break;
				
			case "english":
				System.out.println("Changing to English");
				Locale.setDefault(new Locale("en", "US"));
				storeBundle = ResourceBundle.getBundle("store");
				break;
			case "norsk":
				System.out.println("Bytter til norsk");
				Locale.setDefault(new Locale("nb", "NO"));
				storeBundle = ResourceBundle.getBundle("store");
				break;
			default:
				System.out.println(storeBundle.getString("uknown_command_message"));
				break;
			}

		}

	}

}
