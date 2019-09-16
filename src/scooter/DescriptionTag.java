package scooter;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DescriptionTag extends SimpleTagSupport {
	private int since = 0;
	private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
	static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }
	
	public int getSince() {
		return since;
	}
	public void setSince(int since) {
	      this.since = since;
	   }
   public void doTag() throws JspException, IOException {
	   
	   if(since == 0) {
		   JspWriter out = getJspContext().getOut();
		      out.println("Ingen since satt??");
	   } else {
		   JspWriter out = getJspContext().getOut();
		      out.println("Det er noe i since");
	   }
       
      
      
   }
   public final static String toRoman(int number) {
       int l =  map.floorKey(number);
       if ( number == l ) {
           return map.get(number);
       }
       return map.get(l) + toRoman(number-l);
   }
}
