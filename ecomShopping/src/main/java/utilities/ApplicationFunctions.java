package utilities;

import dao.DAO;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationFunctions {

    public static void redirectAuthenticatedUser(HttpServletRequest request, HttpServletResponse response, HttpSession session, List<Product> products) throws IOException {
        if(session.getAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM) == null || ((List<Product>) session.getAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM)).size() == 0) {
            session.setAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM, new ArrayList<Product>());
            for (Product product: products) product.setInCard(false);
            request.setAttribute("products", products);
            response.sendRedirect(request.getContextPath() + ApplicationParams.PRODUCTS_PAGE_SHORT_LINK );
        }else{
            response.sendRedirect(request.getContextPath() + ApplicationParams.CHECKOUT_PAGE_SHORT_LINK );
        }
    }

    public static void redirectToProductsPage(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Product> products = DAO.getProductsList();
        checkProductsInCart(session, products);
        request.setAttribute("products", products);
        request.getRequestDispatcher(ApplicationParams.PRODUCTS_PAGE_LINK).forward(request, response);
    }

    public static void checkProductsInCart(HttpSession session, List<Product> products) {
        if(session.getAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM) == null) {
            session.setAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM, new ArrayList<Product>());
            for (Product product: products) product.setInCard(false);
        }else{
            List<Product> cartProducts;
            cartProducts = (List<Product>) session.getAttribute(ApplicationParams.SESSION_CART_PRODUCT_PARAM);
            for (Product product: products)
                if (cartProducts.contains(product)) product.setInCard(true);
        }
    }

}
