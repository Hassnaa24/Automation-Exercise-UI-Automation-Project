package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Signup_page extends BasePage {

    // ========================== LOCATORS ==========================

    // -------------------------- Account Information --------------------------

    // Locates the heading that indicates the Account Information section.
    By Enter_Account_Information_text_locator = By.cssSelector(" div[class=\"login-form\"] h2[class=\"title text-center\"]");

    // Locates the Mr. title option.
    By title_Mr_locator        = By.cssSelector("div[class=\"clearfix\"] div[class=\"radio-inline\"] label[for=\"id_gender1\"]");

    // Locates the Mrs. title option.
    By title_Mrs_locator       = By.cssSelector("div[class=\"clearfix\"] div[class=\"radio-inline\"] label[for=\"id_gender2\"]");

    // Locates the name input field in the sign-up form.
    By name_signup_locator     = By.cssSelector("form div[class=\"required form-group\"] input#name");

    // Locates the email input field in the sign-up form.
    By email_signup_locator    = By.cssSelector("form div[class=\"required form-group\"] input#email");

    // Locates the password input field for the new account.
    By password_signup_locator = By.cssSelector("form div[class=\"required form-group\"] input#password");


    // -------------------------- Date of Birth --------------------------

    // Locates the day dropdown in the date-of-birth section.
    By date_of_birth_day   = By.cssSelector("div[class=\"form-group\"] div#uniform-days select");

    // Locates the month dropdown in the date-of-birth section.
    By date_of_birth_month = By.cssSelector("div[class=\"form-group\"] div#uniform-months select");

    // Locates the year dropdown in the date-of-birth section.
    By date_of_birth_year  = By.cssSelector("div[class=\"form-group\"] div#uniform-years select");


    // -------------------------- Communication Preferences --------------------------

    // Locates the checkbox for subscribing to the newsletter.
    By Sign_up_newsletter_checkbox     = By.cssSelector("div[class=\"checkbox\"] input#newsletter");

    // Locates the checkbox for receiving special offers.
    By Receive_special_offers_checkbox = By.cssSelector("div[class=\"checkbox\"] input#optin");


    // -------------------------- Address Information --------------------------

    // Locates the required first-name input field.
    By first_name_locator            = By.cssSelector("p[class=\"required form-group\"] input#first_name");

    // Locates the required last-name input field.
    By last_name_locator             = By.cssSelector("p[class=\"required form-group\"] input#last_name");

    // Locates the company input field.
    By company_locator               = By.cssSelector("p[class=\"form-group\"] input#company");

    // Locates the first address input field.
    By address_1_locator             = By.cssSelector("p[class=\"required form-group\"] input#address1");

    // Locates the second address input field.
    By address_2_locator             = By.cssSelector("p[class=\"required form-group\"] input#address2");

    // Locates the country dropdown.
    By country_locator               = By.cssSelector("p[class=\"required form-group\"] select#country");

    // Locates the state input field.
    By state_locator                 = By.cssSelector("p[class=\"required form-group\"] input#state");

    // Locates the city input field.
    By city_locator                  = By.cssSelector("p[class=\"required form-group\"] input#city");

    // Locates the ZIP/postal code input field.
    By zipcode_locator               = By.cssSelector("p[class=\"required form-group\"] input#zipcode");

    // Locates the mobile phone number input field.
    By mobile_number_locator         = By.cssSelector("p[class=\"required form-group\"] input#mobile_number");


    // -------------------------- Account Creation and Validation --------------------------

    // Locates the button used to submit the completed account registration form.
    By create_account_button_locator = By.cssSelector("div[class=\"login-form\"] button[type=\"submit\"]");

    // Locates the error message displayed when the submitted email address already exists.
    By existing_email_error_message_locator = By.cssSelector("div[class=\"signup-form\"] p");


    // ========================== CONSTRUCTOR ==========================

    /**
     * Initializes the sign-up page and inherits the shared browser
     * interaction functionality from BasePage.
     *
     * @param driver the WebDriver instance used to control the browser
     */
    public Signup_page(WebDriver driver)
    {
        super(driver);
    }


    // ========================== ACCOUNT INFORMATION ==========================

    /**
     * Retrieves the heading displayed in the Account Information section.
     *
     * @return the account information heading text
     */
    public String enter_info_text()
    {
        return frame.getText(Enter_Account_Information_text_locator);
    }

    /**
     * Selects the Mr. title option in the registration form.
     */
    public void choose_title()
    {
        frame.click(title_Mr_locator);
    }

    /**
     * Enters the user's name in the sign-up form.
     *
     * @param name the name to enter in the registration form
     */
    public void enter_name(String name)
    {
        frame.sendKeys(name_signup_locator,name);
    }

    /**
     * Enters the password for the new account.
     *
     * @param password the password to enter
     */
    public void enter_password(String password)
    {
        frame.sendKeys(password_signup_locator,password);
    }

    /**
     * Selects the user's date of birth using the day, month, and year dropdowns.
     *
     * @param day   the day to select
     * @param month the month to select
     * @param year  the year to select
     */
    public void select_birth_data(String day, String month, String year)
    {
        frame.selectDropdownByVisibleText(date_of_birth_day,day);
        frame.selectDropdownByVisibleText(date_of_birth_month ,month);
        frame.selectDropdownByVisibleText(date_of_birth_year,year);
    }


    // ========================== COMMUNICATION PREFERENCES ==========================

    /**
     * Selects the newsletter subscription and special-offers checkboxes.
     */
    public void select_checkboxes()
    {
        frame.click(Sign_up_newsletter_checkbox);
        frame.click(Receive_special_offers_checkbox);
    }


    // ========================== ADDRESS INFORMATION ==========================

    /**
     * Enters the user's first name.
     *
     * @param first_name the first name to enter
     */
    public void enter_first_name(String first_name)
    {
        frame.sendKeys(first_name_locator,first_name);
    }

    /**
     * Enters the user's last name.
     *
     * @param last_name the last name to enter
     */
    public void enter_last_name(String last_name)
    {
        frame.sendKeys(last_name_locator,last_name);
    }

    /**
     * Enters the company name.
     *
     * @param company the company name to enter
     */
    public void enter_company(String company)
    {
        frame.sendKeys(company_locator,company);
    }

    /**
     * Enters the primary address.
     *
     * @param address the address to enter in the first address field
     */
    public void enter_address_1(String address)
    {
        frame.sendKeys(address_1_locator,address);
    }

    /**
     * Enters the secondary address, such as an apartment or unit number.
     *
     * @param address the address details to enter in the second address field
     */
    public void enter_address_2(String address)
    {
        frame.sendKeys(address_2_locator,address);
    }

    /**
     * Selects the user's country from the country dropdown.
     *
     * @param country the country name to select
     */
    public void select_country(String country)
    {
        frame.selectDropdownByVisibleText(country_locator,country);
    }

    /**
     * Enters the user's state or region.
     *
     * @param state the state or region to enter
     */
    public void enter_state(String state)
    {
        frame.sendKeys(state_locator,state);
    }

    /**
     * Enters the user's city.
     *
     * @param city the city name to enter
     */
    public void enter_city(String city)
    {
        frame.sendKeys(city_locator ,city);
    }

    /**
     * Enters the user's ZIP or postal code.
     *
     * @param zipcode the ZIP or postal code to enter
     */
    public void enter_zipcode(String zipcode)
    {
        frame.sendKeys(zipcode_locator,zipcode);
    }

    /**
     * Enters the user's mobile phone number.
     *
     * @param mobile the mobile phone number to enter
     */
    public void enter_mobile_number(String mobile)
    {
        frame.sendKeys(mobile_number_locator ,mobile);
    }


    // ========================== ACCOUNT CREATION ==========================

    /**
     * Submits the completed registration form and returns the account-created
     * page object for subsequent interactions.
     *
     * @return an AccountCreatedPage page object
     */
    public AccountCreatedPage create_account_click()
    {
        frame.click(create_account_button_locator);
        return new AccountCreatedPage(driver);
    }

    /**
     * Retrieves the error message displayed when the email address
     * is already registered.
     *
     * @return the existing-email error message text
     */
    public String verify_existing_email_error_message()
    {
        return frame.getText(existing_email_error_message_locator);
    }
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




