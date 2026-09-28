package Test_cases_add_remove_products;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import pages.CartPage;
import utilities.helper_Functions;



public class TC17 extends BaseTest {

    @Link(
            name = "Automation Exercise - Test Case 17",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Shopping Cart")
    @Story("Remove Products From Cart")

    @Description("""
Verifies that a user can successfully remove products from the shopping cart.
The test validates that products are added to the cart, navigates to the Cart
page, removes the selected product, and confirms that the shopping cart becomes empty.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)

    @Test
    public void TC17_Remove_Products_From_Cart()  {

        Home_page homepage = new Home_page(driver_under_test);

        Allure.step("Navigate to the Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        Allure.step("Verify that the Home page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/";
            String actualUrl = homepage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC17",
                    "Home_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        Allure.step("Add products to the shopping cart", () -> {
            homepage.add_items_to_cart();
        });

        CartPage cart = Allure.step(
                "Navigate to the Cart page",
                homepage::go_to_item_cart
        );

        Allure.step("Verify that the Cart page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/view_cart";
            String actualUrl = cart.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC17",
                    "Cart_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        Allure.step("Remove the product from the shopping cart", () -> {
            cart.removeItemsFromCart();
        });

        Allure.step("Verify that the shopping cart is empty after removing the product", () -> {

            String expectedMessage = "Cart is empty!";
            String actualMessage = cart.getDeleteSuccessMessage();

            helper_Functions.saveScreenshot(
                    "TC17",
                    "Empty_Cart");

            Assert.assertEquals(actualMessage, expectedMessage);

        });
    }


}

