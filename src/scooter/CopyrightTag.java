package scooter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CopyrightTag extends SimpleTagSupport {
   public void doTag() throws JspException, IOException {

      JspWriter out = getJspContext().getOut();
      out.println("all rights reserved");
   }
}
