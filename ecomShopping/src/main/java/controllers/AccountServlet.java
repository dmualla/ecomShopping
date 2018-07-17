package controllers;

import dao.DAO;
import models.User;
import utilities.ApplicationParams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getCookies() != null) {
            for (Cookie cookie: request.getCookies()) {
                if(cookie.getName().equals(ApplicationParams.USERNAME_PARAM)) {
                    request.setAttribute("username", cookie.getValue());
                    request.setAttribute("isChecked", "checked");
                }
            }
        }

        HttpSession session = request.getSession();

        if(session.getAttribute("username") != null) {
            User user = DAO.getUserByUsername((String) session.getAttribute("username"));
            request.setAttribute("user", user);
        }

        request.getRequestDispatcher(ApplicationParams.ACCOUNT_PAGE_LINK).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(Integer.parseInt(id), username, password, fullname, email);
        DAO.updateUserData(user);

        PrintWriter out = response.getWriter();
        out.print("success");
        out.close();
    }
}
