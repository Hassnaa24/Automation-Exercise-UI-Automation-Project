package Pojo_classes;

/**
 * POJO (Plain Old Java Object) representing the test data
 * required to submit a product review.
 *
 * This class is used to deserialize the Review_Info.json file
 * into a Java object using the Gson library.
 *
 * The object stores the reviewer's name, email address,
 * and review message, which are used to populate the
 * "Write Your Review" form during automated test execution.
 */

public class ReviewData {

    // Reviewer's name
    private String name;

    // Reviewer's email address
    private String email;

    // Review message to be submitted
    private String message;

    /**
     * Parameterized constructor used to initialize
     * the review test data object.
     *
     * @param name Reviewer's name.
     * @param email Reviewer's email address.
     * @param message Review content.
     */
    public ReviewData(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }
    /**
     * Default constructor required by JSON deserialization libraries.
     */
    public ReviewData() {
    }
    // ===========================
    // Getters
    // ===========================

    /**
     * @return The review message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return The reviewer's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return The reviewer's name.
     */
    public String getName() {
        return name;
    }

    // ===========================
    // Setters
    // ===========================

    /**
     * Sets the reviewer's name.
     *
     * @param name Reviewer's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the reviewer's email address.
     *
     * @param email Reviewer's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the review message.
     *
     * @param message Review content.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
