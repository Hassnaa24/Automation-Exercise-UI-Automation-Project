package pages;

import Pojo_classes.PaymentCardData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    // ========================== LOCATORS ==========================

    // Locates the button used to submit payment details and confirm the order.
    private final By pay_and_confirm_order_button_locator = By.cssSelector("button#submit");

    // Locates the input field for the name printed on the payment card.
    private final By name_on_card_locator                 = By.cssSelector("input[name='name_on_card']");

    // Locates the input field for the payment card number.
    private final By card_number_locator                  = By.cssSelector("input[name='card_number']");

    // Locates the input field for the card security code (CVC).
    private final By card_cvc                             = By.cssSelector("input[name='cvc']");

    // Locates the input field for the card expiration month.
    private final By card_Expiration_date_month           = By.cssSelector("input[name='expiry_month']");

    // Locates the input field for the card expiration year.
    private final By card_Expiration_date_year            = By.cssSelector("input[name='expiry_year']");


    // Locates the success alert displayed after the payment/order confirmation.
    // Alternative locator retained for reference:
    // private final By success_payment_message_locator = By.cssSelector("div[class=\"col-md-12 form-group\"]#success_message div[class=\"alert-success alert\"]");
    private final By success_payment_message_locator = By.cssSelector("#success_message .alert-success");

    // Locates the link used to download the invoice after placing an order.
    private final By download_invoice_locator        = By.cssSelector("div[class=\"col-sm-9 col-sm-offset-1\"]  a[class=\"btn btn-default check_out\"]");

    // Locates the Continue link displayed after the order confirmation process.
    private final By continue_button_locator         = By.cssSelector("div[class=\"pull-right\"] a");

    // Locates the message displayed to congratulate the user after placing an order.
    private final By congratulate_placed_order_message_locator = By.cssSelector("div[class=\"col-sm-9 col-sm-offset-1\"] p");


    // ========================== CONSTRUCTOR ==========================

    /**
     * Initializes the payment page and its shared browser interaction helpers.
     *
     * @param driver the WebDriver instance used to control the browser
     */
    public PaymentPage(WebDriver driver)
    {
        super(driver);
    }


    // ========================== PAYMENT ACTIONS ==========================

    /**
     * Enters the payment card details using the supplied payment data object.
     *
     * @param card_info an object containing the cardholder name, card number,
     *                  CVC, expiration month, and expiration year
     */
    public void Enter_payment_details(PaymentCardData card_info )
    {
        frame.sendKeys(name_on_card_locator,card_info.getName_on_card());
        frame.sendKeys(card_number_locator,card_info.getCard_number());
        frame.sendKeys(card_cvc ,card_info.getCard_cvc());
        frame.sendKeys(card_Expiration_date_month ,card_info.getCard_Expiration_date_month());
        frame.sendKeys( card_Expiration_date_year  ,card_info.getCard_Expiration_date_year());

    }

    /**
     * Clicks the payment submission button to confirm the order.
     */
    public void pay_and_confirm()
    {
        frame.click(pay_and_confirm_order_button_locator);
    }


    // ========================== ORDER CONFIRMATION ==========================

    /**
     * Retrieves the success message displayed after the payment/order submission.
     *
     * @return the text of the success alert
     */
    public String verify_success_order_place_message()
    {
        return frame.getText(success_payment_message_locator);
    }

    /**
     * Retrieves the congratulatory message displayed after an order is placed.
     *
     * @return the congratulatory order confirmation message
     */
    public String verify_congratulate_placed_order_message()
    {
        return frame.getText(congratulate_placed_order_message_locator);
    }


    // ========================== POST-ORDER ACTIONS ==========================

    /**
     * Clicks the invoice download link.
     * The browser handles the resulting download according to its configuration.
     */
    public void download_invoice()
    {
        frame.click(download_invoice_locator);
    }

    /**
     * Clicks Continue after the order process and returns the logged-in home page.
     *
     * @return a HomePageLoggedIn page object for subsequent interactions
     */
    public HomePageLoggedIn click_continue()
    {
        frame.click(continue_button_locator);
        return new HomePageLoggedIn(driver);
    }

    /**
     * Clicks the Delete Account button and returns the delete-account page object.
     *
     * @return a DeleteAccountPage page object for subsequent interactions
     */
    public DeleteAccountPage delete_account()
    {
        frame.click(delete_account_button);
        return new DeleteAccountPage(driver);
    }

}

