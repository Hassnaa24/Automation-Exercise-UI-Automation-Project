package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    /**
     * Initializes the LoginPage and inherits the WebDriver setup
     * and shared page functionality from BasePage.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // ========================== LOCATORS ==========================

    // -------------------------- Login Section --------------------------

    // Locates the email input field within the login form.
    By login_email = By.cssSelector("div[class=\"col-sm-4 col-sm-offset-1\"] input[type=\"email\"]");

    // Locates the password input field within the login form.
    By login_password = By.cssSelector("div[class=\"col-sm-4 col-sm-offset-1\"] input[type=\"password\"]");

    // Locates the submit button used to submit login credentials.
    By login_button = By.cssSelector("div[class=\"col-sm-4 col-sm-offset-1\"] button[type=\"submit\"]");

    // Locates the heading used to verify that the login section is displayed.
    By login_page_verification_message = By.cssSelector("div[class=\"col-sm-4 col-sm-offset-1\"] div[class=\"login-form\"] h2");

    // Locates the message displayed by the login form, such as an invalid-login error.
    By invalid_login_text_message_locator = By.cssSelector("div[class=\"login-form\"] p");


    // -------------------------- Sign-Up Section --------------------------

    // Locates the name input field in the sign-up form.
    By signup_name = By.cssSelector("form[action=\"/signup\"] input[type=\"text\"]");

    // Locates the email input field in the sign-up form.
    By signup_email = By.cssSelector("form[action=\"/signup\"] input[type=\"email\"]");

    // Locates the submit button used to submit sign-up details.
    By signup_button = By.cssSelector("form[action=\"/signup\"] button[type=\"submit\"]");

    // Locates the heading used to verify that the sign-up section is displayed.
    By signup_page_verification_message = By.cssSelector("div[class=\"signup-form\"] h2");


    // ========================== METHODS ==========================

    /**
     * Retrieves the heading text displayed in the login section.
     *
     * @return the login section heading text
     */
    public String verify_login_text() {
        return frame.getText(login_page_verification_message);
    }

    /**
     * Enters the supplied credentials and submits the login form.
     *
     * @param email    the user's email address
     * @param password the user's password
     * @return a HomePageLoggedIn page object for subsequent interactions
     */
    public HomePageLoggedIn perform_login(String email, String password) {
        frame.sendKeys(login_email, email);
        frame.sendKeys(login_password, password);
        frame.click(login_button);
        return new HomePageLoggedIn(driver);
    }

    /**
     * Retrieves the message displayed by the login form after an unsuccessful
     * login attempt.
     *
     * @return the login feedback message text
     */
    public String verify_invalid_login_text() {
        return frame.getText(invalid_login_text_message_locator);
    }

    /*
     * The following methods are retained as commented-out alternatives
     * for performing individual login actions separately.
     *
     * public void send_email_login(String email)
     * {
     *     frame.sendKeys(login_email, email);
     * }
     *
     * public void send_password_login(String password)
     * {
     *     frame.sendKeys(login_password, password);
     * }
     *
     * public void click_button_login()
     * {
     *     frame.click(login_button);
     * }
     */

    // -------------------------- Sign-Up Actions --------------------------

    /**
     * Retrieves the heading text displayed in the sign-up section.
     *
     * @return the sign-up section heading text
     */
    public String verify_sign_up_text() {
        return frame.getText(signup_page_verification_message);
    }

    /**
     * Enters the supplied name and email address, then submits the sign-up form.
     *
     * @param name  the name to enter in the sign-up form
     * @param email the email address to enter in the sign-up form
     * @return a Signup_page page object for subsequent registration steps
     */
    public Signup_page perform_sign_up(String name, String email) {
        frame.sendKeys(signup_name, name);
        frame.sendKeys(signup_email, email);
        frame.click(signup_button);
        return new Signup_page(driver);
    }

    /*
     * The following methods are retained as commented-out alternatives
     * for performing individual sign-up actions separately.
     *
     * public void send_name_signup(String name)
     * {
     *     frame.sendKeys(signup_name, name);
     * }
     *
     * public void send_email_signup(String email)
     * {
     *     frame.sendKeys(signup_email, email);
     * }
     *
     * public void click_button_signup()
     * {
     *     frame.click(signup_button);
     * }
     */

    /**
     * Clicks the Home button and returns the Home_page page object.
     *
     * @return a Home_page page object representing the home page
     */
    public Home_page navigate_to_home_page() {
        frame.click(Home_button);
        return new Home_page(driver);
    }
}
