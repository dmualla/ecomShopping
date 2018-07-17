package utilities;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class TitleCustomTag extends SimpleTagSupport {
    String title;
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.write("<title>eComShopping: " + title + "</title>");
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
