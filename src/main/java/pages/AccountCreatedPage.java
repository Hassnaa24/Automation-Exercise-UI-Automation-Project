package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object representing the "Account Created" page.
 *
 * This page is displayed after a new user account has been
 * successfully created. It provides functionality to verify
 * the account creation confirmation message and continue
 * to the logged-in Home page.
 *
 */
public class AccountCreatedPage extends BasePage {


    // ============================================================
    // LOCATORS
    // ============================================================

    // Locator for the "ACCOUNT CREATED!" success message.
    private final By accountCreatedTextLocator =
            By.cssSelector(
                    "div[class=\"col-sm-9 col-sm-offset-1\"] h2"
            );

    // Locator for the "Continue" button displayed
    // after successful account creation.
    private final By continueButtonLocator =
            By.cssSelector(
                    "div[class=\"pull-right\"] a"
            );


    /**
     * Initializes the Account Created page using the
     * WebDriver provided by the parent BasePage.
     *
     * @param driver WebDriver instance used by the test.
     */
    public AccountCreatedPage(WebDriver driver) {

        // Pass the WebDriver to BasePage.
        // BasePage initializes both driver and frame.
        super(driver);
    }


    // ============================================================
    // PAGE ACTIONS / METHODS
    // ============================================================
    /**
     * Retrieves the account creation confirmation message.
     *
     * @return The text displayed in the account creation
     *         confirmation section.
     */
    public String getSuccessCreationMessage() {

        // Retrieve and return the "ACCOUNT CREATED!" message.
        return frame.getText(accountCreatedTextLocator);
    }


    /**
     * Clicks the "Continue" button after successful account creation.
     *
     * <p>
     * After clicking Continue, the application navigates to the
     * logged-in Home page. Therefore, this method returns a
     * HomePageLoggedIn Page Object.
     * </p>
     *
     * @return HomePageLoggedIn representing the logged-in Home page.
     */
    public HomePageLoggedIn clickContinue() {

        // Click the Continue button.
        frame.click(continueButtonLocator);

        // Return the next Page Object after navigation.
        return new HomePageLoggedIn(driver);
    }
}
