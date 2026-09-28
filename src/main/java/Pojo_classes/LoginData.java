package Pojo_classes;

/**
 * POJO (Plain Old Java Object) representing the test data
 * required for the user login process.
 *
 * This class is used to deserialize the login_data.json file
 * into a Java object using the Gson library.
 *
 * It stores the user's email address and password, which are
 * used during the login process in automated test cases.
 */
public class LoginData {
    // User password used for authentication
    private String password;

    // User email address used for authentication
    private String email_address;

    /**
     * Default constructor required by JSON deserialization libraries
     * such as Gson.
     */
    public LoginData() {
    }

    /**
     * Parameterized constructor used to initialize
     * the login test data object.
     *
     * @param password User password.
     * @param email_address User email address.
     */
    public LoginData(String password, String email_address) {
        this.password = password;
        this.email_address = email_address;
    }

    /**
     * Retrieves the user's password.
     *
     * @return User password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Updates the user's password.
     *
     * @param password New user password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Updates the user's email address.
     *
     * @param email_address New user email address.
     */
    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    /**
     * Retrieves the user's email address.
     *
     * @return User email address.
     */
    public String getEmail_address() {
        return email_address;
    }
}
