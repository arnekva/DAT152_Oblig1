package scooter;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		ProductEAO productEAO = new ProductEAO();
		Cart cart = new Cart();
		
		ArrayList<Product> products = productEAO.createAllProducts();
		
		Scanner tast = new Scanner(System.in);
		
		System.out.println("");

	}

}
