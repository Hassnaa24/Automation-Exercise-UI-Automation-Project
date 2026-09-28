package Pojo_classes;

/**
 * POJO (Plain Old Java Object) representing the test data
 * required for the "Contact Us" form.
 *
 * This class is used to deserialize the ContactUs_Info.json file
 * into a Java object using the Gson library.
 *
 * It stores all information required to fill the Contact Us form
 * during automated test execution.
 */
public class ContactUsData {

    // User's full name
    private String name;

    // User's email address
    private String email;

    // Subject of the contact request
    private String subject;

    // Message to be submitted through the Contact Us form
    private String message;

    /**
     * Parameterized constructor used to initialize
     * the Contact Us test data object.
     *
     * @param name User's full name.
     * @param email User's email address.
     * @param subject Subject of the message.
     * @param message Contact message body.
     */
    public ContactUsData(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    /**
     * Default constructor required by JSON deserialization libraries.
     */
    public ContactUsData() {
    }


    // ===========================
    // Setters
    // ===========================

    /**
     * Sets the user's name.
     *
     * @param name User's full name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the user's email address.
     *
     * @param email User's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the subject of the message.
     *
     * @param subject Contact request subject.
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Sets the contact message.
     *
     * @param message Message content.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    // ===========================
    // Getters
    // ===========================

    /**
     * @return User's full name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return User's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return Subject of the contact request.
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @return Contact message.
     */
    public String getMessage() {
        return message;
    }
}