package Pojo_classes;

public class IncorrectEmailPasswordData {
    private String password;
    private String email_address;

    public IncorrectEmailPasswordData(String password, String email_address) {
        this.password = password;
        this.email_address = email_address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getEmail_address() {
        return email_address;
    }
}
