package Test_cases_with_login;

import Base.BaseTest;
import Pojo_classes.ExistingEmailSignUpData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Home_page;
import pages.Signup_page;
import pages.LoginPage;
import utilities.helper_Functions;



public class TC05 extends BaseTest {

    private  Home_page homepage ;


    private final ExistingEmailSignUpData[] existingEmailData =
            helper_Functions.read_from_json(
                    "ExistingEmail_SignUp",
                    ExistingEmailSignUpData[].class
            );


    /**
     * Provides existing email addresses used to verify
     * that duplicate account registration is rejected.
     *
     * @return Array of existing email test data.
     */
    @DataProvider(name = "email_exist")
    public ExistingEmailSignUpData[] dataGeneration() {
        return existingEmailData;
    }
    @Link(
            name = "Automation Exercise - Test Case 05",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Authentication")
    @Story("Register User with Existing Email")

    @Description("""
Verifies that the application prevents a user from registering
with an email address that already exists. The test uses multiple
existing email addresses from an external JSON data source and
validates that the appropriate error message is displayed.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.NORMAL)



    @Test(dataProvider = "email_exist")
    public void TC05_Register_User_with_existing_email(ExistingEmailSignUpData existing_email) {

        /**
         * Initializes the Home Page object after the WebDriver
         * has been created by BaseTest.
         */
        homepage = new Home_page(driver_under_test);


        // =========================================================
        // Step 1 & 2: Launch browser and navigate to the application
        // =========================================================

        Allure.step("Navigate to the Automation Exercise Home page", () -> {

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
                    "TC05",
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
        // Step 5: Verify the New User Signup section
        // =========================================================

        Allure.step("Verify that the 'New User Signup!' section is displayed", () -> {

            String expectedText =
                    "New User Signup!";

            String actualText =
                    loginPage.verify_sign_up_text();

            helper_Functions.saveScreenshot(
                    "TC05",
                    "Verify_New_User_Signup");

            Assert.assertEquals(
                    actualText,
                    expectedText
            );

        });

        // =========================================================
        // Step 6 & 7: Enter existing email and attempt registration
        // =========================================================

        Signup_page signupPage = Allure.step(
                "Enter an existing name and email address and attempt to sign up",
                () -> loginPage.perform_sign_up(
                        existing_email.getName(),
                        existing_email.getEmail_address()
                )
        );

        // =========================================================
        // Step 8: Verify the existing email error message
        // =========================================================

        Allure.step(
                "Verify that the existing email error message is displayed",
                () -> {

                    String expectedErrorMessage =
                            "Email Address already exist!";

                    String actualErrorMessage =
                            signupPage.verify_existing_email_error_message();

                    helper_Functions.saveScreenshot(
                            "TC05",
                            "Verify_Existing_Email_Error");

                    Assert.assertEquals(
                            actualErrorMessage,
                            expectedErrorMessage
                    );
                }
        );

    }
}
