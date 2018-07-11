package dao;

import java.util.ArrayList;
import java.util.List;

public class UsersData {


    private static List<User> users =  new ArrayList<User>() {
        {
            add(new User("admin", "admin"));
            add(new User("bob", "1234"));
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
