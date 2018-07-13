package dao;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersData {


    private static List<User> users =  new ArrayList<User>() {
        {
            add(new User(1, "admin", "admin", "Jeff Alex"));
            add(new User(2, "bob", "1234", "Bob Martin"));
        }
    };

    public static boolean checkUserCredentials(String username, String password) {
        for (User user: UsersData.users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}