package scooter;

import java.util.ArrayList;



public class CartEAO {
	
	ArrayList<Product> CartItems = new ArrayList<Product>();
	
	public ArrayList<Product> getAllCartItems() {
		return CartItems;
	}
	public void addItem(Product product) {
		CartItems.add(product);
	}
	public void removeItem(Product product) {
		CartItems.remove(product);
	}
	
}
