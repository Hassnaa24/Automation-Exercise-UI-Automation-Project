package Test_cases_with_registration;

import Base.BaseTest;
import Pojo_classes.PaymentCardData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.helper_Functions;

import static Test_cases_with_registration.create_account.accountInfo;


public class TC14 extends BaseTest {

    private Home_page homepage ;

    /**
     * Verifies that a new user can register during checkout and
     * successfully place an order.
     *
     * The test adds products to the cart as a guest user, proceeds
     * to checkout, registers a new account when prompted, verifies
     * the user's delivery address, completes the payment process,
     * validates successful order placement, and finally deletes
     * the created account as test cleanup.
     */
    @Link(
            name = "Automation Exercise - Test Case 14",
            url = "https://automationexercise.com/test_cases"
    )

    @Epic("Automation Exercise Website")
    @Feature("Checkout and Order Management")
    @Story("Place Order by Registering During Checkout")

    @Description("""
Verifies that a guest user can add products to the cart, proceed
to checkout, register a new account when requested, and successfully
complete an order. The test validates the delivery address, payment,
order confirmation, and account deletion.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)


    @Test
    public void TC14_Place_Order_Register_while_Checkout() {

        // Index of the registration data used from the JSON test-data file.
        final int userIndex = 1;

        // Load payment card information from the external JSON file.
        final PaymentCardData cardInfo =
                helper_Functions.read_from_json(
                        "payment_info",
                        PaymentCardData.class
                );

        // Initialize the Home Page object after BaseTest has
        // created the WebDriver instance.
        homepage = new Home_page(driver_under_test);

        // =========================================================
        // Step 1 & 2:
        // Launch browser and navigate to the application.
        // =========================================================

        Allure.step(
                "Navigate to the Automation Exercise Home page",
                () -> homepage.goToUrl(url_under_test)
        );

        // =========================================================
        // Step 3:
        // Verify that the Home page is displayed.
        // =========================================================

        Allure.step(
                "Verify that the Home page is displayed successfully",
                () -> {

                    String expectedUrl =
                            "https://automationexercise.com/";

                    String actualUrl =
                            homepage.getPageUrl();

                    helper_Functions.saveScreenshot(
                            "TC14",
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
        // Verify that the expected products are in the Cart.
        // =========================================================

        CartPage finalCart = cart;
        Allure.step(
                "Verify that the selected products are displayed in the Cart",
                () -> {

                    helper_Functions.saveScreenshot(
                            "TC14",
                            "Verify_Products_In_Cart"
                    );

                    Assert.assertEquals(
                            finalCart.checkItem1Quantity(),
                            "1"
                    );

                    Assert.assertEquals(
                            finalCart.checkItem2Quantity(),
                            "1"
                    );
                }
        );

        // =========================================================
        // Step 7:
        // Proceed to checkout.
        // =========================================================

        Allure.step(
                "Proceed to Checkout",
                cart::proceedToCheckout
        );

        // =========================================================
        // Step 8:
        // Navigate to the Signup / Login page when checkout
        // requires user authentication.
        // =========================================================

        LoginPage loginPage = Allure.step(
                "Navigate to the Signup / Login page from Checkout",
                cart::loginToProceedToCheckout
        );

        // =========================================================
        // Steps 9 - 11:
        // Register a new user using the reusable account-creation
        // workflow and verify successful authentication.
        // =========================================================

        HomePageLoggedIn loggedInPage = Allure.step(
                "Register a new user and complete the account creation process",
                () -> create_account.sign_up(
                        loginPage,
                        userIndex
                )
        );

        // =========================================================
        // Step 12:
        // Return to the Cart after successful registration.
        // =========================================================

        cart = Allure.step(
                "Navigate back to the Cart after registration",
                loggedInPage::navigate_to_cart_from_logged_in_page
        );

        // =========================================================
        // Step 13:
        // Proceed to Checkout as the newly registered user.
        // =========================================================

        CheckoutPage checkout = Allure.step(
                "Proceed to Checkout as the registered user",
                cart::proceedToCheckoutAfterLoginOrSignup
        );

        // =========================================================
        // Step 14:
        // Verify delivery address and order review information.
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
                            "TC14",
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
        // Enter payment information.
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
                            "TC14",
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
        // Delete the account created during the test.
        // =========================================================

        DeleteAccountPage deleteAccountPage = Allure.step(
                "Delete the newly created user account",
                payment::delete_account
        );

        // =========================================================
        // Step 20:
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
                            "TC14",
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
                "Continue after account deletion",
                deleteAccountPage::click_continue
        );



//         final int index=1;
//         final PaymentCardData card_info= helper_Functions.read_from_json("payment_info", PaymentCardData.class);
//
//
//        // Step: 1. Launch browser
//        // Step: 2. Navigate to url 'http://automationexercise.com'
//        homepage.Go_to_URL(url_under_test);
//
//        //Step: 3. Verify that home page is visible successfully
//        String expected_url = "https://automationexercise.com/";
//        String actual_url = homepage.get_page_url();
//        helper_Functions.saveScreenshot("TC14","Verify that home page is visible successfully");
//        Assert.assertEquals(actual_url, expected_url);
//
//        // Step: 4. Add products to cart
//        homepage.add_items_to_cart();
//
//        // Step: 5. Click 'Cart' button
//        cart_page cart = homepage.Go_To_cart_page_from_homepage();
//
//        // Step: 6. Verify that cart page is displayed
//        helper_Functions.saveScreenshot("TC14","Verify that cart page is displayed");
//        Assert.assertEquals(cart.check_item_1_quantity(),"1");
//        Assert.assertEquals(cart.check_item_2_quantity(),"1");
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
//        cart= logged_in.navigate_to_cart_from_logged_in_page();
//
//        // Step: 13. Click 'Proceed To Checkout' button
//        checkout_page checkout = cart.proceed_to_checkout_after_login_or_signup();
//
//        // Step: 14. Verify Address Details and Review Your Order
//        String actual_address1=  checkout.verify_delivery_address1();
//        String expected_address1=account_info[index].getAddress_1();
//        Assert.assertEquals(actual_address1,expected_address1);
//
//        String actual_address2=  checkout.verify_delivery_address2();
//        String expected_address2=account_info[index].getAddress_2();
//        helper_Functions.saveScreenshot("TC14","Verify Address Details and Review Your Order");
//        Assert.assertEquals(actual_address2,expected_address2);
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
//        //String expected_success_order_place = "Your order has been placed successfully!";
//        //helper_Functions.saveScreenshot("TC14","Verify success message 'Your order has been placed successfully!'");
//        //String actual_success_order_place   = payment.verify_success_order_place_message();
//        // Assert.assertEquals(actual_success_order_place,expected_success_order_place);
//        // ******************************
//        payment.verify_congratulate_placed_order_message();
//        String expected_success_order_place = "Congratulations! Your order has been confirmed!";
//        String actual_success_order_place   = payment.verify_congratulate_placed_order_message();
//        helper_Functions.saveScreenshot("TC14","Verify success message ");
//        Assert.assertEquals(actual_success_order_place,expected_success_order_place);
//
//
//        // Step: 19. Click 'Delete Account' button
//        delete_account_page delete_user = payment.delete_account();
//
//        // Step: 20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
//        String actual_delete_account_text= delete_user.get_success_delete_message();
//        String expected_delete_account_text="ACCOUNT DELETED!";
//        helper_Functions.saveScreenshot("TC14","Verify 'ACCOUNT DELETED!' and click 'Continue' button");
//        Assert.assertEquals(actual_delete_account_text, expected_delete_account_text);
//
//        delete_user.click_continue();

    }

}
