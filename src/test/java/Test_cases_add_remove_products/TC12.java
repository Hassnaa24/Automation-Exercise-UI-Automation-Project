package Test_cases_add_remove_products;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import pages.CartPage;
import pages.products_page;
import utilities.helper_Functions;


public class TC12 extends BaseTest {

    @Link(
            name = "Automation Exercise - Test Case 12",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Shopping Cart")
    @Story("Add Products to Cart")

    @Description("""
            Verifies that a user can successfully add multiple products to the shopping cart.
            The test validates that both products are added correctly and confirms their
            price, quantity, and cart information after navigating to the Cart page.
            """)

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)

    @Test(groups = "Smoke Test")
    public void TC12_Add_Products_in_Cart()  {

        Home_page homepage = new Home_page(driver_under_test);

        Allure.step("Navigate to the Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        Allure.step("Verify that the Home page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/";
            String actualUrl = homepage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC12",
                    "Home_Page");

            Assert.assertEquals(actualUrl, expectedUrl);
        });

        products_page productsPage = Allure.step(
                "Navigate to the Products page",
                homepage::Go_To_products_page_from_homepage
        );

        Allure.step("Add the first product to the shopping cart", () -> {
            productsPage.add_item1_to_cart();
        });

        Allure.step("Continue shopping", () -> {
            productsPage.continue_shopping();
        });

        Allure.step("Add the second product to the shopping cart", () -> {
            productsPage.add_item2_to_cart();
        });

        CartPage cart = Allure.step(
                "Open the Cart page",
                productsPage::view_chart
        );

        Allure.step("Verify that both products are displayed in the shopping cart", () -> {

            helper_Functions.saveScreenshot(
                    "TC12",
                    "Products_Added_To_Cart");

            Assert.assertEquals(cart. checkItem1Price(), "Rs. 500");
            Assert.assertEquals(cart.checkItem2Price(), "Rs. 400");

        });

        Allure.step("Verify the quantity of each product", () -> {

            Assert.assertEquals(cart.checkItem1Quantity(), "1");
            Assert.assertEquals(cart.checkItem2Quantity(), "1");

        });

        Allure.step("Capture the final cart state", () -> {

            helper_Functions.saveScreenshot(
                    "TC12",
                    "Cart_Details");

        });
    }
}