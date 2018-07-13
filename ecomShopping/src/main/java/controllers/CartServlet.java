package controllers;

import dao.ProductsData;
import models.Product;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> products = Arrays.asList();
        HttpSession session = request.getSession();
        if(session.getAttribute("cart-products") != null) {
            products = (List<Product>) session.getAttribute("cart-products");
        }
        products.sort(Comparator.comparing(Product::getId));
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Product> cartProducts =  (List<Product>) session.getAttribute("cart-products");

        int productID = Integer.parseInt(request.getParameter("id"));
        Product product = ProductsData.getProductById(productID);

        if(product!=null) {
            cartProducts.remove(product);
            session.setAttribute("cart-products", cartProducts);
        }

    }
}
