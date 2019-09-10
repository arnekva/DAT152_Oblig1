package no.hvl.dat152;

public class CartItem {
    
    private String name;
    private String modell;
    private int pris;
    private String rekkevidde;
    
    
    
	public CartItem(String name, String modell, int pris, String rekkevidde) {

		this.name = name;
		this.modell = modell;
		this.pris = pris;
		this.rekkevidde = rekkevidde;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModell() {
		return modell;
	}
	public void setModell(String modell) {
		this.modell = modell;
	}
	public int getPris() {
		return pris;
	}
	public void setPris(int pris) {
		this.pris = pris;
	}
	public String getRekkevidde() {
		return rekkevidde;
	}
	public void setRekkevidde(String rekkevidde) {
		this.rekkevidde = rekkevidde;
	}
    

	
}
