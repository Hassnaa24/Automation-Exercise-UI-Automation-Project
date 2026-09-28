package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DeleteAccountPage extends BasePage {


    // ==================== Page Locators ====================

    // Message displayed after the user account has been successfully deleted.
    private final By account_deleted_text_locator =
            By.cssSelector("div[class=\"col-sm-9 col-sm-offset-1\"] h2 b");

    // Button used to continue to the Home page after account deletion.
    private final By continue_button_locator =
            By.cssSelector("div[class=\"pull-right\"] a");


    // ==================== Constructor ====================

    /**
     * Initializes the Delete Account Page Object.
     *
     * @param driver WebDriver instance used to interact with the page.
     */
    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }


    // ==================== Account Deletion Verification ====================

    /**
     * Retrieves the success message displayed after account deletion.
     *
     * @return The account deletion success message.
     */
    public String get_success_delete_message() {
        return frame.getText(account_deleted_text_locator);
    }


    // ==================== Navigation ====================

    /**
     * Clicks the Continue button and navigates back to the Home page.
     *
     * @return Home Page Object representing the destination page.
     */
    public Home_page click_continue() {
        frame.click(continue_button_locator);
        return new Home_page(driver);
    }
}


