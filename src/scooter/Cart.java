package scooter;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.EntityManagerFactory;

public class Cart {
	
	
	private List<Product> items = new ArrayList<>();
	
	public void addItem(Product item) {
		items.add(item);
	}

	public void removeAllInstancesOfItem(Product item) {

//		for (int i = 0; i < items.size(); i++) {
//			if (items.get(i).getName().equals(item.getName())) {
//				items.remove(i);
//			}
//		}
	}
	public void remove(Product item){
		items.remove(item);
	}

	public void removeAll() {
		items.clear();
	}

	public List<Product> getItems() {
		return items;
	}

}
