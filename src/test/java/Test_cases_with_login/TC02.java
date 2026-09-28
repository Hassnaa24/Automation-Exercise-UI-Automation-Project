package Test_cases_with_login;

import Base.BaseTest;
import Pojo_classes.AccountCreationData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilities.helper_Functions;


public class TC02 extends BaseTest {

    // Home page object used throughout the test workflow
    private Home_page homepage ;

    // Load test data for account creation from the JSON file
    private final AccountCreationData[]  data = helper_Functions.read_from_json("Data", AccountCreationData[].class);

    /**
     * Prepares the test environment by creating a new user account
     * using test data loaded from the external JSON file.
     *
     * The setup performs the following actions:
     * - Opens the Automation Exercise website.
     * - Verifies that the Home page is displayed.
     * - Navigates to the Signup / Login page.
     * - Creates a new user account using the configured test data.
     * - Verifies that the account is created successfully.
     * - Logs out from the newly created account.
     * - Returns to the Home page.
     *
     * This setup provides a registered user account that can be used
     * by the TC02 login test.
     */

    @BeforeMethod(groups = "Smoke Test")
    public void SetUp(){

        // Initialize the Home Page object after BaseTest has created
        // the WebDriver instance.
        homepage = new Home_page(driver_under_test);

        // =========================================================
        // Step 1 & 2: Launch browser and navigate to the application
        // =========================================================

        Allure.step(
                "Navigate to the Automation Exercise Home page",
                () -> homepage.goToUrl(url_under_test)
        );

        // =========================================================
        // Step 3: Verify that the Home page is displayed
        // =========================================================

        Allure.step(
                "Verify that the Home page is displayed successfully",
                () -> {

                    String expectedUrl =
                            "https://automationexercise.com/";

                    String actualUrl =
                            homepage.getPageUrl();

                    helper_Functions.saveScreenshot(
                            "TC02_setup",
                            "Verify_Home_Page"
                    );

                    Assert.assertEquals(
                            actualUrl,
                            expectedUrl
                    );
                }
        );


        // =========================================================
        // Navigate to the Signup / Login page
        // =========================================================

        LoginPage loginPage = Allure.step(
                "Navigate to the Signup / Login page",
                homepage::Go_To_signup_login_page
        );

        // =========================================================
        // Verify the New User Signup section
        // =========================================================


        LoginPage finalLoginPage = loginPage;
        Allure.step(
                "Verify that the 'New User Signup!' section is displayed",
                () -> {

                    String expectedText =
                            "New User Signup!";

                    String actualText =
                            finalLoginPage.verify_sign_up_text();

                    helper_Functions.saveScreenshot(
                            "TC02_setup",
                            "Verify_New_User_Signup"
                    );

                    Assert.assertEquals(
                            actualText,
                            expectedText
                    );
                }
        );

        // =========================================================
        // Enter new user name and email and start registration
        // =========================================================


        LoginPage finalLoginPage1 = loginPage;
        Signup_page signupPage = Allure.step(
                "Enter the new user's name and email address and start registration",
                () -> finalLoginPage1.perform_sign_up(
                        data[0].getName(),
                        data[0].getEmail_address()
                )
        );

        // =========================================================
        // Verify Account Information section
        // =========================================================

        Allure.step(
                "Verify that the 'ENTER ACCOUNT INFORMATION' section is displayed",
                () -> {

                    String expectedText =
                            "ENTER ACCOUNT INFORMATION";

                    String actualText =
                            signupPage.enter_info_text();

                    helper_Functions.saveScreenshot(
                            "TC02_setup",
                            "Verify_Account_Information_Section"
                    );

                    Assert.assertEquals(
                            actualText,
                            expectedText
                    );
                }
        );

        // =========================================================
        // Fill account information
        // =========================================================

        Allure.step(
                "Fill the user's account credentials and date of birth",
                () -> {

                    // Select the user's title.
                    signupPage.choose_title();

                    // Enter the user's name.
                    signupPage.enter_name(
                            data[0].getName()
                    );

                    // Enter the user's password.
                    signupPage.enter_password(
                            data[0].getPassword()
                    );

                    // Select the user's date of birth.
                    signupPage.select_birth_data(
                            data[0].getDay(),
                            data[0].getMonth(),
                            data[0].getYear()
                    );
                }
        );

        // =========================================================
        // Select newsletter and special-offer checkboxes
        // =========================================================

        Allure.step(
                "Select the required account preference checkboxes",
                signupPage::select_checkboxes
        );

        // =========================================================
        // Fill personal and address information
        // =========================================================

        Allure.step(
                "Enter the user's personal, address, and contact information",
                () -> {

                    signupPage.enter_first_name(
                            data[0].getFirst_name()
                    );

                    signupPage.enter_last_name(
                            data[0].getLast_name()
                    );

                    signupPage.enter_company(
                            data[0].getCompany()
                    );

                    signupPage.enter_address_1(
                            data[0].getAddress_1()
                    );

                    signupPage.enter_address_2(
                            data[0].getAddress_2()
                    );

                    signupPage.select_country(
                            data[0].getCountry()
                    );

                    signupPage.enter_state(
                            data[0].getState()
                    );

                    signupPage.enter_city(
                            data[0].getCity()
                    );

                    signupPage.enter_zipcode(
                            data[0].getZipcode()
                    );

                    signupPage.enter_mobile_number(
                            data[0].getMobile_number()
                    );
                }
        );

        // =========================================================
        // Create the account
        // =========================================================

        AccountCreatedPage accountCreatedPage = Allure.step(
                "Submit the registration form and create the user account",
                signupPage::create_account_click
        );

        // =========================================================
        // Verify successful account creation
        // =========================================================

        Allure.step(
                "Verify that the account has been created successfully",
                () -> {

                    String expectedMessage =
                            "ACCOUNT CREATED!";

                    String actualMessage =
                            accountCreatedPage.getSuccessCreationMessage();

                    helper_Functions.saveScreenshot(
                            "TC02_setup",
                            "Verify_Account_Created"
                    );

                    Assert.assertEquals(
                            actualMessage,
                            expectedMessage
                    );
                }
        );


        // =========================================================
        // Continue to the logged-in Home page
        // =========================================================

        HomePageLoggedIn loggedInPage = Allure.step(
                "Continue to the Home page after successful registration",
                accountCreatedPage::clickContinue
        );

        // =========================================================
        // Verify that the user is logged in
        // =========================================================

        Allure.step(
                "Verify that the newly created user is logged in successfully",
                () -> {

                    String expectedText =
                            "Logged in as";

                    String actualText =
                            loggedInPage.verify_logged_as();

                    helper_Functions.saveScreenshot(
                            "TC02_setup",
                            "Verify_Logged_In_User"
                    );

                    Assert.assertTrue(
                            actualText.contains(expectedText)
                    );
                }
        );

        // =========================================================
        // Logout from the newly created account
        // =========================================================

        loginPage = Allure.step(
                "Log out from the newly created user account",
                loggedInPage::log_out
        );

        // =========================================================
        // Return to the Home page
        // =========================================================

        homepage = Allure.step(
                "Return to the Home page after logout",
                loginPage::navigate_to_home_page
        );
    }

