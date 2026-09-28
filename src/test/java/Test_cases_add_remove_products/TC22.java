package Test_cases_add_remove_products;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import pages.CartPage;
import utilities.helper_Functions;


public class TC22 extends BaseTest {


    @Link(
            name = "Automation Exercise - Test Case 22",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Shopping Cart")
    @Story("Add Product from Recommended Items")

    @Description("""
Verifies that a user can successfully add a product from the
'Recommended Items' section to the shopping cart. The test scrolls
to the bottom of the home page, validates the visibility of the
recommended products section, adds a recommended product to the cart,
and confirms that the product is displayed in the shopping cart.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.NORMAL)


    @Test(groups = "Smoke Test")
    public void TC22_Add_to_cart_from_Recommended_items() {

        Home_page homepage = new Home_page(driver_under_test);

        Allure.step("Navigate to the Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        Allure.step("Scroll to the Recommended Items section", () -> {
            homepage.scroll_to_recommended_item();
        });

        Allure.step("Verify that the 'RECOMMENDED ITEMS' section is displayed", () -> {

            String expectedText = "RECOMMENDED ITEMS";
            String actualText = homepage.verify_recommended_item_text();

            helper_Functions.saveScreenshot(
                    "TC22",
                    "Recommended_Items_Section");

            Assert.assertEquals(actualText, expectedText);

        });

        CartPage cart = Allure.step(
                "Add a recommended product to the shopping cart and open the Cart page",
                homepage::go_to_recommended_item_to_cart
        );

        Allure.step("Verify that the selected product is displayed in the shopping cart", () -> {

            String expectedItem = "Item";
            String actualItem = cart.verifyItemInCart();

            helper_Functions.saveScreenshot(
                    "TC22",
                    "Recommended_Product_In_Cart");

            Assert.assertEquals(actualItem, expectedItem);

        });
    }

}

