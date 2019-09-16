package scooter;

import java.util.ArrayList;
import java.util.Collections;

public class DescriptionEAO {
	
	ArrayList<Description> descriptions;
	
	
	public DescriptionEAO() {
		descriptions = new ArrayList<Description>();
		
		Description desc1 = new Description(1, "NB", "Kommunekoppen - Vår mest solgte kopp. Denne koppen sørger for at du alltid har et sted å gjøre av væsken din.");
		Description desc2 = new Description(2, "NB", "Gullkoppen - Gjør stort sett det samme som Kommunekoppen, men den sporter en fresh gullfarge.");
		Description desc3 = new Description(3, "NB", "Ildbegeret - Du skulle kanskje tro at denne er hentet rett fra Harry Potter, men det hadde ikke vært en klok tanke.. Koppen som bokstavelig talt står i flammer! NB:brannfare.");
		Description desc4 = new Description(4, "NB", "99 kaffekoppen - Som barn lekte du gjerne politi og røver. Som voksen kan du nå ta leken til et helt nytt nivå men denne kaffekoppen. Len deg tilbake i kontorstolen og ta deg en ordentlig kopp kaffe i denne politikoppen!");
		Description desc5 = new Description(5, "NB", "Ares favoritt - En kopp så billig at selv Are drar sparegrisen ut av safen. OBS:koppen inkluderer et sosialt stempel som kan medføre en unntaksgjeninnføring av kaste-systemet i ditt lavmålte tilfelle.");
		Description desc6 = new Description(6, "NB", "Den store D-koppen - Et kjøp av denne koppen bør ikke påvirkes av en beskrivelse. Du som kjøper denne vet hvem du er.");
		Description desc7 = new Description(1, "EN", "Municipal Cup - Our most popular item. This cup ensures that you'll always have a place to put your liquid.");
		Description desc8 = new Description(2, "EN", "The Golden Mug - Does pretty much the same as the Municipal Cup, but it sports a fresh golden color.");
		Description desc9 = new Description(3, "EN", "Goblet of Fire - You might think this is obtained straight from Harry Potter, but that would not be a wise bet.. The cup that is literally on fire! WARNING:fire hazard.");
		Description desc10 = new Description(4, "EN", "The 99 Coffee cup - As a child, you probably loved playing cops and robbers. As an adult you can now take the game to the next level with this coffee cup. Lean back in your office chair and have a proper cup of coffee in this police cup!");
		Description desc11 = new Description(5, "EN", "Are's Favorite - A cup so cheap even Are will drag his piggybank out of the safe. WARNING:this cup includes a social stamp which may lead to an exceptional re-introduction of casts in your incredibly low-level case.");
		Description desc12 = new Description(6, "EN", "The Big D Cup - No description should have any impact on a purchase of this cup. You know who you are if you buy this.");
		Description desc13 = new Description(1, "DE", "Kommunale Tasse - Unser beliebtestes Produkt. Diese Tasse sorgt dafür, dass Sie immer einen Platz für Ihre Flüssigkeit haben.");
		Description desc14 = new Description(2, "DE", "Die goldene Becher - Ist so ziemlich das gleiche wie das Kommunale Tasse, aber es trägt eine frische goldene Farbe.");
		Description desc15 = new Description(3, "DE", "Feuerkelch - Man könnte denken, dass dies direkt von Harry Potter stammt, aber das wäre keine kluge Wette. Die Tasse, die buchstäblich in Flammen steht! WARNUNG: Brandgefahr.");
		Description desc16 = new Description(4, "DE", "Die 99 Kaffeetasse - Als Kind haben Sie wahrscheinlich gerne Polizisten und Räuber gespielt. Als Erwachsener können Sie jetzt mit dieser Kaffeetasse das Spiel auf die nächste Stufe heben. Lehnen Sie sich in Ihrem Bürostuhl zurück und trinken Sie eine ordentliche Tasse Kaffee in dieser Polizeibecher!");
		Description desc17 = new Description(5, "DE", "Are's Liebling - Eine so billige Tasse, dass auch Are sein Sparschwein aus dem Safe zieht. WARNUNG: Diese Tasse enthält einen Stempel, der zu einer außergewöhnlichen Wiedereinführung von Abdrücken in Ihrem unglaublich niedrigen Fall führen kann.");
		Description desc18 = new Description(6, "DE", "Der Großer D Tasse - Keine Beschreibung sollte Auswirkungen auf den Kauf dieses Bechers haben. Sie wissen, wer Sie sind, wenn Sie dies kaufen.");
		
		descriptions.add(desc1);
		descriptions.add(desc2);
		descriptions.add(desc3);
		descriptions.add(desc4);
		descriptions.add(desc5);
		descriptions.add(desc6);
		descriptions.add(desc7);
		descriptions.add(desc8);
		descriptions.add(desc9);
		descriptions.add(desc10);
		descriptions.add(desc11);
		descriptions.add(desc12);
		descriptions.add(desc13);
		descriptions.add(desc14);
		descriptions.add(desc15);
		descriptions.add(desc16);
		descriptions.add(desc17);
		descriptions.add(desc18);
		
		
	}


	public ArrayList<Description> getDescriptions() {
		return descriptions;
	}
	
	/**
	 * Get descriptions
	 * @param langCode
	 * @return returns the correct descriptions based on locale
	 */
	public ArrayList<Description> getDescriptionsByLangCode(String langCode) {
		ArrayList<Description> languageDescriptions = new ArrayList<Description>();
		for (Description d : descriptions) {
			if (d.getLangCode().equals(langCode)) {
				languageDescriptions.add(d);
			}
		}
		Collections.sort(languageDescriptions);
		return languageDescriptions;
	}
	
	
	
}
