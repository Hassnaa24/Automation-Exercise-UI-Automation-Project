package Test_cases_with_registration;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageLoggedIn;
import pages.Home_page;
import pages.DeleteAccountPage;
import pages.LoginPage;
import utilities.helper_Functions;

import static Test_cases_with_registration.create_account.sign_up;


public class TC01 extends BaseTest {

        Home_page homepage;

        /**
         * Verifies that a new user can successfully register an account.
         *
         * The test navigates to the Automation Exercise website, verifies
         * that the Home page is displayed, navigates to the Signup / Login
         * page, completes the registration process using the reusable
         * account-creation workflow, verifies successful account creation
         * and login, and finally deletes the created account as test cleanup.
         */

    @Link(
            name = "Automation Exercise - Test Case 01",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("User Registration")
    @Story("Register a New User")

    @Description("""
Verifies that a new user can successfully register an account
using valid registration details. The test validates the Home page,
starts the registration process, verifies successful account
creation and login, and deletes the created account during cleanup.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)

    @Test(groups = "Smoke Test")
        public void  TC01_Register_User()  {

        // Index of the registration data used from the JSON test-data file.
        final int userIndex = 0;

        // Initialize the Home Page object after BaseTest has created
        // the WebDriver instance.
        homepage = new Home_page(driver_under_test);

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
                            "TC01",
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
        // Steps 5 - 16:
        // Create the new user account using the reusable
        // account-registration workflow.
        // =========================================================

        HomePageLoggedIn loggedInPage = Allure.step(
                "Complete the new user registration process",
                () -> sign_up(loginPage, userIndex)
        );

        // =========================================================
        // Step 17:
        // Delete the account created during the test.
        // =========================================================

        DeleteAccountPage deleteAccountPage = Allure.step(
                "Delete the newly created user account",
                loggedInPage::delete_account
        );

        // =========================================================
        // Step 18:
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
                            "TC01",
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


//            final int index=0;
//            String url_under_test = "https://automationexercise.com";
//            // Step: 1. Launch browser
//            // Step: 2. Navigate to url 'http://automationexercise.com'
//            homepage.Go_to_URL(url_under_test);
//
//            //Step: 3. Verify that home page is visible successfully
//            String expected_url= "https://automationexercise.com/";
//            String actual_url = homepage.get_page_url();
//            helper_Functions.saveScreenshot("TC01","Verify that home page is visible successfully");
//            Assert.assertEquals( actual_url,expected_url);
//
//            //Step: 4. Click on 'Signup / Login' button
//            login_page loginPage = homepage.Go_To_signup_login_page();
//
//            // Step: 5. Verify 'New User Signup!' is visible
//            // Step: 6. Enter name and email address
//            // Step: 7. Click 'Signup' button
//            // Step: 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
//            // Step: 9. Fill details: Title, Name, (Email), Password, Date of birth
//            // Step: 10. Select checkbox 'Sign up for our newsletter!'
//            // Step: 11. Select checkbox 'Receive special offers from our partners!'
//            // Step: 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//            // Step: 13. Click 'Create Account button'
//            // Step: 14. Verify that 'ACCOUNT CREATED!' is visible
//            // Step: 15. Click 'Continue' button
//            // Step: 16. Verify that 'Logged in as username' is visible
//            HomePage_logged_in homepage_logged_in = sign_up(loginPage,index);
//
//            // Step: 17. Click 'Delete Account' button
//            delete_account_page delete_accountPage = homepage_logged_in.delete_account();
//
//            // Step: 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
//            String actual_delete_account_text= delete_accountPage.get_success_delete_message();
//            String expected_delete_account_text="ACCOUNT DELETED!";
//            helper_Functions.saveScreenshot("TC01"," Verify that 'ACCOUNT DELETED!' is visible");
//            Assert.assertEquals(actual_delete_account_text, expected_delete_account_text);
//
//            homepage= delete_accountPage.click_continue();

        }


}
