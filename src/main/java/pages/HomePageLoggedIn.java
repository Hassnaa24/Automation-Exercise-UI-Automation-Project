package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageLoggedIn extends BasePage {

    // ========================== CONSTRUCTOR ==========================

    /**
     * Initializes the logged-in home page and inherits the shared
     * browser interaction functionality from BasePage.
     *
     * @param driver the WebDriver instance used to control the browser
     */
    public HomePageLoggedIn(WebDriver driver)
    {
        super(driver);

    }

    // ========================== PRODUCT LOCATORS ==========================

    // Locates the Add to Cart button for the first target product on the home page.
    private final By item1_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2) a[class=\"btn btn-default add-to-cart\"]");

    // Locates the Add to Cart button for the second target product on the home page.
    private final By item2_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3) a[class=\"btn btn-default add-to-cart\"]");


    // ========================== CART MODAL LOCATORS ==========================

    // Locates the Continue Shopping button displayed in the Add to Cart confirmation modal.
    private final By continue_shopping_button = By.cssSelector("div[class=\"modal-content\"] div[class=\"modal-footer\"] button");

    // Locates the View Cart link displayed in the Add to Cart confirmation modal.
    private final By view_chart_button = By.cssSelector("div[class=\"modal-content\"] div[class=\"modal-body\"] p a");


    // ========================== ACCOUNT METHODS ==========================

    /**
     * Retrieves the text of the account button that indicates
     * the currently logged-in user.
     *
     * @return the text displayed on the logged-in account button
     */
    public String verify_logged_as()
    {
        return frame.getText(logged_as_button );
    }

    /**
     * Clicks the Delete Account button and navigates to the
     * account deletion page.
     *
     * @return a DeleteAccountPage object representing the account deletion page
     */
    public DeleteAccountPage delete_account()
    {
        frame.click(delete_account_button);
        return new DeleteAccountPage(driver);
    }

    /**
     * Logs the current user out of the application.
     *
     * @return a LoginPage object representing the login page
     */
    public LoginPage log_out()
    {
        frame.click(logout_button );
        return new LoginPage(driver);
    }


    // ========================== NAVIGATION METHODS ==========================

    /**
     * Clicks the Cart button to navigate from the logged-in home page
     * to the shopping cart page.
     *
     * @return a CartPage object representing the shopping cart page
     */
    public CartPage navigate_to_cart_from_logged_in_page()
    {
        frame.click(cart_button);
        return new CartPage(driver);
    }


    // ========================== SHOPPING CART METHODS ==========================

    /**
     * Adds the two specified products to the shopping cart.
     * After adding each product, clicks Continue Shopping to close
     * the confirmation modal and return to the product list.
     */
    public void add_items_to_cart()
    {
        frame.click(item1_locator_add_to_chart_button);
        frame.click(continue_shopping_button);
        frame.click(item2_locator_add_to_chart_button);
        frame.click(continue_shopping_button);
    }


}