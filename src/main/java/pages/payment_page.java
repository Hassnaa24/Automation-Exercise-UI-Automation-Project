package pages;

import Pojo_classes.PaymentCardData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Framework;

public class payment_page extends BasePage {

    private final WebDriver driver;
    private final Framework frame;


    private final By pay_and_confirm_order_button_locator = By.cssSelector("button#submit");
    private final By name_on_card_locator                 = By.cssSelector("input[name='name_on_card']");
    private final By card_number_locator                  = By.cssSelector("input[name='card_number']");
    private final By card_cvc                             = By.cssSelector("input[name='cvc']");
    private final By card_Expiration_date_month           = By.cssSelector("input[name='expiry_month']");
    private final By card_Expiration_date_year            = By.cssSelector("input[name='expiry_year']");

    //private final By success_payment_message_locator = By.cssSelector("div[class=\"col-md-12 form-group\"]#success_message div[class=\"alert-success alert\"]");
    private final By success_payment_message_locator = By.cssSelector("#success_message .alert-success");
    private final By download_invoice_locator        = By.cssSelector("div[class=\"col-sm-9 col-sm-offset-1\"]  a[class=\"btn btn-default check_out\"]");
    private final By continue_button_locator         = By.cssSelector("div[class=\"pull-right\"] a");

    private final By congratulate_placed_order_message_locator = By.cssSelector("div[class=\"col-sm-9 col-sm-offset-1\"] p");

    // constructor
    public payment_page(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        frame=new Framework(driver);
    }

    public void Enter_payment_details(PaymentCardData card_info )
    {
        frame.sendKeys(name_on_card_locator,card_info.getName_on_card());
        frame.sendKeys(card_number_locator,card_info.getCard_number());
        frame.sendKeys(card_cvc ,card_info.getCard_cvs());
        frame.sendKeys(card_Expiration_date_month ,card_info.getCard_Expiration_date_month());
        frame.sendKeys( card_Expiration_date_year  ,card_info.getCard_Expiration_date_year());

    }
    public void pay_and_confirm()
    {
        frame.click(pay_and_confirm_order_button_locator);
    }

    public String verify_success_order_place_message()
    {
        return frame.getText(success_payment_message_locator);
    }
    public String verify_congratulate_placed_order_message()
    {
        return frame.getText(congratulate_placed_order_message_locator);
    }
    public void download_invoice()
    {
        frame.click(download_invoice_locator);
    }

    public HomePageLoggedIn click_continue()
    {
        frame.click(continue_button_locator);
        return new HomePageLoggedIn(driver);
    }
    public DeleteAccountPage delete_account()
    {
        frame.click(delete_account_button);
        return new DeleteAccountPage(driver);
    }

}
