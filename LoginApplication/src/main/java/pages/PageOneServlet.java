package pages;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/page1")
public class PageOneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        writer.print("<html><head><title>Lab 12</title></head><body>");
        writer.print("<div>Congrats!! you made it to the Page1 :)</div>");
        writer.print("<div>Go to <a href='"+ request.getContextPath() + "/page2'>page2</a></div>");
        writer.print("<div>Back to the <a href='"+ request.getContextPath() + "/welcome'>home page</a></div>");
        writer.print("</body></html>");
        writer.close();

    }
}
