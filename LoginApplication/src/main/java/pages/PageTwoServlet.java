package pages;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/page2")
public class PageTwoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        writer.print("<html><head><title>Lab 12</title></head><body>");
        writer.print("<div>Congrats!! you made it to the Page2 :)</div>");
        writer.print("<div>Go to <a href='"+ request.getContextPath() + "/page1'>page1</a></div>");
        writer.print("<div>Back to the <a href='"+ request.getContextPath() + "/welcome'>home page</a></div>");
        writer.print("</body></html>");
        writer.close();

    }
}
