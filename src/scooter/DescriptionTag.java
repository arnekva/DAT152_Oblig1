package scooter;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DescriptionTag extends SimpleTagSupport {
	   public void doTag() throws JspException, IOException {

		      JspWriter out = getJspContext().getOut();
		      out.println("Description skal printes her");
		   }
}
