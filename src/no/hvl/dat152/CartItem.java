package no.hvl.dat152;

public class CartItem {
    
    private String name;
    
    public CartItem() {
    	
    }
    public CartItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
    	this.name = name;
    }

    
	public boolean equals(CartItem item) {
		return (this == item);
	}

	@Override
	public String toString() {
		return name;
	}
	
}
