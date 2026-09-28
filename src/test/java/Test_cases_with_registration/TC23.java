package Test_cases_with_registration;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.helper_Functions;

import static Test_cases_with_registration.create_account.accountInfo;


public class TC23 extends BaseTest {

    private Home_page homepage;

    /**
     * Verifies that the delivery and billing addresses displayed during
     * checkout match the address information provided during account
     * registration.
     *
     * The test registers a new user, adds products to the cart, proceeds
     * to checkout, validates the saved address information, and finally
     * deletes the created account as test cleanup.
     */
    @Link(
            name = "Automation Exercise - Test Case 23",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Checkout")
    @Story("Verify Address Details During Checkout")

    @Description("""
Verifies that the delivery and billing addresses displayed on the
Checkout page match the address information entered during user
registration. The test registers a new user, adds products to the
cart, proceeds to checkout, validates both address details, and
deletes the account after verification.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)


    @Test
    public void TC23_Verify_address_details_in_checkout_page()  {


        // Index of the user registration data used from the JSON file.
        final int userIndex = 3;

        // Initialize the Home Page object after BaseTest has created
        // the WebDriver instance.
        homepage = new Home_page(driver_under_test);

        // =========================================================
        // Step 1 & 2:
        // Navigate to the Automation Exercise website.
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
                            "TC23",
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
        // Register the user and verify successful authentication.
        // =========================================================

        HomePageLoggedIn loggedInPage = Allure.step(
                "Register a new user and complete account creation",
                () -> create_account.sign_up(
                        loginPage,
                        userIndex
                )
        );

        // =========================================================
        // Step 8:
        // Add products to the shopping cart.
        // =========================================================

        Allure.step(
                "Add products to the shopping cart",
                loggedInPage::add_items_to_cart
        );

        // =========================================================
        // Step 9:
        // Navigate to the Cart page.
        // =========================================================

        CartPage cart = Allure.step(
                "Navigate to the Cart page",
                loggedInPage::navigate_to_cart_from_logged_in_page
        );

        // =========================================================
        // Step 10:
        // Verify that the Cart page is displayed.
        // =========================================================

        Allure.step(
                "Verify that the Cart page is displayed successfully",
                () -> {

                    String expectedCartUrl =
                            "https://automationexercise.com/view_cart";

                    String actualCartUrl =
                            cart.getPageUrl();

                    helper_Functions.saveScreenshot(
                            "TC23",
                            "Verify_Cart_Page"
                    );

                    Assert.assertEquals(
                            actualCartUrl,
                            expectedCartUrl
                    );
                }
        );

        // =========================================================
        // Step 11:
        // Proceed to Checkout.
        // =========================================================

        CheckoutPage checkout = Allure.step(
                "Proceed to Checkout",
                cart::proceedToCheckoutAfterLoginOrSignup
        );

        // =========================================================
        // Step 12 & 13:
        // Verify that the delivery and billing addresses match
        // the information entered during account registration.
        // =========================================================

        Allure.step(
                "Verify that the delivery address matches the registered address",
                () -> {

                    String actualAddress1 =
                            checkout.verify_delivery_address1();

                    String expectedAddress1 =
                            accountInfo[userIndex].getAddress_1();

                    helper_Functions.saveScreenshot(
                            "TC23",
                            "Verify_Delivery_Address"
                    );

                    Assert.assertEquals(
                            actualAddress1,
                            expectedAddress1
                    );

                    String actualAddress2 =
                            checkout.verify_delivery_address2();

                    String expectedAddress2 =
                            accountInfo[userIndex].getAddress_2();

                    helper_Functions.saveScreenshot(
                            "TC23",
                            "Verify_Delivery_Address_2"
                    );

                    Assert.assertEquals(
                            actualAddress2,
                            expectedAddress2
                    );
                }
        );

        // =========================================================
        // Step 14:
        // Delete the user account after completing the verification.
        // =========================================================

        DeleteAccountPage deleteAccountPage = Allure.step(
                "Delete the registered user account",
                checkout::deleteUser
        );

        // =========================================================
        // Step 15:
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
                            "TC23",
                            "Verify_Account_Deleted"
                    );

                    Assert.assertEquals(
                            actualDeleteMessage,
                            expectedDeleteMessage
                    );
                }
        );

        // Continue after account deletion.
        Allure.step(
                "Continue to the Home page after account deletion",
                deleteAccountPage::click_continue
        );
//        final int index=3;
//        final PaymentCardData card_info = helper_Functions.read_from_json("payment_info", PaymentCardData.class);
//
//        String url_under_test = "https://automationexercise.com";
//        // Step: 1. Launch browser
//        // Step: 2. Navigate to url 'http://automationexercise.com'
//        homepage.Go_to_URL(url_under_test);
//
//        //Step: 3. Verify that home page is visible successfully
//        String expected_url = "https://automationexercise.com/";
//        String actual_url = homepage.get_page_url();
//        helper_Functions.saveScreenshot("TC23","Verify that home page is visible successfully");
//        Assert.assertEquals(actual_url, expected_url);
//
//        // Step: 4. Click 'Signup / Login' button
//        login_page login = homepage.Go_To_signup_login_page();
//
//        // Step: 5. Fill all details in Signup and create account
//        // Step: 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//        // Step: 7. Verify 'Logged in as username' at top
//        HomePage_logged_in loggedIn = create_account.sign_up(login,index);
//
//        // Step: 8.Add products to cart
//        loggedIn.add_items_to_cart();
//
//        // Step: 9.Click 'Cart' button
//        cart_page cart= loggedIn.navigate_to_cart_from_logged_in_page();
//
//        // Step: 10. Verify that cart page is displayed
//        String expected_cart_page_url="https://automationexercise.com/view_cart";
//        String actual_cart_page_url=cart.get_page_url();
//        helper_Functions.saveScreenshot("TC23","Verify that cart page is displayed");
//        Assert.assertEquals(actual_cart_page_url,expected_cart_page_url);
//
//        // Step: 11. Click Proceed To Checkout
//        checkout_page checkout = cart.proceed_to_checkout_after_login_or_signup();
//
//        // Step: 12. Verify that the delivery address is same address filled at the time registration of account
//        // Step: 13. Verify that the billing address is same address filled at the time registration of account
//        String actual_address1=  checkout.verify_delivery_address1();
//        String expected_address1=account_info[index].getAddress_1();
//        helper_Functions.saveScreenshot("TC23","Verify that the delivery address is same address filled at the time registration of account");
//        Assert.assertEquals(actual_address1,expected_address1);
//
//        String actual_address2=  checkout.verify_delivery_address2();
//        String expected_address2= account_info[index].getAddress_2();
//        helper_Functions.saveScreenshot("TC23","Verify that the delivery address is same address filled at the time registration of account");
//        Assert.assertEquals(actual_address2,expected_address2);
//
//        // Step: 14. Click 'Delete Account' button
//        delete_account_page delete_user= checkout.deleteUser();
//
//        // Step: 15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
//        String actual_delete_account_text= delete_user.get_success_delete_message();
//        String expected_delete_account_text="ACCOUNT DELETED!";
//        helper_Functions.saveScreenshot("TC23"," Verify 'ACCOUNT DELETED!' and click 'Continue' button");
//        Assert.assertEquals(actual_delete_account_text, expected_delete_account_text);
//
//        delete_user.click_continue();
    }
}