    /**
     * Verifies that a registered user can successfully log in
     * using valid email address and password credentials.
     *
     * The test navigates to the Login page, authenticates using
     * a valid existing user, verifies the authenticated session,
     * and finally deletes the account created during test setup.
     */
    @Link(
            name = "Automation Exercise - Test Case 02",
            url = "https://automationexercise.com/test_cases"
    )

    @Epic("Automation Exercise Website")
    @Feature("Authentication")
    @Story("Login with Valid Credentials")

    @Description("""
Verifies that a registered user can successfully log in using
a valid email address and password. The test confirms that the
user is authenticated successfully and then deletes the account
to clean up the test data.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)


    @Test(groups = "Smoke Test")
    public void TC02_Login_User_with_correct_email_and_password() {


        // Index of the registered user whose credentials
        // will be used for the login operation.
        final int userIndex = 0;

        // =========================================================
        // Step 1 & 2:
        // Launch the browser and navigate to the application.
        // =========================================================

        Allure.step(
                "Navigate to the Automation Exercise Home page",
                () -> homepage.goToUrl(url_under_test)
        );

        // =========================================================
        // Step 3:
        // Verify that the Home page is displayed successfully.
        // =========================================================

        Allure.step(
                "Verify that the Home page is displayed successfully",
                () -> {

                    String expectedUrl =
                            "https://automationexercise.com/";

                    String actualUrl =
                            homepage.getPageUrl();

                    helper_Functions.saveScreenshot(
                            "TC02",
                            "Verify_Home_Page"
                    );

                    Assert.assertEquals(
                            actualUrl,
                            expectedUrl
                    );
                }
        );

        // =========================================================
        // Step 4:
        // Navigate to the Signup / Login page.
        // =========================================================

        LoginPage loginPage = Allure.step(
                "Navigate to the Signup / Login page",
                homepage::Go_To_signup_login_page
        );

        // =========================================================
        // Steps 5 - 7:
        // Enter valid credentials and perform the login.
        // =========================================================

        HomePageLoggedIn loggedInPage = Allure.step(
                "Log in using valid email address and password",
                () -> logIn.sign_in(loginPage, userIndex)
        );

        // =========================================================
        // Step 8:
        // Verify that the user is successfully authenticated.
        // =========================================================

        Allure.step(
                "Verify that the user is logged in successfully",
                () -> {

                    String expectedLoggedInText =
                            "Logged in as";

                    String actualLoggedInText =
                            loggedInPage.verify_logged_as();

                    helper_Functions.saveScreenshot(
                            "TC02",
                            "Verify_Logged_In_User"
                    );

                    Assert.assertTrue(
                            actualLoggedInText.contains(
                                    expectedLoggedInText
                            )
                    );
                }
        );

        // =========================================================
        // Step 9:
        // Delete the user account created during test setup.
        // =========================================================

        DeleteAccountPage deleteAccountPage = Allure.step(
                "Delete the registered user account",
                loggedInPage::delete_account
        );

        // =========================================================
        // Step 10:
        // Verify that the account has been deleted successfully.
        // =========================================================

        Allure.step(
                "Verify that the account has been deleted successfully",
                () -> {

                    String expectedDeleteMessage =
                            "ACCOUNT DELETED!";

                    String actualDeleteMessage =
                            deleteAccountPage.get_success_delete_message();

                    helper_Functions.saveScreenshot(
                            "TC02",
                            "Verify_Account_Deleted"
                    );

                    Assert.assertEquals(
                            actualDeleteMessage,
                            expectedDeleteMessage
                    );
                }
        );

        // Continue to the Home page after account deletion.
        Allure.step(
                "Continue to the Home page after account deletion",
                deleteAccountPage::click_continue
        );
    }

}