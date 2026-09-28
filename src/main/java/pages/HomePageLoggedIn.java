package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Framework;

public class HomePageLoggedIn extends BasePage {

   private final WebDriver driver;
   private final Framework frame;

    // constructor
    public HomePageLoggedIn(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        frame=new Framework(driver);
    }

    private final By item1_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2) a[class=\"btn btn-default add-to-cart\"]");
    private final By item2_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3) a[class=\"btn btn-default add-to-cart\"]");

    private final  By continue_shopping_button   = By.cssSelector("div[class=\"modal-content\"] div[class=\"modal-footer\"] button");
    private final  By view_chart_button          = By.cssSelector("div[class=\"modal-content\"] div[class=\"modal-body\"] p a");


    //   ************************************************************************************************

    public String verify_logged_as()
    {
        return frame.getText(logged_as_button );
    }

    public DeleteAccountPage delete_account()
    {
        frame.click(delete_account_button);
        return new DeleteAccountPage(driver);
    }

    public LoginPage log_out()
    {
        frame.click(logout_button );
        return new LoginPage(driver);
    }

    public CartPage navigate_to_cart_from_logged_in_page()
    {
        frame.click(cart_button);
        return new CartPage(driver);
    }
    public void add_items_to_cart()
    {
        frame.click(item1_locator_add_to_chart_button);
        frame.click(continue_shopping_button);
        frame.click(item2_locator_add_to_chart_button);
        frame.click(continue_shopping_button);
    }


}
