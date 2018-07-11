package pages;

import utilities.ApplicationParams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns="/", loadOnStartup=1)
public class LoginPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        boolean userlogged = session != null && session.getAttribute("username") != null;

        if(userlogged) {
            response.sendRedirect(request.getContextPath() + ApplicationParams.APP_WELCOME_PAGE);
        } else {

            String username = "";
            String isChecked = "";

            if(request.getCookies() != null) {
                for (Cookie cookie: request.getCookies()) {
                    if(cookie.getName().equals(ApplicationParams.APP_COOKIE_NAME)) {
                        username = cookie.getValue();
                        isChecked = "checked";
                    }
                }
            }


            PrintWriter writer = response.getWriter();
            writer.print("<html><head><title>Lab 12</title></head><body>");

            writer.print("<form action='login' method='post'>");
            writer.print("<div><label> Username:<input type='text' name='username' value='" + username + "' ></label>");
            writer.print("<label> Password:<input type='password' name='password'></label>");
            writer.print("<label><input type='checkbox' name='remember' " + isChecked + "> Remember me!</label></div><br/>");
            writer.print("<div><input type='submit' value='Login'></div>");
            writer.print("</form> ");

            writer.print("</body></html>");
            writer.close();
        }
    }
}
