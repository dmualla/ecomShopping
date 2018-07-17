package controllers;

import utilities.ApplicationParams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute(ApplicationParams.USERNAME_PARAM);
        response.sendRedirect(request.getContextPath()+ ApplicationParams.LOGIN_PAGE_SHORT_LINK);
    }
}
