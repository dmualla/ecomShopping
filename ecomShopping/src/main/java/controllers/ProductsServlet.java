package controllers;

import dao.DAO;
import models.Product;
import utilities.ApplicationFunctions;
import utilities.ApplicationParams;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ApplicationFunctions.redirectToProductsPage(response, request);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Product> cartProducts =  (List<Product>) session.getAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM);

        int productID = Integer.parseInt(request.getParameter("id"));
        Product product = DAO.getProductById(productID);

        if(product!=null) {
            cartProducts.add(product);
            session.setAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM, cartProducts);
        }

    }

}
