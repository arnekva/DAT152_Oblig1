package scooter;

import java.util.ArrayList;
import java.util.List;

public class ProductEAO {

	
	ArrayList<Product> products = new ArrayList<Product>();
	
	
	public ProductEAO() {

		Product kopp1 = new Product(1, "Municipal Cup", 9, "img/municipal_cup.jpg");
		Product kopp2 = new Product(2, "The Golden Mug", 29, "img/golden_mug.jpg");
		Product kopp3 = new Product(3, "Goblet of Fire", 199, "img/goblet_of_fire.png");
		Product kopp4 = new Product(4, "The 99 Coffee cup", 12, "img/99_cup.jpg");
		Product kopp5 = new Product(5, "Are's Favorite", 0.99, "img/are_favorite.jpg");
		Product kopp6 = new Product(6, "The Big D Cup", 499, "img/big_D_cup.jpg");

		
		products.add(kopp1);
		products.add(kopp2);
		products.add(kopp3);
		products.add(kopp4);
		products.add(kopp5);
		products.add(kopp6);
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	/**
	 * Finds and returns the product with the given product number if it exists.
	 * @param nr
	 * @return Product or null
	 */
	public Product findProduct(String nr) {
		for(int i = 0; i<products.size();i++) {
			try {
			if(products.get(i).getProdnr() == Integer.parseInt(nr)) {
				return products.get(i);
			}
			} catch(Exception e) {
				return null;
			}
		}
		return null;
	}
	
	public Product getProduct(int prodnr) {
		Product p = null;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProdnr() == prodnr) {
				p = products.get(i);
				i = products.size();
			}
		}
		return p;
	}
	
}
