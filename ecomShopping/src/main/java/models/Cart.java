package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private int id;
    private List<Product> products = new ArrayList<Product>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productID) {
        int index = 0;
        for (Product product: products) {
            if(product.getId() == productID) {
                products.remove(index);
            }
            index++;
        }
    }
}
