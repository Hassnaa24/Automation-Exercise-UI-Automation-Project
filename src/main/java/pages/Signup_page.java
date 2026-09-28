package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Framework;

public class Signup_page extends BasePage {
    private final WebDriver driver;
    private final Framework frame;

     // *******locators********
    By Enter_Account_Information_text_locator = By.cssSelector(" div[class=\"login-form\"] h2[class=\"title text-center\"]");
    By title_Mr_locator        = By.cssSelector("div[class=\"clearfix\"] div[class=\"radio-inline\"] label[for=\"id_gender1\"]");
    By title_Mrs_locator       = By.cssSelector("div[class=\"clearfix\"] div[class=\"radio-inline\"] label[for=\"id_gender2\"]");
    By name_signup_locator     = By.cssSelector("form div[class=\"required form-group\"] input#name");
    By email_signup_locator    = By.cssSelector("form div[class=\"required form-group\"] input#email");
    By password_signup_locator = By.cssSelector("form div[class=\"required form-group\"] input#password");

      // drop_down_date of birth
    By date_of_birth_day   = By.cssSelector("div[class=\"form-group\"] div#uniform-days select");
    By date_of_birth_month = By.cssSelector("div[class=\"form-group\"] div#uniform-months select");
    By date_of_birth_year  = By.cssSelector("div[class=\"form-group\"] div#uniform-years select");
    //
    By Sign_up_newsletter_checkbox     = By.cssSelector("div[class=\"checkbox\"] input#newsletter");
    By Receive_special_offers_checkbox = By.cssSelector("div[class=\"checkbox\"] input#optin");
    //
    By first_name_locator            = By.cssSelector("p[class=\"required form-group\"] input#first_name");
    By last_name_locator             = By.cssSelector("p[class=\"required form-group\"] input#last_name");
    By company_locator               = By.cssSelector("p[class=\"form-group\"] input#company");
    By address_1_locator             = By.cssSelector("p[class=\"required form-group\"] input#address1");
    By address_2_locator             = By.cssSelector("p[class=\"required form-group\"] input#address2");
    By country_locator               = By.cssSelector("p[class=\"required form-group\"] select#country");
    By state_locator                 = By.cssSelector("p[class=\"required form-group\"] input#state");
    By city_locator                  = By.cssSelector("p[class=\"required form-group\"] input#city");
    By zipcode_locator               = By.cssSelector("p[class=\"required form-group\"] input#zipcode");
    By mobile_number_locator         = By.cssSelector("p[class=\"required form-group\"] input#mobile_number");
    By create_account_button_locator = By.cssSelector("div[class=\"login-form\"] button[type=\"submit\"]");
    By existing_email_error_message_locator =By.cssSelector("div[class=\"signup-form\"] p");

    // constructor
    public Signup_page(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        frame=new Framework(driver);
    }

    // *********** methods *************
    public String enter_info_text()
    {
        return frame.getText(Enter_Account_Information_text_locator);
    }
    // Enter creation account info
    public void choose_title()
    {
        frame.click(title_Mr_locator);
    }
    public void enter_name(String name)
    {
       frame.sendKeys(name_signup_locator,name);
    }
    public void enter_password(String password)
    {
        frame.sendKeys(password_signup_locator,password);
    }
    public void select_birth_data(String day, String month, String year)
    {
        frame.selectDropdownByVisibleText(date_of_birth_day,day);
        frame.selectDropdownByVisibleText(date_of_birth_month ,month);
        frame.selectDropdownByVisibleText(date_of_birth_year,year);
    }
    public void select_checkboxes()
    {
        frame.click(Sign_up_newsletter_checkbox);
        frame.click(Receive_special_offers_checkbox);
    }
    public void enter_first_name(String first_name)
    {
        frame.sendKeys(first_name_locator,first_name);
    }
    public void enter_last_name(String last_name)
    {
        frame.sendKeys(last_name_locator,last_name);
    }
    public void enter_company(String company)
    {
        frame.sendKeys(company_locator,company);
    }
    public void enter_address_1(String address)
    {
        frame.sendKeys(address_1_locator,address);
    }
    public void enter_address_2(String address)
    {
        frame.sendKeys(address_2_locator,address);
    }
    public void select_country(String country)
    {
        frame.selectDropdownByVisibleText(country_locator,country);
    }
    public void enter_state(String state)
    {
        frame.sendKeys(state_locator,state);
    }
    public void enter_city(String city)
    {
        frame.sendKeys(city_locator ,city);
    }
    public void enter_zipcode(String zipcode)
    {
        frame.sendKeys(zipcode_locator,zipcode);
    }
    public void enter_mobile_number(String mobile)
    {
        frame.sendKeys(mobile_number_locator ,mobile);
    }
    public AccountCreatedPage create_account_click()
    {
        frame.click(create_account_button_locator);
        return new AccountCreatedPage(driver);
    }
    public String verify_existing_email_error_message()
    {
        return frame.getText(existing_email_error_message_locator);
    }
    // //////////
    /*
    public account_created_page perform_sign_up()
    {
        // select title
        frame.click(title_Mr_locator);
        // enter name ***(not necessary)***
                           // frame.sendKeys(name_signup_locator,"dd");
        // enter email ***(not necessary)***(disabled)
                          // frame.sendKeys(email_signup_locator,"dfgfdgd@yahoo.com");
        // enter password
        frame.sendKeys(password_signup_locator,"dd");
        // select date of birth
        frame.selectDropdownByVisibleText(date_of_birth_day,"1");
        frame.selectDropdownByVisibleText(date_of_birth_month ,"May");
        frame.selectDropdownByVisibleText(date_of_birth_year,"2000");
        // checkboxes
        frame.click(Sign_up_newsletter_checkbox);
        frame.click(Receive_special_offers_checkbox);
        // enter first name
        frame.sendKeys(first_name_locator,"dd");
        // enter last name
        frame.sendKeys(last_name_locator,"dd");
        //enter company
        frame.sendKeys(company_locator,"dd");
        // enter address 1
        frame.sendKeys(address_1_locator,"dd");
        // enter address 2
        frame.sendKeys(address_2_locator,"dd");
        // enter country
        //frame.selectDropdownByIndex(country_locator,1);
        frame.selectDropdownByVisibleText(country_locator,"india");

        // enter state
        frame.sendKeys(state_locator,"dd");
        // enter city
        frame.sendKeys(city_locator ,"dd");
        // enter zipcode
        frame.sendKeys(zipcode_locator,"dd");
        // enter mobile number
        frame.sendKeys(mobile_number_locator ,"dd");
        // click submit (create account)
        frame.click(create_account_button_locator);

        return new  account_created_page(driver);
    }

     */



}
