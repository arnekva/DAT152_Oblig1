package scooter;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		ProductEAO productEAO = new ProductEAO();
		Cart cart = new Cart();

		ArrayList<Product> products = productEAO.createAllProducts();

		Scanner tast = new Scanner(System.in);
		String help = "call: See alle varer \nadd:Skriv add, trykk enter, så følg opp med varenummeret og trykk enter."
				+ "\ncart: Se carten din";
		
		System.out.println("Velkommen til The Big Cup Store! Her er en liste over kommandoer:");
		System.out.println(help);
		boolean finished = false;
		while(!finished) {
			
		String input = tast.nextLine();
		
		switch (input) {
		case "call": 
			for(int i = 0; i<products.size();i++) {
				System.out.println(products.get(i).toString());
			}
		case "add":
			try {
			int nr = tast.nextInt();tast.nextLine();
			Product nyprod = products
			cart.addItem(item);
			} catch(Exception e) {
				System.out.println("fuck you");
			}
		case "cart":
			
		case "help":
			System.out.println(help);
		case "done":
			finished = true;
		default:
			System.out.println("Denne kommandoen gjenkjente vi ikke. Prøv på ny. Skriv 'help' for listen igjen.");
		}
		
		
		}
		
		
		
	}

}
