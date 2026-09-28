package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPage extends BasePage {

    // ==================== Page Locators ====================

    // Delivery address - first address line displayed during checkout.
    private final By address1_text_locator =
            By.cssSelector("ul#address_delivery li:nth-of-type(4)");

    // Delivery address - second address line displayed during checkout.
    private final By address2_text_locator =
            By.cssSelector("ul#address_delivery li:nth-of-type(5)");

    // Text area used to enter an optional message or special instruction
    // for the order.
    private final By order_message_box_locator =
            By.cssSelector("div#ordermsg textarea");

    // Button used to proceed from the checkout page to the payment page.
    private final By place_order_button_locator =
            By.cssSelector("div a[class=\"btn btn-default check_out\"]");



    // ==================== Constructor ====================

    /**
     * Initializes the Checkout Page Object.
     *
     * @param driver WebDriver instance used to interact with the page.
     */
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }



    // ==================== Delivery Address Methods ====================

    /**
     * Retrieves the first line of the delivery address displayed
     * on the checkout page.
     *
     * @return The first delivery address line.
     */
    public String verify_delivery_address1() {
        return frame.getText(address1_text_locator);
    }

    /**
     * Retrieves the second line of the delivery address displayed
     * on the checkout page.
     *
     * @return The second delivery address line.
     */
    public String verify_delivery_address2() {
        return frame.getText(address2_text_locator);
    }


    // ==================== Order Methods ====================

    /**
     * Enters a message or special instruction for the order.
     *
     * @param message Message to be entered in the order message field.
     */
    public void write_order_message(String message) {
        frame.sendKeys(order_message_box_locator, message);
    }

    /**
     * Places the order and navigates to the payment page.
     *
     * @return Payment Page Object representing the next page in the checkout flow.
     */
    public payment_page place_order() {
        frame.click(place_order_button_locator);
        return new payment_page(driver);
    }


    // ==================== Account Methods ====================

    /**
     * Deletes the currently logged-in user account.
     *
     * @return Delete Account Page Object representing the account deletion result page.
     */
    public DeleteAccountPage deleteUser() {
        frame.click(delete_account_button);
        return new DeleteAccountPage(driver);
    }
}
