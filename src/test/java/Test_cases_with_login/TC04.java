package Test_cases_with_login;
import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import pages.HomePageLoggedIn;
import pages.LoginPage;
import utilities.helper_Functions;


public class  TC04 extends BaseTest {

    private  Home_page homepage ;

    @Link(
            name = "Automation Exercise - Test Case 04",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Authentication")
    @Story("Logout Registered User")

    @Description("""
Verifies that a registered user can successfully log in to the
application and log out from the authenticated session.
The test validates the Home page, navigates to the Login page,
authenticates using an existing user account, and finally
performs the logout operation.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.NORMAL)


    @Test
    public void TC04_Logout_User()  {

        /**
         * Initializes the Home Page object after the WebDriver
         * has been created by BaseTest.
         */
        homepage = new Home_page(driver_under_test);


        // Index of the existing user account used for this test.
        // The credentials are retrieved by the login workflow.
        final int index = 2;

        // =========================================================
        // Step 1 & 2: Launch the browser and navigate to the website
        // =========================================================

        Allure.step("Navigate to the Automation Exercise Home page", () -> {

            homepage.goToUrl(url_under_test);

        });

        // =========================================================
        // Step 3: Verify that the Home page is displayed
        // =========================================================

        Allure.step("Verify that the Home page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/";
            String actualUrl = homepage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC04",
                    "Verify_Home_Page");

            Assert.assertEquals(
                    actualUrl,
                    expectedUrl
            );

        });

        // =========================================================
        // Step 4: Navigate to the Signup / Login page
        // =========================================================

        LoginPage loginPage = Allure.step(
                "Navigate to the Signup / Login page",
                homepage::Go_To_signup_login_page
        );

        // =========================================================
        // Steps 5 - 8: Login using an existing valid user
        // =========================================================

        HomePageLoggedIn loggedInPage = Allure.step(
                "Log in using an existing valid user account",
                () -> logIn.sign_in(loginPage, index)
        );

        // =========================================================
        // Step 9: Logout from the authenticated session
        // =========================================================

        LoginPage loginPageAfterLogout = Allure.step(
                "Log out from the authenticated user session",
                loggedInPage::log_out
        );

        // =========================================================
        // Step 10: Verify that user is navigated to login page
        // =========================================================

        Allure.step("Verify that the Login page is displayed after logout", () -> {

            String expectedText = "Login to your account";
            String actualText = loginPageAfterLogout.verify_login_text();

            helper_Functions.saveScreenshot(
                    "TC04",
                    "Verify_Login_Page_After_Logout");

            Assert.assertEquals(actualText, expectedText);

        });
    }
}
