package controllers;

import dao.DAO;
import models.Product;
import utilities.ApplicationFunctions;
import utilities.ApplicationParams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = "";
        String isChecked = "";

        if(request.getCookies() != null) {
            for (Cookie cookie: request.getCookies()) {
                if(cookie.getName().equals(ApplicationParams.USERNAME_PARAM)) {
                    username = cookie.getValue();
                    isChecked = "checked";
                }
            }
        }

        request.setAttribute("username", username);
        request.setAttribute("isChecked", isChecked);
        request.getRequestDispatcher(ApplicationParams.LOGIN_PAGE_LINK).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter(ApplicationParams.USERNAME_PARAM);
        String password = request.getParameter(ApplicationParams.PASSWORD_PARAM);
        String remember = request.getParameter(ApplicationParams.CHECK_PARAM);

        if(DAO.checkUserCredentials(username, password)) {

            if(remember != null) {
                Cookie cookie = new Cookie(ApplicationParams.USERNAME_PARAM, username);
                cookie.setMaxAge(ApplicationParams.APP_COOKIE_TIME);
                response.addCookie(cookie);
            }

            HttpSession session = request.getSession();
            session.setAttribute(ApplicationParams.USERNAME_PARAM,username);
            List<Product> products = DAO.getProductsList();

            ApplicationFunctions.redirectAuthenticatedUser(request, response, session, products);

        }else{
            request.getRequestDispatcher(ApplicationParams.LOGIN_PAGE_LINK).forward(request, response);
        }
    }


}
