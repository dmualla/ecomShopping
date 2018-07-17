package utilities;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDateTime;

public class FooterCustomTag extends SimpleTagSupport {
    public void doTag() throws JspException, IOException {
        int year = LocalDateTime.now().getYear();
        JspWriter out = getJspContext().getOut();
        out.write("<div class=\"footer\"> eComShopping &copy; " + year + "\n </div>");
    }
}
