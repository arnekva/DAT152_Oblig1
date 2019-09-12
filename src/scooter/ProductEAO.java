package scooter;

import java.util.ArrayList;
import java.util.List;

public class ProductEAO {

	
	
	public ArrayList<Product> createAllProducts() {

		ArrayList<Product> products = new ArrayList<Product>();
		
		Product kopp1 = new Product(1, "HaraldCup", 9, "img/kopp1.png");
		Product kopp2 = new Product(2, "The Golden Mug", 29, "img/kopp2.png");
		Product kopp3 = new Product(3, "Goblet of Fire", 199, "img/kopp3.png");
		Product kopp4 = new Product(4, "The 99 Coffee cup", 12, "img/kopp4.png");
		Product kopp5 = new Product(5, "Are's Favorite", 0.99, "img/kopp5.png");
		Product kopp6 = new Product(6, "Big D Cup", 499, "img/kopp6.png");
		
		products.add(kopp1);
		products.add(kopp2);
		products.add(kopp3);
		products.add(kopp4);
		products.add(kopp5);
		products.add(kopp6);
		
		return products;
	}
	
}