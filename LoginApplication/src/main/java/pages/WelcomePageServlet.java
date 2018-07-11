package pages;

import utilities.ApplicationParams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class WelcomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = "";
        HttpSession session = request.getSession(false);
        if(session != null ) {
            username = (String) session.getAttribute("username");
        }

        PrintWriter writer = response.getWriter();
        writer.print("<html><head><title>Lab 12</title></head><body>");
        writer.print("<div>Welcome <strong>" + username + "</strong>, How are you doing!</div>");
        writer.print("<div>Go to <a href='"+ request.getContextPath() + "/page1'>page1</a></div>");
        writer.print("<div>Go to <a href='"+ request.getContextPath() + "/page2'>page2</a></div>");
        writer.print("<div><a href='logout'>Logout</a></div>");
        writer.print("</body></html>");
        writer.close();

    }
}
