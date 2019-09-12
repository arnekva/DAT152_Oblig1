package scooter;

public class Product{
    
    private int prodnr;
    private String navn;
    private double pris;
    private String bilde;
    
    
    
    
    
	public Product(int prodnr, String navn, double pris, String bilde) {
		super();
		this.prodnr = prodnr;
		this.navn = navn;
		this.pris = pris;
		this.bilde = bilde;
	}
	
	public int getProdnr() {
		return prodnr;
	}
	public void setProdnr(int prodnr) {
		this.prodnr = prodnr;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public double getPris() {
		return pris;
	}
	public void setPris(double pris) {
		this.pris = pris;
	}
	public String getBilde() {
		return bilde;
	}
	public void setBilde(String bilde) {
		this.bilde = bilde;
	}
    
    
    
	@Override
	public String toString() {
		return "Product [prodnr=" + prodnr + ", navn=" + navn + ", pris=" + pris + ", bilde=" + bilde + "]";
	}

    

	
}
