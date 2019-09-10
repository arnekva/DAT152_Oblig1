package no.hvl.dat152;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.EntityManagerFactory;

public class Cart {
	
	
	private List<CartItem> items = new ArrayList<>();
	
	public void addItem(CartItem item) {
		items.add(item);
	}

	public void removeAllInstancesOfItem(CartItem item) {

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(item.getName())) {
				items.remove(i);
			}
		}
	}
	public void removeSetItems(CartItem item, int x){
		
	}

	public void removeAll() {
		items.clear();
	}

	public List<CartItem> getItems() {
		return items;
	}

}
