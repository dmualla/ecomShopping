package controllers;

import dao.DAO;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        List<Product> products = DAO.getProductsList();

        if(session.getAttribute("cart-products") == null) {
            session.setAttribute("cart-products", new ArrayList<Product>());
            for (Product product: products) {
                product.setInCard(false);
            }
        }else{
            List<Product> cartProducts = (List<Product>) session.getAttribute("cart-products");
            for (Product product: products) {
                if(cartProducts.contains(product)) {
                    product.setInCard(true);
                }
            }
        }

        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/jsp/products.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Product> cartProducts =  (List<Product>) session.getAttribute("cart-products");

        int productID = Integer.parseInt(request.getParameter("id"));
        Product product = DAO.getProductById(productID);

        if(product!=null) {
            cartProducts.add(product);
            session.setAttribute("cart-products", cartProducts);
        }

    }

}
