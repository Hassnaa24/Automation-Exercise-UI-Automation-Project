package Pojo_classes;

/**
 * POJO (Plain Old Java Object) representing the test data
 * required for the newsletter subscription feature.
 *
 * This class is used to deserialize the Subscription_Info.json
 * file into a Java object using the Gson library.
 *
 * It stores the email address that will be used during
 * the subscription process in the automated test cases.
 */
public class SubscriptionData {

    // Email address used for newsletter subscription
    private String email;

    /**
     * Default constructor required by JSON deserialization libraries
     * such as Gson.
     */
    public SubscriptionData() {

    }

    /**
     * Parameterized constructor used to initialize
     * the subscription test data object.
     *
     * @param email The email address used for subscription.
     */
    public SubscriptionData(String email) {
        this.email = email;
    }

    /**
     * Sets the subscription email address.
     *
     * @param email The email address to be used for subscription.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the subscription email address.
     *
     * @return The email address used for subscription.
     */
    public String getEmail() {
        return email;
    }
}