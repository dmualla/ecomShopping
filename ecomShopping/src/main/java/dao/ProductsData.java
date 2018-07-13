package dao;

import models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsData {

    private static List<Product> products =  new ArrayList<Product>() {
        {
            add(new Product(165778, "Product 1", "120", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(298765, "Product 2", "20", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(309845, "Product 3", "40", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(409437, "Product 4", "70", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(509387, "Product 5", "330", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(683892, "Product 6", "870", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(755366, "Product 7", "83", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(809238, "Product 8", "12", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(979303, "Product 9", "553", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(1067380, "Product 10", "980", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(1152199, "Product 11", "284", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(1266834, "Product 12", "29", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(1300437, "Product 13", "68", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
            add(new Product(1453663, "Product 14", "45", "http://img.roomeon.com/img/object/betonwuerfel-bau-elemente_dc2b2cff6c_xxl.png", false));
        }
    };

    public static List<Product> getProductsList() {
        for (Product product: products) {
            product.setInCard(false);
        }
        return products;
    }

    public static Product getProductById(int id) {
        for (Product product: getProductsList()) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
