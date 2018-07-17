package models;

public class User {

    private int id;
    private String username;
    private String password;
    private String fullName;
    private String email;

    public User(int id, String username, String password, String fullName, String email) {
        this.id =  id;
        this.username =  username;
        this.password =  password;
        this.fullName =  fullName;
        this.email =  email;
    }

    public User(String username, String password, String fullName, String email) {
        this.username =  username;
        this.password =  password;
        this.fullName =  fullName;
        this.email =  email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof User)) return false;
        User o = (User) obj;
        return o.getId() == this.getId();
    }
}
