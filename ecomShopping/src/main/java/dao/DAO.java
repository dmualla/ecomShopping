package dao;

import models.Product;
import models.User;

import java.util.*;

public class DAO {

    private static List<Product> products =  new ArrayList<Product>() {
        {
            add(new Product(165778, "Mic RTA-M", "120", "https://i.imgur.com/mZySuRX.jpg", "A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately",false));
            add(new Product(298765, "Pavillion PC", "400", "https://i.imgur.com/TTHT7S7.jpg", "A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately",false));
            add(new Product(309845, "ARC Mic 2.5", "320", "https://i.imgur.com/evnGEIR.jpg","A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately" ,false));
            add(new Product(409437, "TMU TV", "620", "https://i.imgur.com/z4wl7oN.jpg","A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately" ,false));
            add(new Product(509387, "Polk Speakers", "330", "https://i.imgur.com/tC4J9PA.jpg", "A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately",false));
            add(new Product(683892, "Tripod BN2", "170", "https://i.imgur.com/MILtRoe.jpg","A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately" ,false));
            add(new Product(755366, "Drone TX3", "83", "https://i.imgur.com/Qfx9qUD.png", "A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately",false));
            add(new Product(809238, "TM28 Speakers", "712", "https://i.imgur.com/rIPtxCg.jpg", "A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately",false));
            add(new Product(979303, "Camera CN8", "553", "https://i.imgur.com/IMxLT1Y.jpg", "A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately",false));
            add(new Product(1067380, "Ultrabook PC", "980", "https://i.imgur.com/IkRhNzP.jpg","A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately", false));
            add(new Product(1152199, "Headphone BT4", "284", "https://i.imgur.com/nT2BFLz.jpg", "A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately",false));
            add(new Product(1266834, "Mic BF17", "29", "https://i.imgur.com/XfUoChB.jpg","A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately" ,false));
            add(new Product(1300437, "Headphone WS9", "68", "https://i.imgur.com/sPQQLhe.jpg", "A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately",false));
            add(new Product(1453663, "HD1.9 TV", "945", "https://i.imgur.com/wN8n8ek.jpg", "A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately",false));
            add(new Product(1453664, "Tripod A2", "460", "https://i.imgur.com/wQcC8Op.jpg", "A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately",false));
            add(new Product(1453669, "Camera NK9", "789", "https://i.imgur.com/aU0YAHd.jpg", "A product description is the copy that describes the features and benefits of a product to a customer. The goal of the product description is to provide the customer with enough information to compel them to want to buy the product immediately",false));
        }
    };

    private static List<User> users =  new ArrayList<User>() {
        {
            add(new User(1, "admin", "admin", "Jeff Alex", "admin@support.com"));
            add(new User(2, "bob", "1234", "Bob Martin", "bob@support.com"));
        }
    };

    public static boolean checkUserCredentials(String username, String password) {
        for (User user: DAO.users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void addNewUser(User user) {
        user.setId(generateNewUserID());
        users.add(user);
    }

    public static User getUserByUsername(String username) {
        for (User user: getUsersList()) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void updateUserData(User user) {
        User tmpUser = null;
        for (User u: getUsersList()) {
            if(u.getId() == user.getId() ) {
                tmpUser = u;
            }
        }
        users.remove(tmpUser);
        users.add(user);
    }

    public static int generateNewUserID() {
        return users.get(users.size()-1).getId()+1;
    }

    public static List<User> getUsersList() {
        return users;
    }

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

    public static List<Product> getProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product: getProductsList()) {
            if(product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

}
