package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("id") != null) {

            String productId = request.getParameter("id");
            Product product = DAO.getProductById(Integer.parseInt(productId));

            HttpSession session = request.getSession();
            if(session.getAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM) != null) {
                List<Product> cartProducts = (List<Product>) session.getAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM);
                if(cartProducts.contains(product)) {
                    product.setInCard(true);
                }
            }
            request.setAttribute("product", product);
            request.getRequestDispatcher(ApplicationParams.PRODUCT_PAGE_LINK).forward(request, response);

        }else {
            ApplicationFunctions.redirectToProductsPage(response, request);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productName = request.getParameter("productName");
        List<Product> products = DAO.getProductsByName(productName);

        ApplicationFunctions.checkProductsInCart(request.getSession(), products);

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter out = response.getWriter();

        try{
            out.print(mapper.writeValueAsString(products));
            out.close();
        }catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
