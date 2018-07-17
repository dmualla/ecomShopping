package controllers;

import dao.DAO;
import models.Product;
import utilities.ApplicationParams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> products = new ArrayList<>();
        HttpSession session = request.getSession();
        if(session.getAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM) != null) {
            products = (List<Product>) session.getAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM);
        }
        products.sort(Comparator.comparing(Product::getId));
        request.setAttribute("products", products);
        request.getRequestDispatcher(ApplicationParams.CART_PAGE_LINK).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Product> cartProducts =  (List<Product>) session.getAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM);

        int productID = Integer.parseInt(request.getParameter("id"));
        Product product = DAO.getProductById(productID);

        if(product!=null) {
            cartProducts.remove(product);
            session.setAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM, cartProducts);
        }

    }
}
