package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Framework;

/**
 * Base Page Object that contains common WebDriver functionality,
 * shared locators, and reusable actions used across all application
 * page objects.
 *
 * This class follows the Page Object Model (POM) design pattern.
 * Individual page classes can extend this class to reuse common
 * navigation, scrolling, subscription, and browser interaction
 * functionality without duplicating code.
 *
 * The class delegates browser interactions to the {@link Framework}
 * utility class, keeping low-level WebDriver operations centralized
 * within the automation framework.
 */
public class BasePage {


    // WebDriver instance shared by all Page Objects that extend BasePage.
    protected WebDriver driver;

    // Framework utility used by Page Objects to perform
    // common browser interactions.
    protected Framework frame;

    // =========================================================================================
    // Common Page Locators
    // =========================================================================================

    /*
     * Locator for the "Scroll Up" arrow displayed in the bottom-right
     * corner of the page.
     */
    protected final By upArrowButtonLocator =
            By.cssSelector("i[class=\"fa fa-angle-up\"]");

    /*
     * Locator for the main heading displayed in the Home page carousel.
     */
    protected final By head_page_text_locator =
            By.cssSelector("div[class=\"carousel-inner\"] h2");

    /*
     * Locator for the Home page header.
     * Used as a reference point when scrolling back to the top.
     */
    protected final By header_home_page_locator =
            By.cssSelector("header#header");


    // =========================================================================================
    // Main Navigation Locators
    // =========================================================================================

    /*
     * Main navigation menu locators.
     *
     * These locators represent the common navigation options available
     * to users throughout the application.
     */

    // Home navigation button.
    protected final By Home_button =
            By.cssSelector("ul[class=\"nav navbar-nav\"] li:nth-of-type(1)");

    // Products navigation button.
    protected final By products_button =
            By.cssSelector("ul[class=\"nav navbar-nav\"] li:nth-of-type(2)");

    // Shopping Cart navigation button.
    protected final By cart_button =
            By.cssSelector("ul[class=\"nav navbar-nav\"] li:nth-of-type(3)");

    // Signup / Login navigation button.
    protected final By signup_login_button =
            By.cssSelector("ul[class=\"nav navbar-nav\"] li:nth-of-type(4)");

    // Test Cases navigation button for a logged-out user.
    protected final By testCases_button =
            By.cssSelector("ul[class=\"nav navbar-nav\"] li:nth-of-type(5)");

    // Test Cases navigation button for a logged-in user.
    protected final By testCases_button_logged_in =
            By.cssSelector("ul[class=\"nav navbar-nav\"] li:nth-of-type(6)");

    // Contact Us navigation button for a logged-out user.
    protected final By contactUs_button =
            By.cssSelector("ul[class=\"nav navbar-nav\"] li:nth-of-type(8)");

    // Contact Us navigation button for a logged-in user.
    protected final By contactUs_button_logged_in =
            By.cssSelector("ul[class=\"nav navbar-nav\"] li:nth-of-type(9)");

    // =========================================================================================
    // Footer and Authentication Locators
    // =========================================================================================

    /*
     * Locator for the footer section.
     * Used when scrolling to the bottom of the page.
     */
    protected final By footer_locator =
            By.cssSelector("div[class=\"footer-bottom\"]");

    /*
     * Locator for the "Logged in as username" navigation item.
     * Used to verify that authentication was successful.
     */
    protected final By logged_as_button =
            By.cssSelector("ul[class=\"nav navbar-nav\"] li:nth-of-type(10)");

    /*
     * Locator for the "Delete Account" button.
     * Used to remove the test account after test execution.
     */
    protected final By delete_account_button =
            By.cssSelector("ul[class=\"nav navbar-nav\"] li:nth-of-type(5)");

    /*
     * Locator for the "Logout" button.
     * Used to terminate the authenticated user session.
     */
    protected final By logout_button =
            By.cssSelector("ul[class=\"nav navbar-nav\"] li:nth-of-type(4)");


    // =========================================================================================
    // Subscription Locators
    // =========================================================================================

    /*
     * Locator for the subscription widget displayed in the footer.
     */
    protected final By subscription_text =
            By.cssSelector("div[class=\"single-widget\"]");

    /*
     * Locator for the email input field used for newsletter subscription.
     */
    protected final By subscription_email_box =
            By.cssSelector(
                    "div[class=\"single-widget\"] input[type=\"email\"]"
            );

    /*
     * Locator for the subscription submit button.
     */
    protected final By subscription_email_button =
            By.cssSelector(
                    "div[class=\"single-widget\"] button[type=\"submit\"]"
            );

    /*
     * Locator for the success message displayed after
     * successfully subscribing to the newsletter.
     */
    protected final By subscription_success_text =
            By.cssSelector(
                    "div#success-subscribe div[class=\"alert-success alert\"]"
            );


    // =========================================================================================
    // Constructor
    // =========================================================================================

    // Constructor initializes the shared WebDriver and Framework.
    public BasePage(WebDriver driver) {

        // Store the WebDriver instance.
        this.driver = driver;

        // Initialize the Framework using the same WebDriver.
        this.frame = new Framework(driver);
    }


    // =========================================================================================
    // Browser and Navigation Methods
    // =========================================================================================

    /**
     * Closes the current browser session.
     *
     * This method delegates the browser-closing operation to
     * the Framework utility class.
     *
     */
    public void close_page() {
        frame.closeBrowser();
    }


    /**
     * Navigates the browser to the specified URL.
     *
     * @param url Target URL to be opened.
     */
    public void goToUrl(String url) {
        frame.navigateToURL(url);
    }


    /**
     * Retrieves the current URL displayed in the browser.
     *
     * @return Current page URL.
     */
    public String getPageUrl() {
        return frame.getCurrentURL();
    }


    /**
     * Refreshes the current browser page.
     */
    public void refresh_page() {
        frame.refreshPage();
    }


    // =========================================================================================
    // Scrolling Methods
    // =========================================================================================

    /**
     * Clicks the "Scroll Up" arrow button to move the page
     * back toward the top of the Home page.
     */
    public void up_arrow_click() {
        frame.click(upArrowButtonLocator);
    }


    /**
     * Retrieves the main heading displayed on the Home page.
     *
     * @return Text of the Home page heading.
     */
    public String home_page_text() {
        return frame.getText(head_page_text_locator);
    }


    /**
     * Scrolls the page until the footer section becomes visible.
     */
    public void scroll_to_footer() {
        frame.scrollToElement(footer_locator);
    }


    /**
     * Scrolls the page back to the Home page header.
     *
     * <p>
     * The header is used as the reference element to ensure
     * that the page has returned to the top.
     * </p>
     */
    public void scroll_Up_page() {
        frame.scrollToElement(header_home_page_locator);
    }


    // =========================================================================================
    // Subscription Methods
    // =========================================================================================

    /**
     * Retrieves the subscription section text displayed
     * in the page footer.
     *
     * @return Subscription section text.
     */
    public String verify_subscription_text() {
        return frame.getText(subscription_text);
    }


    /**
     * Enters an email address into the subscription field
     * and submits the subscription request.
     *
     * @param text Email address to subscribe with.
     */
    public void send_subscription_email_and_click(String text) {

        // Enter the email address into the subscription field.
        frame.sendKeys(subscription_email_box, text);

        // Submit the subscription request.
        frame.click(subscription_email_button);
    }


    /**
     * Retrieves the success message displayed after
     * a successful newsletter subscription.
     *
     * @return Subscription success message.
     */
    public String verify_success_subscription_text() {
        return frame.getText(subscription_success_text);
    }

}
