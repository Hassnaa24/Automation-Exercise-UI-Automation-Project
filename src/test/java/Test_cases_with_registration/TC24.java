package Test_cases_with_registration;

import Base.BaseTest;
import Pojo_classes.PaymentCardData;
import io.qameta.allure.*;
import org.testng.Assert;

import org.testng.annotations.Test;
import pages.*;
import utilities.helper_Functions;

import static Test_cases_with_registration.create_account.accountInfo;


public class TC24 extends BaseTest {

    private Home_page homepage;

    /**
     * Verifies that a user can successfully place an order and
     * download the generated invoice.
     *
     * The test adds products to the cart, registers a new user during
     * checkout, verifies the delivery address, completes the payment,
     * verifies the successful order confirmation, downloads the invoice,
     * and finally deletes the created account.
     */
    @Link(
            name = "Automation Exercise - Test Case 24",
            url = "https://automationexercise.com/test_cases"
    )

    @Epic("Automation Exercise Website")
    @Feature("Order Management")
    @Story("Download Invoice After Purchase")

    @Description("""
Verifies that a user can successfully complete a purchase and
download the generated invoice after the order has been confirmed.
The test also validates the delivery address, order confirmation,
and account deletion.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)

    @Test
    public void TC24_Download_Invoice_after_purchase_order()  {


        // Index of the user registration data used from the JSON file.
        final int userIndex = 4;

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
                            "TC24",
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
        // Add products to the shopping cart.
        // =========================================================

        Allure.step(
                "Add products to the shopping cart",
                homepage::add_items_to_cart
        );

        // =========================================================
        // Step 5:
        // Navigate to the Cart page.
        // =========================================================

        CartPage cart = Allure.step(
                "Navigate to the Cart page",
                homepage::Go_To_cart_page_from_homepage
        );

        // =========================================================
        // Step 6:
        // Verify that the Cart page is displayed.
        // =========================================================

        CartPage finalCart = cart;
        Allure.step(
                "Verify that the Cart page is displayed successfully",
                () -> {

                    String expectedCartUrl =
                            "https://automationexercise.com/view_cart";

                    String actualCartUrl =
                            finalCart.getPageUrl();

                    helper_Functions.saveScreenshot(
                            "TC24",
                            "Verify_Cart_Page"
                    );

                    Assert.assertEquals(
                            actualCartUrl,
                            expectedCartUrl
                    );
                }
        );

        // =========================================================
        // Step 7:
        // Proceed to Checkout.
        // =========================================================

        Allure.step(
                "Proceed to Checkout",
                cart::proceedToCheckout
        );

        // =========================================================
        // Step 8:
        // Navigate to the Signup / Login page from Checkout.
        // =========================================================

        LoginPage loginPage = Allure.step(
                "Navigate to the Signup / Login page from Checkout",
                cart::loginToProceedToCheckout
        );

        // =========================================================
        // Steps 9 - 11:
        // Register a new user and verify successful registration
        // and authentication using the reusable workflow.
        // =========================================================

        HomePageLoggedIn loggedInPage = Allure.step(
                "Register a new user and complete account creation",
                () -> create_account.sign_up(
                        loginPage,
                        userIndex
                )
        );

        // =========================================================
        // Step 12:
        // Return to the Cart after registration.
        // =========================================================

        cart = Allure.step(
                "Navigate back to the Cart after registration",
                loggedInPage::navigate_to_cart_from_logged_in_page
        );

        // =========================================================
        // Step 13:
        // Proceed to Checkout as the registered user.
        // =========================================================

        CheckoutPage checkout = Allure.step(
                "Proceed to Checkout as the registered user",
                cart::proceedToCheckoutAfterLoginOrSignup
        );

        // =========================================================
        // Step 14:
        // Verify the delivery address.
        // =========================================================

        Allure.step(
                "Verify that the delivery address matches the registered address",
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
                            "TC24",
                            "Verify_Delivery_Address"
                    );

                    Assert.assertEquals(
                            actualAddress2,
                            expectedAddress2
                    );
                }
        );

        // =========================================================
        // Step 15:
        // Enter order comment and place the order.
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
        // Step 16:
        // Enter payment details.
        // =========================================================

        Allure.step(
                "Enter the payment card details",
                () -> payment.Enter_payment_details(cardInfo)
        );

        // =========================================================
        // Step 17:
        // Pay and confirm the order.
        // =========================================================

        Allure.step(
                "Pay for the order and confirm the purchase",
                payment::pay_and_confirm
        );

        // =========================================================
        // Step 18:
        // Verify that the order was placed successfully.
        // =========================================================

        Allure.step(
                "Verify that the order has been placed successfully",
                () -> {

                    String expectedSuccessMessage =
                            "Congratulations! Your order has been confirmed!";

                    String actualSuccessMessage =
                            payment.verify_congratulate_placed_order_message();

                    helper_Functions.saveScreenshot(
                            "TC24",
                            "Verify_Order_Confirmation"
                    );

                    Assert.assertEquals(
                            actualSuccessMessage,
                            expectedSuccessMessage
                    );
                }
        );

        // =========================================================
        // Step 19:
        // Download the invoice and verify the download.
        // =========================================================

        Allure.step(
                "Download the invoice after successful purchase",
                payment::download_invoice
        );

        // =========================================================
        // Step 20:
        // Delete the account created during the test.
        // =========================================================

        DeleteAccountPage deleteAccountPage = Allure.step(
                "Delete the newly created user account",
                payment::delete_account
        );

        // =========================================================
        // Step 21:
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
                            "TC24",
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

//        final int index=4;
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
//        helper_Functions.saveScreenshot("TC24","Verify that home page is visible successfully");
//        Assert.assertEquals(actual_url, expected_url);
//
//        // Step: 4. Add products to cart
//        homepage.add_items_to_cart();
//
//        // Step: 5. Click 'Cart' button
//        cart_page cart = homepage.Go_To_cart_page_from_homepage();
//
//        // Step: 6. Verify that cart page is displayed
//        String expected_cart_page_url="https://automationexercise.com/view_cart";
//        String actual_cart_page_url=cart.get_page_url();
//        helper_Functions.saveScreenshot("TC24","Verify that cart page is displayed");
//        Assert.assertEquals(actual_cart_page_url,expected_cart_page_url);
//
//        // Step: 7. Click Proceed To Checkout
//        cart.proceed_to_checkout();
//
//        // Step: 8. Click 'Register / Login' button
//        login_page login = cart.login_to_proceed_to_checkout();
//
//        // Step: 9. Fill all details in Signup and create account
//        // Step: 10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//        // Step: 11. Verify ' Logged in as username' at top
//        HomePage_logged_in logged_in = create_account.sign_up(login,index);
//
//        // Step: 12.Click 'Cart' button
//        cart = logged_in.navigate_to_cart_from_logged_in_page();
//
//        // Step: 13. Click 'Proceed To Checkout' button
//        checkout_page checkout = cart.proceed_to_checkout_after_login_or_signup();
//
//        // Step: 14. Verify Address Details and Review Your Order
//        String actual_address1 = checkout.verify_delivery_address1();
//        String expected_address1 = account_info[index].getAddress_1();
//        Assert.assertEquals(actual_address1, expected_address1);
//
//        String actual_address2 = checkout.verify_delivery_address2();
//        String expected_address2 = account_info[index].getAddress_2();
//        helper_Functions.saveScreenshot("TC24","Verify Address Details and Review Your Order");
//        Assert.assertEquals(actual_address2, expected_address2);
//
//        // Step: 15. Enter description in comment text area and click 'Place Order'
//        checkout.write_order_message("");
//        payment_page payment = checkout.place_order();
//
//        // Step: 16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//        // Step: 17. Click 'Pay and Confirm Order' button
//        payment.Enter_payment_details(card_info);
//        payment.pay_and_confirm();
//
//        // Step: 18. Verify success message 'Your order has been placed successfully!'
//        // ******************************
//        // String expected_success_order_place = "Your order has been placed successfully!";
//        //String actual_success_order_place = payment.verify_success_order_place_message();
//        //helper_Functions.saveScreenshot("TC24","Verify success message 'Your order has been placed successfully!'");
//        //Assert.assertEquals(actual_success_order_place, expected_success_order_place);
//        // ******************************
//        payment.verify_congratulate_placed_order_message();
//        String expected_success_order_place = "Congratulations! Your order has been confirmed!";
//        String actual_success_order_place   = payment.verify_congratulate_placed_order_message();
//        helper_Functions.saveScreenshot("TC24","Verify success message ");
//        Assert.assertEquals(actual_success_order_place,expected_success_order_place);
//
//
//
//        // Step: 19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
//        payment.download_invoice();
//
//        // Step: 20. Click 'Delete Account' button
//        delete_account_page delete_user = payment.delete_account();
//
//        // Step: 21. Verify 'ACCOUNT DELETED!' and click 'Continue' button
//        String actual_delete_account_text = delete_user.get_success_delete_message();
//        String expected_delete_account_text = "ACCOUNT DELETED!";
//        helper_Functions.saveScreenshot("TC24","Verify 'ACCOUNT DELETED!' and click 'Continue' button");
//        Assert.assertEquals(actual_delete_account_text, expected_delete_account_text);
//
//        delete_user.click_continue();
    }

}
