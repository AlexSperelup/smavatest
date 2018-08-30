package automation.smava.models;

public class User {

    private String username;
    private String password;

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

    public User username(String username){
        this.username = username;
        return this;
    }

    public User password(String password){
        this.password = password;
        return this;
    }

}
