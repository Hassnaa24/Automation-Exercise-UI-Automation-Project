package Pojo_classes;

/**
 * Represents the signup data used when testing registration
 * with an email address that already exists in the application.
 *
 * This POJO class stores the user's email address and name
 * and provides methods to access and update these values.
 */
public class ExistingEmailSignUpData {

    // Stores the email address used during the signup test.
    private String email_address;

    // Stores the name associated with the signup test data.
    private String name;

    /**
     * Initializes the signup test data with an email address and name.
     *
     * @param email_address the email address to use in the signup test
     * @param name the name associated with the signup test data
     */
    public ExistingEmailSignUpData(String email_address, String name) {
        this.email_address = email_address;
        this.name = name;
    }

    /**
     * Retrieves the email address stored in this object.
     *
     * @return the stored email address
     */
    public String getEmail_address() {
        return email_address;
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
     * Retrieves the name stored in this object.
     *
     * @return the stored name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the name stored in this object.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }
}