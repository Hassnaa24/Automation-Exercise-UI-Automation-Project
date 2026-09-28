package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Page Object representing the Shopping Cart page.
 *
 * This class contains the locators and reusable actions required
 * to interact with products in the shopping cart, verify product
 * information, remove products, navigate to LogIn, and proceed
 * to Checkout.
 *
 * The class extends {@link BasePage}, therefore it inherits the
 * WebDriver instance and Framework utility used for browser
 * interactions.
 *
 */
public class CartPage extends BasePage {


    // ============================================================
    // CART PRODUCT LOCATORS
    // ============================================================

    // Locator for the quantity of the first product in the cart.
    private final By item1CartQuantity =
            By.cssSelector(
                    "tr#product-1 td[class=\"cart_quantity\"]"
            );

    // Locator for the total price of the first product in the cart.
    private final By item1CartPrice =
            By.cssSelector(
                    "tr#product-1 td[class=\"cart_total\"] p"
            );

    // Locator for the delete button of the first product.
    private final By item1CartDeleteButton =
            By.cssSelector(
                    "tr#product-1 td[class=\"cart_delete\"] i"
            );


    // Locator for the quantity of the second product in the cart.
    private final By item2CartQuantity =
            By.cssSelector(
                    "tr#product-2 td[class=\"cart_quantity\"]"
            );

    // Locator for the total price of the second product in the cart.
    private final By item2CartPrice =
            By.cssSelector(
                    "tr#product-2 td[class=\"cart_total\"] p"
            );

    // Locator for the delete button of the second product.
    private final By item2CartDeleteButton =
            By.cssSelector(
                    "tr#product-2 td[class=\"cart_delete\"] i"
            );

    // ============================================================
    // SEARCHED PRODUCT LOCATORS
    // ============================================================

    /*
     * Locators for products that were added to the cart
     * from the product search results.
     *
     * These locators are kept separately because TC20 uses
     * specific product IDs from the search scenario.
     */

    // Locator for the first searched product quantity.
    private final By searchItem1CartQuantity =
            By.cssSelector(
                    "tr#product-1 td[class=\"cart_quantity\"]"
            );

    // Locator for the first searched product total price.
    private final By searchItem1CartPrice =
            By.cssSelector(
                    "tr#product-1 td[class=\"cart_total\"] p"
            );

    // Locator for the first searched product delete button.
    private final By searchItem1CartDeleteButton =
            By.cssSelector(
                    "tr#product-1 td[class=\"cart_delete\"] i"
            );


    // Locator for the second searched product quantity.
    private final By searchItem2CartQuantity =
            By.cssSelector(
                    "tr#product-5 td[class=\"cart_quantity\"]"
            );

    // Locator for the second searched product total price.
    private final By searchItem2CartPrice =
            By.cssSelector(
                    "tr#product-5 td[class=\"cart_total\"] p"
            );

    // Locator for the second searched product delete button.
    private final By searchItem2CartDeleteButton =
            By.cssSelector(
                    "tr#product-5 td[class=\"cart_delete\"] i"
            );


    // ============================================================
    // VERIFICATION LOCATORS
    // ============================================================

    // Locator for the message displayed when the cart becomes empty.
    private final By verificationItemDeletedMessage =
            By.cssSelector(
                    "span p[class=\"text-center\"] b"
            );

    // Locator used to verify that a product is displayed in the cart.
    private final By verificationItemInCart =
            By.cssSelector(
                    "div[class=\"table-responsive cart_info\"] " +
                            "table td[class=\"image\"]"
            );

// ============================================================
    // CHECKOUT LOCATORS
    // ============================================================

    // Locator for the "Proceed To Checkout" button.
    private final By proceedCheckoutButton =
            By.cssSelector(
                    "div[class=\"col-sm-6\"] a"
            );

    // Locator for the "Continue Shopping" button
    // displayed inside the checkout modal.
    private final By continueInCartButtonCheckout =
            By.cssSelector(
                    "div[class=\"modal-footer\"]"
            );

    // Locator for the Register / Login link displayed
    // when an unauthenticated user attempts to checkout.
    private final By registerLoginButtonCheckout =
            By.cssSelector(
                    "div[class=\"modal-body\"] p a"
            );

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    /**
     * Initializes the Cart Page.
     *
     * @param driver WebDriver instance created by the test framework.
     */
    public CartPage(WebDriver driver) {

        // Pass the WebDriver to BasePage.
        // BasePage initializes the inherited driver and Framework.
        super(driver);
    }

