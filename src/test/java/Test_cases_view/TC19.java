package Test_cases_view;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HM_BrandPage;
import pages.Home_page;
import pages.Polo_BrandPage;
import pages.products_page;
import utilities.helper_Functions;


public class TC19 extends BaseTest {

    @Link(
            name = "Automation Exercise - Test Case 19",
            url = "https://automationexercise.com/test_cases"
    )

    @Epic("Automation Exercise Website")
    @Feature("Brand Products")
    @Story("View Products by Brand")

    @Description("""
Verifies that a user can browse products by brand.
The test navigates to the Products page, validates the
visibility of the Brands section, opens the Polo brand,
verifies the displayed products, then switches to the
H&M brand and confirms that its products are displayed
successfully.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.NORMAL)


    @Test(groups = "Smoke Test")
    public void TC19_View_and_Cart_Brand_Products()  {

        Home_page homepage = new Home_page(driver_under_test);

        Allure.step("Navigate to the Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        products_page products = Allure.step(
                "Navigate to the Products page",
                homepage::Go_To_products_page_from_homepage
        );

        Allure.step("Verify that the Brands section is displayed", () -> {

            String expectedText = "BRANDS";
            String actualText = products.verify_brand_text_left_side();

            helper_Functions.saveScreenshot(
                    "TC19",
                    "Brands_Section");

            Assert.assertEquals(actualText, expectedText);

        });

        Polo_BrandPage polo = Allure.step(
                "Open the Polo brand page",
                products::choose_polo_brand
        );

        Allure.step("Verify that the Polo brand page is displayed", () -> {

            String expectedUrl =
                    "https://automationexercise.com/brand_products/Polo";

            String actualUrl =
                    polo.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC19",
                    "Polo_Brand_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        Allure.step("Verify that Polo products are displayed", () -> {

            String expectedText =
                    "BRAND -  Polo PRODUCTS";

            String actualText =
                    polo.verify_brand_product_text();

            helper_Functions.saveScreenshot(
                    "TC19",
                    "Polo PRODUCTS");

            Assert.assertEquals(actualText, expectedText);

        });

        HM_BrandPage hm = Allure.step(
                "Open the H&M brand page",
                polo::choose_HM_brand
        );

        Allure.step("Verify that the H&M brand page is displayed", () -> {

            String expectedUrl =
                    "https://automationexercise.com/brand_products/H&M";

            String actualUrl =
                    hm.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC19",
                    "HM_Brand_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        Allure.step("Verify that H&M products are displayed", () -> {

            String expectedText =
                    "BRAND - H&M PRODUCTS";

            String actualText =
                    hm.verify_brand_product_text();

            helper_Functions.saveScreenshot(
                    "TC19",
                    "HM_Products");

            Assert.assertEquals(actualText, expectedText);

        });

    }

}