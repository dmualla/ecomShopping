package controllers;

import dao.DAO;
import models.Product;
import models.User;
import utilities.ApplicationFunctions;
import utilities.ApplicationParams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(ApplicationParams.SIGN_UP_PAGE_LINK).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String username = request.getParameter("password");
        String password = request.getParameter("password");

        User user = new User( DAO.generateNewUserID(), username, password, fullname, email);
        DAO.addNewUser(user);
        HttpSession session = request.getSession();
        session.setAttribute(ApplicationParams.USERNAME_PARAM,username);
        List<Product> products = DAO.getProductsList();
        ApplicationFunctions.redirectAuthenticatedUser(request, response, session, products);

    }
}
