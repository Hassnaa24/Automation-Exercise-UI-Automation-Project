package Pojo_classes;

/**
 * Represents the test data used to verify login behavior
 * when an incorrect email address or password is provided.
 *
 * This POJO stores the email address and password used
 * in negative login test scenarios.
 */
public class IncorrectEmailPasswordData {

    // Stores the password used in the login test.
    private String password;

    // Stores the email address used in the login test.
    private String email_address;

    /**
     * Initializes the login test data with a password and email address.
     *
     * @param password the password to use in the login test
     * @param email_address the email address to use in the login test
     */
    public IncorrectEmailPasswordData(String password, String email_address) {
        this.password = password;
        this.email_address = email_address;
    }

    /**
     * Retrieves the password stored in this object.
     *
     * @return the stored password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Updates the password stored in this object.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Updates the email address stored in this object.
     *
     * @param email_address the new email address
     */
    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    /**
     * Retrieves the email address stored in this object.
     *
     * @return the stored email address
     */
    public String getEmail_address() {
        return email_address;
    }
}