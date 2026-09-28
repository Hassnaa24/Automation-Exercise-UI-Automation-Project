package Pojo_classes;

public class ExistingEmailSignUpData {

   private String email_address;
   private String      name;


    public ExistingEmailSignUpData(String email_address, String name) {
        this.email_address = email_address;
        this.name = name;
    }

    public String getEmail_address() {
        return email_address;
    }


    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
