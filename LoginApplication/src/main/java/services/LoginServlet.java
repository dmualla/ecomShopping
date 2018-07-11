package services;

import utilities.ApplicationParams;
import dao.UsersData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter(ApplicationParams.USERNAME_PARAM);
        String password = request.getParameter(ApplicationParams.PASSWORD_PARAM);
        String remember = request.getParameter(ApplicationParams.CHECK_PARAM);

        if(UsersData.checkUserCredentials(username, password)) {

            if(remember != null) {
                Cookie cookie = new Cookie(ApplicationParams.USERNAME_PARAM, username);
                cookie.setMaxAge(ApplicationParams.APP_COOKIE_TIME);
                response.addCookie(cookie);
            }

            HttpSession session = request.getSession();
            session.setAttribute(ApplicationParams.USERNAME_PARAM,username);
            response.sendRedirect(request.getContextPath() + utilities.ApplicationParams.APP_WELCOME_PAGE );

        }else{
            response.sendRedirect(request.getContextPath());
        }
    }
}
