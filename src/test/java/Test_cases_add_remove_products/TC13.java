package Test_cases_add_remove_products;
import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import pages.CartPage;
import pages.itemDetailsPage;
import utilities.helper_Functions;


public class TC13 extends BaseTest {

    @Link(
            name = "Automation Exercise - Test Case 13",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Shopping Cart")
    @Story("Verify Product Quantity in Cart")

    @Description("""
Verifies that a user can increase the quantity of a product before adding it
to the shopping cart. The test validates successful navigation to the product
details page, updates the quantity, adds the product to the cart, and confirms
that the selected quantity is correctly displayed in the shopping cart.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)

    @Test(groups = "Smoke Test")
    public void TC13_Verify_Product_quantity_in_Cart() {

        Home_page homepage = new Home_page(driver_under_test);

        Allure.step("Navigate to the Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        Allure.step("Verify that the Home page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/";
            String actualUrl = homepage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC13",
                    "Home_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        itemDetailsPage itemPage = Allure.step(
                "Open the Product Details page",
                homepage::go_to_item_details_page
        );

        Allure.step("Verify that the Product Details page is displayed", () -> {

            String expectedUrl =
                    "https://automationexercise.com/product_details/1";

            String actualUrl =
                    itemPage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC13",
                    "Product_Details_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        Allure.step("Increase the product quantity to 4", () -> {

            itemPage.increase_item_quantity("4");

        });

        CartPage cart = Allure.step(
                "Add the product to the cart and open the Cart page",
                itemPage::add_and_view_chart
        );

        Allure.step("Verify that the product quantity in the cart is equal to 4", () -> {

            String expectedQuantity = "4";
            String actualQuantity = cart.checkCartQuantity();

            helper_Functions.saveScreenshot(
                    "TC13",
                    "Cart_Quantity");

            Assert.assertEquals(actualQuantity, expectedQuantity);

        });
    }

}

