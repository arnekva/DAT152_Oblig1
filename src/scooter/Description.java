package scooter;

public class Description implements Comparable<Object> {
	
	private int prodnr;
	private String langCode;
	private String txt;
	
	public Description(int prodnr, String langCode, String txt) {
		this.prodnr = prodnr;
		this.langCode = langCode;
		this.txt = txt;
	}

	public int getProdnr() {
		return prodnr;
	}

	public void setProdnr(int prodnr) {
		this.prodnr = prodnr;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	@Override
	public int compareTo(Object o) {
		Description comparingTo = (Description) o;
		int numberForCompare = comparingTo.getProdnr();
		return this.prodnr-numberForCompare;
	}

	@Override
	public String toString() {
		return "Description [prodnr=" + prodnr + ", langCode=" + langCode + ", txt=" + txt + "]";
	}
	
	
	
}
