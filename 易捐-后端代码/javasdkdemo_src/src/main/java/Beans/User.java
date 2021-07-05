package Beans;

public class User {
    private int id;
    private String user_ID;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public String getPassword() {
        return password;
    }
}
