package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // ******************************************* locators ******************************************************

    // login locator
    By login_email = By.cssSelector("div[class=\"col-sm-4 col-sm-offset-1\"] input[type=\"email\"]");
    By login_password = By.cssSelector("div[class=\"col-sm-4 col-sm-offset-1\"] input[type=\"password\"]");
    By login_button = By.cssSelector("div[class=\"col-sm-4 col-sm-offset-1\"] button[type=\"submit\"]");
    By login_page_verification_message = By.cssSelector("div[class=\"col-sm-4 col-sm-offset-1\"] div[class=\"login-form\"] h2");
    By invalid_login_text_message_locator = By.cssSelector("div[class=\"login-form\"] p");

    // sign up locator
    By signup_name = By.cssSelector("form[action=\"/signup\"] input[type=\"text\"]");
    By signup_email = By.cssSelector("form[action=\"/signup\"] input[type=\"email\"]");
    By signup_button = By.cssSelector("form[action=\"/signup\"] button[type=\"submit\"]");
    By signup_page_verification_message = By.cssSelector("div[class=\"signup-form\"] h2");


    //   ************************************* methods ***************************************************
    public String verify_login_text() {
        return frame.getText(login_page_verification_message);
    }

    public HomePageLoggedIn perform_login(String email, String password) {
        frame.sendKeys(login_email, email);
        frame.sendKeys(login_password, password);
        frame.click(login_button);
        return new HomePageLoggedIn(driver);
    }

    public String verify_invalid_login_text() {
        return frame.getText(invalid_login_text_message_locator);
    }

    /*
    public void send_email_login(String email)
    {
        frame.sendKeys(login_email,email);
    }
    public void send_password_login(String password)
    {
       frame.sendKeys(login_password,password);
    }
    public void click_button_login()
    {
       frame.click(login_button);
    } */
    // *****************************************************************************************************
    public String verify_sign_up_text() {
        return frame.getText(signup_page_verification_message);
    }

    public Signup_page perform_sign_up(String name, String email) {
        frame.sendKeys(signup_name, name);
        frame.sendKeys(signup_email, email);
        frame.click(signup_button);
        return new Signup_page(driver);
    }

    /*
   public void send_name_signup(String name)
   {
      frame.sendKeys(signup_name,name);
   }
   public void send_email_signup(String email)
   {
       frame.sendKeys(signup_email,email);
   }
   public void click_button_signup()
   {
      frame.click(signup_button);
   } */

    public Home_page navigate_to_home_page()
    {
        frame.click(Home_button);
        return new Home_page(driver);
    }
}