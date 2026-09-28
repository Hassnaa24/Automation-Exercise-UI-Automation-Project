package Test_cases_with_login;

import Base.BaseTest;
import Pojo_classes.IncorrectEmailPasswordData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Home_page;
import pages.LoginPage;
import utilities.helper_Functions;

public class TC03 extends BaseTest {

    // Home page object used to navigate through the application.
    // It is initialized after the WebDriver is created by BaseTest.
    private  Home_page homepage ;

    /*
     * Load invalid login credentials from the external JSON test-data file.
     *
     * Using an array allows the same test method to be executed with
     * multiple invalid email/password combinations through TestNG's
     * DataProvider mechanism.
     */
    protected final IncorrectEmailPasswordData[] invalid_data = helper_Functions.read_from_json("IncorrectEmailPassword_Info", IncorrectEmailPasswordData[].class);

    @Link(
            name = "Automation Exercise - Test Case 03",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Authentication")
    @Story("Login with Invalid Credentials")

    @Description("""
Verifies that the application prevents login when invalid email
and password combinations are provided. The test uses multiple
invalid credential sets from an external JSON file and validates
that the expected authentication error message is displayed.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)

 /**
 * Provides invalid email and password combinations to the test.
 *
 * Each object in the invalid_data array represents one
 * invalid login scenario.
 *
 * @return Array of invalid login test data.
 **/
    @DataProvider(name="invalid_data")
    public IncorrectEmailPasswordData[] dataGeneration() {
        return invalid_data;
    }

    /**
     * Verifies that the application displays the appropriate
     * error message when a user attempts to log in using
     * invalid email and password credentials.
     *
     * The test is executed once for every data set supplied
     * by the "invalid_data" DataProvider.
     *
     * @param invalidInfo Invalid email and password test data.
     */
    @Test(dataProvider ="invalid_data")
    public void TC03_Login_User_with_incorrect_email_and_password(IncorrectEmailPasswordData invalidInfo)  {

        /**
         * Initializes the Home Page object after the WebDriver
         * has been created by BaseTest.
         */
        homepage = new Home_page(driver_under_test);

        // =========================================================
        // Step 1 & 2: Launch browser and navigate to the application
        // =========================================================

        Allure.step("Navigate to the Automation Exercise home page", () -> {

            homepage.goToUrl(url_under_test);

        });
        // =========================================================
        // Step 3: Verify that the Home page is displayed
        // =========================================================

        Allure.step("Verify that the Home page is displayed successfully", () -> {

            String expectedUrl =
                    "https://automationexercise.com/";

            String actualUrl =
                    homepage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC03",
                    "Verify_Home_Page");

            Assert.assertEquals(
                    actualUrl,
                    expectedUrl
            );

        });

        // =========================================================
        // Step 4: Navigate to the Login page
        // =========================================================

        LoginPage loginPage = Allure.step(
                "Navigate to the Signup / Login page",
                homepage::Go_To_signup_login_page
        );

        // =========================================================
        // Step 5: Verify that the Login section is displayed
        // =========================================================

        Allure.step("Verify that the 'Login to your account' section is displayed", () -> {

            String expectedText =
                    "Login to your account";

            String actualText =
                    loginPage.verify_login_text();

            helper_Functions.saveScreenshot(
                    "TC03",
                    "Verify_Login_Section");

            Assert.assertEquals(
                    actualText,
                    expectedText
            );

        });

        // =========================================================
        // Step 6 & 7: Enter invalid credentials and attempt login
        // =========================================================

        Allure.step("Enter invalid email and password and attempt to log in", () -> {

            loginPage.perform_login(
                    invalidInfo.getEmail_address(),
                    invalidInfo.getPassword()
            );

        });

        // =========================================================
        // Step 8: Verify the invalid login error message
        // =========================================================

        Allure.step("Verify that the invalid login error message is displayed", () -> {

            String expectedErrorMessage =
                    "Your email or password is incorrect!";

            String actualErrorMessage =
                    loginPage.verify_invalid_login_text();

            helper_Functions.saveScreenshot(
                    "TC03",
                    "Verify_Invalid_Login_Error");

            Assert.assertEquals(
                    actualErrorMessage,
                    expectedErrorMessage
            );

        });

    }


}

