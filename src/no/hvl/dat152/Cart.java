package no.hvl.dat152;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.EntityManagerFactory;

public class Cart {
	
	
	private List<CartItem> items = new ArrayList<>();
	int counterMain = 0;

//	public boolean doesExist(CartItem item) {
//		if (items.size() != 0) {
//			for (int i = 0; i < items.size(); i++) {
//
//				if (items.get(i).getName().equals(item.getName())) {
//					return true;
//				} 
//		}
//		} return false;
//	}
	public int doesExistsInt(CartItem item) {
		// Denne koden sjekker om elementet brukeren taster inn eksisterer eller ei.
		// metoden returnerer antall like elementer, spesielt med tanke på duplikatene
		// med parantes (se addItem), og returnerer 0 dersom det ikke finnes fra før.

		int counter = 0;
		for (int i = 0; i < items.size(); i++) {
			for (int j = 0; j < items.size() + 10; j++) {
				// siden det er klasseobjekt, kan vi ikke sammenligne objektene direkte
				// fordi de har forskjellige Hashkoder (som er det som blir sammenlignet på
				// klasseobjekter)
				// derfor sammenligner vi navnene, siden det er det eneste objektet vårt har som
				// identitet.
				if (items.get(i).getName().equals(item.getName() + " (" + j + ")")) {
					counter++;
				}

			}
			if (items.get(i).getName().equals(item.getName())) {
				counter++;
			}
		}
		return counter;

	}

	public void addItem(CartItem item) {

		/*
		 * Denne koden er lang, og kanskje litt unødvendig, men vi vil sjekke om
		 * brukeren legger til items med samme navn. På den måten kan de ha flere
		 * instanser av samme item, og ikke slette alle instanser hvis de bare vil
		 * fjerne en. Hvis en bruker f.eks skriver "melk" to ganger ville begge
		 * instanser blitt slettet ved et "fjern"-kall uten counteren i parantes. Vi vil
		 * gi brukeren mulighet til å legge til noe flere ganger og kunne slette de
		 * individuelt
		 * 
		 * Koden kunne enkelt bare ha vært bare
		 * 
		 * items.add(item);
		 * 
		 * men vi ville altså ta høyde for duplikater.
		 * 
		 */
		int counter = 0;
		int sann = 0;
		if (items.size() != 0) {
			for (int i = 0; i < items.size(); i++) {

				if (items.get(i).getName().equals(item.getName())) {
					sann = 1;
					counter++;
				} else if (items.get(i).getName().equals(item.getName() + " (" + counter + ")")) {
					sann = 1;
					counter++;
				}
			}

			if (sann == 1) {
				for (int i = 0; i < items.size(); i++) {
					if (items.get(i).getName().equals(item.getName() + " (" + counter + ")")) {
						counter++;
					}
				}
				CartItem item2 = new CartItem(item.getName() + " (" + counter + ")");
				items.add(item2);
			} else {
				items.add(item);
			}

		} else {
			items.add(item);
		}

	}

	// En annen måte å teste for duplikater på.
	public void addItemVersjon2(CartItem item) {
		int teller = 2;
		int i = 0;
		boolean firstRun = true;

		while (i < items.size()) {

			if (items.get(i).getName().equals(item.getName()) && teller == 2) {
				item.setName(item.getName() + "(" + teller + ")");
				teller++;
			}
			if (items.get(i).getName().equals(item.getName()) && teller > 2) {
				String[] ting = item.getName().split("\\(");
				ting[1] = teller + ")";
				item.setName(ting[0] + "(" + ting[1]);
				teller++;
			}

			i++;

			if (i == items.size() && firstRun == true) {
				i = 0;
				firstRun = false;
			}
		}
		items.add(item);
	}

	public void removeItem(CartItem item) {

		// Dette printer i loggen hva som blir slettet, og vises for testing.
		String var = item.toString();
		System.out.println("\nremoveItem har mottatt: " + var);
		int antall = 0;

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(item.getName())) {
				items.remove(i);
				antall++;
			}
		}

		System.out.println(antall + " antall elementer med navn " + item.getName() + " ble slettet.");
		// Dette vises også kun for testing.
	}

	public void removeAll() {
		for (int i = 0; i < items.size(); i += 0) {
			items.remove(i);
		}
		// For å fjerne alle elementer i listen raskt. i+=0 fordi ArrayList flytter
		// elementer en posisjon til venstre når den fjerner
		// så i++ vil gi ArrayIndexOutOfBoundsException.
	}

	public List<CartItem> getItems() {
		return items;
	}

}