    // ============================================================
    // AUTHENTICATION / NAVIGATION METHODS
    // ============================================================

    /**
     * Navigates from the Cart page to the Signup / Login page.
     *
     * @return LoginPage representing the Login page.
     */
    public LoginPage goToSignupLoginPageFromCartPage() {

        // Click the Signup / Login navigation button.
        frame.click(signup_login_button);

        // Return the Login Page Object.
        return new LoginPage(driver);
    }

     // ============================================================
    // CART MANAGEMENT METHODS
    // ============================================================

    /**
     * Removes the products from the cart.
     *
     * This method clicks the delete button for both products
     * used in the cart test scenario.
     *
     */
    public void removeItemsFromCart() {

        // Remove the first product.
        frame.click(item1CartDeleteButton);

        // Remove the second product.
        frame.click(item2CartDeleteButton);
    }


    /**
     * Retrieves the message displayed after the cart becomes empty.
     *
     * @return Cart deletion / empty-cart message.
     */
    public String getDeleteSuccessMessage() {

        return frame.getText(
                verificationItemDeletedMessage
        );
    }


    /**
     * Retrieves the quantity of the first product in the cart.
     *
     * @return Product quantity displayed in the cart.
     */
    public String checkCartQuantity() {

        return frame.getText(
                item1CartQuantity
        );
    }


    // ============================================================
    // CART VERIFICATION METHODS
    // ============================================================

    /**
     * Verifies that a product is displayed in the cart.
     *
     * @return Product text displayed in the cart.
     */
    public String verifyItemInCart() {

        return frame.getText(
                verificationItemInCart
        );
    }

    // ============================================================
    // STANDARD CART PRODUCT DETAILS
    // ============================================================

    /**
     * Retrieves the total price of the first product.
     *
     * @return First product total price.
     */
    public String checkItem1Price() {

        return frame.getText(
                item1CartPrice
        );
    }


    /**
     * Retrieves the quantity of the first product.
     *
     * @return First product quantity.
     */
    public String checkItem1Quantity() {

        return frame.getText(
                item1CartQuantity
        );
    }


    /**
     * Retrieves the total price of the second product.
     *
     * @return Second product total price.
     */
    public String checkItem2Price() {

        return frame.getText(
                item2CartPrice
        );
    }


    /**
     * Retrieves the quantity of the second product.
     *
     * @return Second product quantity.
     */
    public String checkItem2Quantity() {

        return frame.getText(
                item2CartQuantity
        );
    }


    // ============================================================
    // SEARCH RESULT PRODUCT DETAILS
    // ============================================================

    /**
     * Retrieves the total price of the first searched product.
     *
     * @return First searched product total price.
     */
    public String checkItem1InSearchPrice() {

        return frame.getText(
                searchItem1CartPrice
        );
    }


    /**
     * Retrieves the quantity of the first searched product.
     *
     * @return First searched product quantity.
     */
    public String checkItem1InSearchQuantity() {

        return frame.getText(
                searchItem1CartQuantity
        );
    }


    /**
     * Retrieves the total price of the second searched product.
     *
     * @return Second searched product total price.
     */
    public String checkItem2InSearchPrice() {

        return frame.getText(
                searchItem2CartPrice
        );
    }


    /**
     * Retrieves the quantity of the second searched product.
     *
     * @return Second searched product quantity.
     */
    public String checkItem2InSearchQuantity() {

        return frame.getText(
                searchItem2CartQuantity
        );
    }

    // ============================================================
    // CHECKOUT METHODS
    // ============================================================

    /**
     * Clicks the "Proceed To Checkout" button.
     */
    public void proceedToCheckout() {

        frame.click(
                proceedCheckoutButton
        );
    }


    /**
     * Navigates to the Login page when the user must
     * authenticate before proceeding to checkout.
     *
     * @return LoginPage representing the Login page.
     */
    public LoginPage loginToProceedToCheckout() {

        // Click the Register / Login link in the checkout modal.
        frame.click(
                registerLoginButtonCheckout
        );

        // Return the Login Page Object.
        return new LoginPage(driver);
    }


    /**
     * Proceeds from the Cart page to the Checkout page
     * for an authenticated or newly registered user.
     *
     * @return CheckoutPage representing the Checkout page.
     */
    public CheckoutPage proceedToCheckoutAfterLoginOrSignup() {

        // Click the Proceed To Checkout button.
        frame.click(
                proceedCheckoutButton
        );

        // Return the Checkout Page Object.
        return new CheckoutPage(driver);
    }

}
