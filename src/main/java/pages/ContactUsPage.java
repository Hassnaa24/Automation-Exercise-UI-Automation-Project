package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactUsPage extends BasePage {

    // ==================== Page Locators ====================

    // Input field used to enter the user's name.
    By name_box_locator =
            By.cssSelector("form div[class=\"form-group col-md-6\"] input[type=\"text\"]");

    // Input field used to enter the user's email address.
    By email_box_locator =
            By.cssSelector("form div[class=\"form-group col-md-6\"] input[type=\"email\"]");

    // Input field used to enter the subject of the contact message.
    By subject_box_locator =
            By.cssSelector("form div[class=\"form-group col-md-12\"] input[name=\"subject\"]");

    // Text area used to enter the contact message.
    By message_box_locator =
            By.cssSelector("form div[class=\"form-group col-md-12\"] textarea[name=\"message\"]");

    // File input used to upload an attachment with the contact form.
    By upload_file_locator =
            By.cssSelector("form div[class=\"form-group col-md-12\"] input[name=\"upload_file\"]");

    // Submit button used to send the completed contact form.
    By submit_button_locator =
            By.cssSelector("form div[class=\"form-group col-md-12\"] input[name=\"submit\"]");

    // Heading displayed at the top of the contact form.
    By get_in_touch_text_locator =
            By.cssSelector("div[class=\"contact-form\"] h2[class=\"title text-center\"]");

    // Success message displayed after the contact form is submitted successfully.
    By success_submit_message_locator =
            By.cssSelector("div[class=\"status alert alert-success\"]");

    // Button used to navigate back to the Home page after submitting the form.
    By back_home_page_button =
            By.cssSelector("div#form-section a[class=\"btn btn-success\"]");


    // ==================== Constructor ====================

    /**
     * Initializes the Contact Us Page Object.
     *
     * @param driver WebDriver instance used to interact with the page.
     */
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }


    // ==================== Contact Form Verification ====================

    /**
     * Retrieves the main message displayed on the Contact Us page.
     *
     * @return The Contact Us page heading text.
     */
    public String get_page_message() {
        return frame.getText(get_in_touch_text_locator);
    }


    // ==================== Contact Form Input Methods ====================

    /**
     * Enters the user's name into the name field.
     *
     * @param name Name to be entered.
     */
    public void enter_name(String name) {
        frame.sendKeys(name_box_locator, name);
    }

    /**
     * Enters the user's email address into the email field.
     *
     * @param email Email address to be entered.
     */
    public void enter_email(String email) {
        frame.sendKeys(email_box_locator, email);
    }

    /**
     * Enters the subject of the contact message.
     *
     * @param subject Subject to be entered.
     */
    public void enter_subject(String subject) {
        frame.sendKeys(subject_box_locator, subject);
    }

    /**
     * Enters the message content into the message field.
     *
     * @param message Message to be entered.
     */
    public void enter_message(String message) {
        frame.sendKeys(message_box_locator, message);
    }


    // ==================== File Upload ====================

    /**
     * Uploads a file using the Contact Us form.
     *
     * @param filepath Absolute path of the file to be uploaded.
     */
    public void upload_file(String filepath) {
        // Focus the file upload input.
         frame.click(upload_file_locator);

        // Provide the file path to the file input.
        frame.sendKeys(upload_file_locator, filepath);

        // Confirm the file selection if required by the framework/browser.
         frame.click_enter(upload_file_locator);
    }


    // ==================== Form Submission ====================

    /**
     * Submits the completed Contact Us form.
     */
    public void submit() {
        frame.click(submit_button_locator);
    }


    // ==================== Submission Verification ====================

    /**
     * Retrieves the success message displayed after submitting the form.
     *
     * @return Successful submission message.
     */
    public String success_submit_message() {
        return frame.getText(success_submit_message_locator);
    }

    /**
     * Accepts the browser alert displayed after form submission.
     */
    public void OK_message_click() {
        frame.acceptAlert();
    }


    // ==================== Navigation ====================

    /**
     * Navigates back to the Home page from the Contact Us page.
     *
     * @return Home Page Object representing the destination page.
     */
    public Home_page Back_home_page_from_contactus_page() {
        frame.click(back_home_page_button);
        return new Home_page(driver);
    }
}