package Test_cases_with_login;

import Pojo_classes.LoginData;
import io.qameta.allure.Allure;
import org.testng.Assert;
import pages.HomePageLoggedIn;
import pages.LoginPage;
import utilities.helper_Functions;

/**
 * Provides reusable login workflows for the Automation Exercise application.
 *
 * This class reads valid user credentials from an external JSON file
 * and provides reusable methods for authenticating users through
 * the Login page.
 */
public class logIn
{
    /**
     * Loads login credentials from the external JSON test-data file.
     *
     * Each element in the array represents one user's email address
     * and password that can be used during automated login scenarios.
     */
    protected static final LoginData[] LOGIN_DATA =
            helper_Functions.read_from_json(
                    "Login_Info",
                    LoginData[].class
            );


    /**
     * Performs a complete login workflow using the credentials
     * stored in the external test data.
     *
     * The method:
     * - Verifies that the Login page is displayed.
     * - Retrieves the user's email and password from the JSON data.
     * - Performs the login operation.
     * - Verifies that the user is successfully authenticated.
     *
     * @param loginPage Login page object.
     * @param index Index of the user credentials in the test-data array.
     * @return HomePage_logged_in representing the authenticated Home page.
     */
    public static HomePageLoggedIn sign_in(LoginPage loginPage, int index)  {

        // =========================================================
        // Verify that the Login page is displayed
        // =========================================================

        Allure.step(
                "Verify that the 'Login to your account' section is displayed",
                () -> {

                    String expectedText =
                            "Login to your account";

                    String actualText =
                            loginPage.verify_login_text();

                    helper_Functions.saveScreenshot(
                            "Login",
                            "Verify_Login_Page"
                    );

                    Assert.assertEquals(
                            actualText,
                            expectedText
                    );
                }
        );

        // =========================================================
        // Retrieve credentials and perform login
        // =========================================================

        HomePageLoggedIn loggedInPage = Allure.step(
                "Enter valid credentials and perform login",
                () -> loginPage.perform_login(
                        LOGIN_DATA[index].getEmail_address(),
                        LOGIN_DATA[index].getPassword()
                )
        );

        // =========================================================
        // Verify successful authentication
        // =========================================================

        Allure.step(
                "Verify that the user is logged in successfully",
                () -> {

                    String expectedLoggedInText =
                            "Logged in as";

                    String actualLoggedInText =
                            loggedInPage.verify_logged_as();

                    helper_Functions.saveScreenshot(
                            "Login",
                            "Verify_Logged_In_User"
                    );

                    Assert.assertTrue(
                            actualLoggedInText.contains(
                                    expectedLoggedInText
                            )
                    );
                }
        );

        // Return the authenticated Home page object
        return loggedInPage;
    }

    /**
     * Performs login using an existing registered user.
     *
     * This workflow is intended for test cases where the user
     * already exists in the application and only authentication
     * is required.
     *
     * @param loginPage Login page object.
     * @param index Index of the existing user's credentials.
     * @return HomePage_logged_in representing the authenticated Home page.
     */
    public static HomePageLoggedIn sign_in_with_exist_user(LoginPage loginPage, int index)
    {
        // Verify that the Login page is displayed.
        Allure.step(
                "Verify that the 'Login to your account' section is displayed",
                () -> {

                    String expectedText =
                            "Login to your account";

                    String actualText =
                            loginPage.verify_login_text();

                    Assert.assertEquals(
                            actualText,
                            expectedText
                    );
                }
        );

        // Retrieve the existing user's credentials from test data.
        String email =
                LOGIN_DATA[index].getEmail_address();

        String password =
                LOGIN_DATA[index].getPassword();

        // Perform login using the existing user's credentials.
        HomePageLoggedIn loggedInPage = Allure.step(
                "Log in using the existing registered user",
                () -> loginPage.perform_login(
                        email,
                        password
                )
        );

        // Verify successful authentication.
        Allure.step(
                "Verify that the existing user is logged in successfully",
                () -> {

                    String expectedLoggedInText =
                            "Logged in as";

                    String actualLoggedInText =
                            loggedInPage.verify_logged_as();

                    Assert.assertTrue(
                            actualLoggedInText.contains(
                                    expectedLoggedInText
                            )
                    );
                }
        );

        return loggedInPage;
    }
}
