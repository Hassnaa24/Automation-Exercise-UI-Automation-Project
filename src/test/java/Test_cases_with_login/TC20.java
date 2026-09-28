package Test_cases_with_login;

import Base.BaseTest;
import Test_cases_search_for_product.SearchForProduct;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.helper_Functions;


public class TC20 extends BaseTest {

    private  Home_page homepage ;

    @Link(
            name = "Automation Exercise - Test Case 20",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Products and Shopping Cart")
    @Story("Search Products and Verify Cart After Login")

    @Description("""
Verifies that products found through the product search can be added
to the shopping cart and remain available after the user logs in.
The test searches for products, adds the matching products to the cart,
verifies their quantities, logs in with an existing user account,
returns to the Cart page, and confirms that the products and their
quantities are preserved after login.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)


    @Test
    public void TC20_Search_Products_and_Verify_Cart_After_Login()  {


        /**
         * Initializes the Home Page object after the WebDriver
         * has been created by BaseTest.
         */
        homepage = new Home_page(driver_under_test);

        // Index of the existing user account used for authentication.
        final int userIndex = 3;

        // =========================================================
        // Steps 1 - 7:
        // Search for the required products and verify the
        // search results.
        // =========================================================

        products_page productsPage = Allure.step(
                "Search for the required products",
                () -> SearchForProduct.SearchProduct(
                        homepage,
                        url_under_test
                )
        );

        // =========================================================
        // Step 8:
        // Add the first and second searched products to the cart.
        // =========================================================

        Allure.step("Add the first searched product to the shopping cart", () -> {

            productsPage.add_item1_in_search_to_cart();

        });

        Allure.step("Continue shopping after adding the first product", () -> {

            productsPage.continue_shopping();

        });

        Allure.step("Add the second searched product to the shopping cart", () -> {

            productsPage.add_item2_in_search_to_cart();

        });

        Allure.step("Continue shopping after adding the second product", () -> {

            productsPage.continue_shopping();

        });

        // =========================================================
        // Step 9:
        // Navigate to the Cart and verify both products.
        // =========================================================

       CartPage cart = Allure.step(
                "Navigate to the Cart page",
                productsPage::Go_To_cart_page_from_productsPage
        );

        CartPage finalCart = cart;
        Allure.step("Verify that both searched products are displayed in the Cart", () -> {

            helper_Functions.saveScreenshot(
                    "TC20",
                    "Products_In_Cart_Before_Login"
            );

            Assert.assertEquals(
                    finalCart.checkItem1InSearchQuantity(),
                    "1"
            );

            Assert.assertEquals(
                    finalCart.checkItem2InSearchQuantity(),
                    "1"
            );

        });

        // =========================================================
        // Step 10:
        // Navigate to Login and authenticate with an existing user.
        // =========================================================

        LoginPage loginPage = Allure.step(
                "Navigate to the Signup / Login page from the Cart",
                cart::goToSignupLoginPageFromCartPage
        );

        HomePageLoggedIn loggedInPage = Allure.step(
                "Log in using the existing user account",
                () -> logIn.sign_in(
                        loginPage,
                        userIndex
                )
        );

        // =========================================================
        // Step 11:
        // Navigate back to the Cart after login.
        // =========================================================

        cart = Allure.step(
                "Navigate back to the Cart after login",
                loggedInPage::navigate_to_cart_from_logged_in_page
        );

        // =========================================================
        // Step 12:
        // Verify that the previously added products remain in the Cart.
        // =========================================================

        CartPage finalCart1 = cart;
        Allure.step(
                "Verify that the searched products remain in the Cart after login",
                () -> {

                    helper_Functions.saveScreenshot(
                            "TC20",
                            "Products_In_Cart_After_Login"
                    );

                    Assert.assertEquals(
                            finalCart1.checkItem1InSearchQuantity(),
                            "1"
                    );

                    Assert.assertEquals(
                            finalCart1.checkItem2InSearchQuantity(),
                            "1"
                    );

                }
        );


    }

}

