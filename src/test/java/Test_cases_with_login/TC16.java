package Test_cases_with_login;

import Base.BaseTest;
import Pojo_classes.AccountCreationData;
import Pojo_classes.PaymentCardData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilities.helper_Functions;


public class TC16 extends BaseTest {

    // Home page object used throughout the test workflow
    private Home_page homepage;

    // Load test data for account creation from the JSON file
    private final  AccountCreationData[]  data = helper_Functions.read_from_json("Data", AccountCreationData[].class);

    /**
     * Prepares the test environment by creating a registered user account
     * using test data loaded from the external JSON file.
     *
     * The setup performs the complete account registration workflow,
     * verifies successful account creation and authentication, logs out
     * from the newly created account, and returns to the Home page.
     *
     * This ensures that TC16 starts with a valid registered user that
     * can be authenticated before placing an order.
     */
    @BeforeMethod(groups = "Smoke Test")
    public void setUp(){

        // Initialize the Home Page object after BaseTest has created
        // the WebDriver instance
        homepage = new Home_page(driver_under_test);
        // =========================================================
        // Step 1 & 2: Navigate to the Automation Exercise website
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
                            "TC16_setup",
                            "Verify_Home_Page"
                    );

                    Assert.assertEquals(
                            actualUrl,
                            expectedUrl
                    );
                }
        );


        // =========================================================
        // Navigate to Signup / Login
        // =========================================================

        LoginPage loginPage = Allure.step(
                "Navigate to the Signup / Login page",
                homepage::Go_To_signup_login_page
        );

        // =========================================================
        // Verify New User Signup section
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
                            "TC16_setup",
                            "Verify_New_User_Signup"
                    );

                    Assert.assertEquals(
                            actualText,
                            expectedText
                    );
                }
        );


        // =========================================================
        // Enter registration name and email
        // =========================================================

        LoginPage finalLoginPage1 = loginPage;
        Signup_page signupPage = Allure.step(
                "Enter the new user's name and email address",
                () -> finalLoginPage1.perform_sign_up(
                        data[1].getName(),
                        data[1].getEmail_address()
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
                            "TC16_setup",
                            "Verify_Account_Information"
                    );

                    Assert.assertEquals(
                            actualText,
                            expectedText
                    );
                }
        );

        // =========================================================
        // Fill account credentials and date of birth
        // =========================================================

        Allure.step(
                "Fill the user's account credentials and date of birth",
                () -> {

                    // Select the user's title.
                    signupPage.choose_title();

                    // Enter the registered user's name.
                    signupPage.enter_name(
                            data[1].getName()
                    );

                    // Enter the account password.
                    signupPage.enter_password(
                            data[1].getPassword()
                    );

                    // Select the user's date of birth.
                    signupPage.select_birth_data(
                            data[1].getDay(),
                            data[1].getMonth(),
                            data[1].getYear()
                    );
                }
        );

         // =========================================================
        // Select account preference checkboxes
        // =========================================================

        Allure.step(
                "Select the required account preference checkboxes",
                signupPage::select_checkboxes
        );

        // =========================================================
        // Fill personal, address and contact information
        // =========================================================

        Allure.step(
                "Enter the user's personal, address and contact information",
                () -> {

                    signupPage.enter_first_name(
                            data[1].getFirst_name()
                    );

                    signupPage.enter_last_name(
                            data[1].getLast_name()
                    );

                    signupPage.enter_company(
                            data[1].getCompany()
                    );

                    signupPage.enter_address_1(
                            data[1].getAddress_1()
                    );

                    signupPage.enter_address_2(
                            data[1].getAddress_2()
                    );

                    signupPage.select_country(
                            data[1].getCountry()
                    );

                    signupPage.enter_state(
                            data[1].getState()
                    );

                    signupPage.enter_city(
                            data[1].getCity()
                    );

                    signupPage.enter_zipcode(
                            data[1].getZipcode()
                    );

                    signupPage.enter_mobile_number(
                            data[1].getMobile_number()
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
                            "TC16_setup",
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
                "Continue to the Home page after account creation",
                accountCreatedPage::clickContinue
        );

        // =========================================================
        // Verify that the newly created user is logged in
        // =========================================================

        Allure.step(
                "Verify that the newly created user is logged in successfully",
                () -> {

                    String expectedText =
                            "Logged in as";

                    String actualText =
                            loggedInPage.verify_logged_as();

                    helper_Functions.saveScreenshot(
                            "TC16_setup",
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


    @Link(
            name = "Automation Exercise - Test Case 16",
            url = "https://automationexercise.com/test_cases"
    )

    @Epic("Automation Exercise Website")
    @Feature("Order Management")
    @Story("Place Order While Logged In")

    @Description("""
Verifies that a registered user can successfully place an order while
logged in to the application. The test prepares an existing user account,
logs in, adds products to the cart, proceeds to checkout, verifies the
delivery address, enters payment information, confirms the order, and
finally deletes the account.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)


    @Test(groups = "Smoke Test")
    public void TC16_Place_Order_Login_before_Checkout()  {

        // Index of the existing user account used for this test.
        final int userIndex = 1;

        // Load payment information from the external JSON test-data file.
        final PaymentCardData cardInfo =
                helper_Functions.read_from_json(
                        "Payment_Info",
                        PaymentCardData.class
                );

        // =========================================================
        // Step 1 & 2: Launch browser and navigate to the application
        // =========================================================

        Allure.step("Navigate to the Automation Exercise Home page", () -> {

            homepage.goToUrl(url_under_test);

        });

        // =========================================================
        // Step 3: Verify Home page
        // =========================================================

        Allure.step("Verify that the Home page is displayed successfully", () -> {

            String expectedUrl =
                    "https://automationexercise.com/";

            String actualUrl =
                    homepage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC16",
                    "Verify_Home_Page"
            );

            Assert.assertEquals(
                    actualUrl,
                    expectedUrl
            );

        });

        // =========================================================
        // Step 4: Navigate to Login page
        // =========================================================

        LoginPage loginPage = Allure.step(
                "Navigate to the Signup / Login page",
                homepage::Go_To_signup_login_page
        );

        // =========================================================
        // Step 5: Login using an existing user
        // =========================================================

        HomePageLoggedIn loggedInPage = Allure.step(
                "Log in using the existing user account",
                () -> logIn.sign_in(loginPage, userIndex)
        );

        // =========================================================
        // Step 6: Verify authenticated user
        // =========================================================

        Allure.step("Verify that the user is logged in successfully", () -> {

            String expectedLoggedInText =
                    "Logged in as";

            String actualLoggedInText =
                    loggedInPage.verify_logged_as();

            helper_Functions.saveScreenshot(
                    "TC16",
                    "Verify_Logged_In_User"
            );

            Assert.assertTrue(
                    actualLoggedInText.contains(expectedLoggedInText)
            );

        });

        // =========================================================
        // Step 7: Add products to the cart
        // =========================================================

        Allure.step("Add products to the shopping cart", () -> {

            loggedInPage.add_items_to_cart();

        });

        // =========================================================
        // Step 8: Navigate to Cart
        // =========================================================

        CartPage cart = Allure.step(
                "Navigate to the shopping Cart",
                loggedInPage::navigate_to_cart_from_logged_in_page
        );

        // =========================================================
        // Step 9: Verify Cart page
        // =========================================================

        Allure.step("Verify that the Cart page is displayed successfully", () -> {

            String expectedCartUrl =
                    "https://automationexercise.com/view_cart";

            String actualCartUrl =
                    cart.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC16",
                    "Verify_Cart_Page"
            );

            Assert.assertEquals(
                    actualCartUrl,
                    expectedCartUrl
            );

        });

        // =========================================================
        // Step 10: Proceed to Checkout
        // =========================================================

        CheckoutPage checkout = Allure.step(
                "Proceed to Checkout",
                cart::proceedToCheckoutAfterLoginOrSignup
        );

        // =========================================================
        // Step 11: Verify delivery address
        // =========================================================

        Allure.step("Verify the delivery address details", () -> {

            String actualAddress1 =
                    checkout.verify_delivery_address1();

            String expectedAddress1 =
                    data[1].getAddress_1();

            Assert.assertEquals(
                    actualAddress1,
                    expectedAddress1
            );

            String actualAddress2 =
                    checkout.verify_delivery_address2();

            String expectedAddress2 =
                    data[1].getAddress_2();

            helper_Functions.saveScreenshot(
                    "TC16",
                    "Verify_Delivery_Address"
            );

            Assert.assertEquals(
                    actualAddress2,
                    expectedAddress2
            );

        });

        // =========================================================
        // Step 12: Enter order comment and place order
        // =========================================================

        payment_page payment = Allure.step(
                "Enter the order comment and place the order",
                () -> {

                    checkout.write_order_message(
                            "Order to be delivered as soon as possible"
                    );

                    return checkout.place_order();
                }
        );

        // =========================================================
        // Step 13: Enter payment details
        // =========================================================

        Allure.step("Enter the payment card details", () -> {

            payment.Enter_payment_details(cardInfo);

        });

        // =========================================================
        // Step 14: Pay and confirm the order
        // =========================================================

        Allure.step("Pay for the order and confirm the purchase", () -> {

            payment.pay_and_confirm();

        });

        // =========================================================
        // Step 15: Verify successful order placement
        // =========================================================

        Allure.step("Verify that the order has been placed successfully", () -> {

            String expectedSuccessMessage =
                    "Congratulations! Your order has been confirmed!";

            String actualSuccessMessage =
                    payment.verify_congratulate_placed_order_message();

            helper_Functions.saveScreenshot(
                    "TC16",
                    "Verify_Order_Confirmation"
            );

            Assert.assertEquals(
                    actualSuccessMessage,
                    expectedSuccessMessage
            );

        });

        // =========================================================
        // Step 16: Delete the user account
        // =========================================================

        DeleteAccountPage deleteAccount = Allure.step(
                "Delete the user account",
                payment::delete_account
        );

        // =========================================================
        // Step 17: Verify account deletion
        // =========================================================

        Allure.step("Verify that the account has been deleted successfully", () -> {

            String expectedDeleteMessage =
                    "ACCOUNT DELETED!";

            String actualDeleteMessage =
                    deleteAccount.get_success_delete_message();

            helper_Functions.saveScreenshot(
                    "TC16",
                    "Verify_Account_Deleted"
            );

            Assert.assertEquals(
                    actualDeleteMessage,
                    expectedDeleteMessage
            );

        });

        // Continue after account deletion
        Allure.step("Continue after account deletion", () -> {
            deleteAccount.click_continue();
        });

    }

}
