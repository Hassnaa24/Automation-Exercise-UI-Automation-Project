package Test_cases_with_registration;
import Base.BaseTest;
import Pojo_classes.PaymentCardData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.helper_Functions;

import static Test_cases_with_registration.create_account.accountInfo;

public class TC15 extends BaseTest {

    private Home_page homepage ;

    /**
     * Verifies that a new user can register before checkout and
     * successfully place an order.
     *
     * The test registers a new user, verifies successful authentication,
     * adds products to the cart, proceeds to checkout, validates the
     * delivery address, completes payment, verifies the order confirmation,
     * and finally deletes the created account as test cleanup.
     */
    @Link(
            name = "Automation Exercise - Test Case 15",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Checkout and Order Management")
    @Story("Place Order After Registering Before Checkout")

    @Description("""
Verifies that a new user can register before adding products to the cart
and successfully complete an order. The test validates registration,
authentication, cart contents, delivery address, payment, order
confirmation, and account deletion.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)

    @Test
    public void TC15_Place_Order_Register_before_Checkout()  {

        // Index of the user registration data used from the JSON file.
        final int userIndex = 2;

        // Load payment card information from the external JSON test-data file.
        final PaymentCardData cardInfo =
                helper_Functions.read_from_json(
                        "payment_info",
                        PaymentCardData.class
                );

        // Initialize the Home Page object after BaseTest creates
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
                            "TC15",
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
        // Register the new user using the reusable account
        // creation workflow.
        // =========================================================

        HomePageLoggedIn loggedInPage = Allure.step(
                "Register a new user and complete the account creation process",
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
                            "TC15",
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
        // Step 12:
        // Verify the delivery address details.
        // =========================================================

        Allure.step(
                "Verify the delivery address details",
                () -> {

                    String actualAddress1 =
                            checkout.verify_delivery_address1();

                    String expectedAddress1 =
                            accountInfo[userIndex].getAddress_1();

                    Assert.assertEquals(
                            actualAddress1,
                            expectedAddress1
                    );

                    String actualAddress2 =
                            checkout.verify_delivery_address2();

                    String expectedAddress2 =
                            accountInfo[userIndex].getAddress_2();

                    helper_Functions.saveScreenshot(
                            "TC15",
                            "Verify_Delivery_Address"
                    );

                    Assert.assertEquals(
                            actualAddress2,
                            expectedAddress2
                    );
                }
        );

        // =========================================================
        // Step 13:
        // Enter the order comment and place the order.
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
        // Step 14:
        // Enter payment details.
        // =========================================================

        Allure.step(
                "Enter the payment card details",
                () -> payment.Enter_payment_details(cardInfo)
        );

        // =========================================================
        // Step 15:
        // Pay and confirm the order.
        // =========================================================

        Allure.step(
                "Pay for the order and confirm the purchase",
                payment::pay_and_confirm
        );

        // =========================================================
        // Step 16:
        // Verify successful order placement.
        // =========================================================

        Allure.step(
                "Verify that the order has been placed successfully",
                () -> {

                    String expectedSuccessMessage =
                            "Congratulations! Your order has been confirmed!";

                    String actualSuccessMessage =
                            payment.verify_congratulate_placed_order_message();

                    helper_Functions.saveScreenshot(
                            "TC15",
                            "Verify_Order_Confirmation"
                    );

                    Assert.assertEquals(
                            actualSuccessMessage,
                            expectedSuccessMessage
                    );
                }
        );

        // =========================================================
        // Step 17:
        // Delete the account created during the test.
        // =========================================================

        DeleteAccountPage deleteAccountPage = Allure.step(
                "Delete the newly created user account",
                payment::delete_account
        );

        // =========================================================
        // Step 18:
        // Verify successful account deletion.
        // =========================================================

        Allure.step(
                "Verify that the account has been deleted successfully",
                () -> {

                    String expectedDeleteMessage =
                            "ACCOUNT DELETED!";

                    String actualDeleteMessage =
                            deleteAccountPage.get_success_delete_message();

                    helper_Functions.saveScreenshot(
                            "TC15",
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

//        final int index=2;
//        final PaymentCardData card_info= helper_Functions.read_from_json("payment_info", PaymentCardData.class);
//
//        String url_under_test = "https://automationexercise.com";
//        // Step: 1. Launch browser
//        // Step: 2. Navigate to url 'http://automationexercise.com'
//        homepage.Go_to_URL(url_under_test);
//
//        //Step: 3. Verify that home page is visible successfully
//        String expected_url = "https://automationexercise.com/";
//        String actual_url = homepage.get_page_url();
//        helper_Functions.saveScreenshot("TC15","Verify that home page is visible successfully");
//        Assert.assertEquals(actual_url, expected_url);
//
//        // Step: 4. Click 'Register / Login' button
//        login_page login= homepage.Go_To_signup_login_page();
//
//        // Step: 5. Fill all details in Signup and create account
//        // Step: 6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//        // Step: 7. Verify 'Logged in as username' at top
//        HomePage_logged_in loggedIn= create_account.sign_up(login, index);
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
//        helper_Functions.saveScreenshot("TC15","Verify that cart page is displayed");
//        Assert.assertEquals(actual_cart_page_url,expected_cart_page_url);
//
//        // Step: 11. Click Proceed To Checkout
//        checkout_page checkout = cart.proceed_to_checkout_after_login_or_signup();
//
//        // Step: 12. Verify Address Details and Review Your Order
//        String actual_address1=  checkout.verify_delivery_address1();
//        String expected_address1=account_info[index].getAddress_1();
//        Assert.assertEquals(actual_address1,expected_address1);
//
//        String actual_address2=  checkout.verify_delivery_address2();
//        String expected_address2=account_info[index].getAddress_2();
//        helper_Functions.saveScreenshot("TC15","Verify Address Details and Review Your Order");
//        Assert.assertEquals(actual_address2,expected_address2);
//
//        // Step: 13. Enter description in comment text area and click 'Place Order'
//        checkout.write_order_message("order to be delivered as soon as possible");
//        payment_page payment= checkout.place_order();
//
//        // Step: 14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//        payment.Enter_payment_details(card_info);
//
//        // Step: 15. Click 'Pay and Confirm Order' button
//        payment.pay_and_confirm();
//
//        // Step: 16. Verify success message 'Your order has been placed successfully!'
//        // ******************************
//        //String expected_success_order_place = "Your order has been placed successfully!";
//       // helper_Functions.saveScreenshot("TC15","Verify success message 'Your order has been placed successfully!'");
//        //String actual_success_order_place   = payment.verify_success_order_place_message();
//        //Assert.assertEquals(actual_success_order_place,expected_success_order_place);
//        // ******************************
//        payment.verify_congratulate_placed_order_message();
//        String expected_success_order_place = "Congratulations! Your order has been confirmed!";
//        String actual_success_order_place   = payment.verify_congratulate_placed_order_message();
//        helper_Functions.saveScreenshot("TC15","Verify success message ");
//        Assert.assertEquals(actual_success_order_place,expected_success_order_place);
//
//        // Step: 17. Click 'Delete Account' button
//        delete_account_page delete_user= payment.delete_account();
//
//        // Step: 18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
//        String actual_delete_account_text= delete_user.get_success_delete_message();
//        String expected_delete_account_text="ACCOUNT DELETED!";
//        helper_Functions.saveScreenshot("TC15","Verify 'ACCOUNT DELETED!' and click 'Continue' button");
//        Assert.assertEquals(actual_delete_account_text, expected_delete_account_text);
//
//        delete_user.click_continue();

    }

}

