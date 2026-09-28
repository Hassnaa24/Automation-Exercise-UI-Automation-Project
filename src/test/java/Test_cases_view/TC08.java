package Test_cases_view;

import Base.BaseTest;
import Pojo_classes.ItemDetailsData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import pages.itemDetailsPage;
import pages.products_page;
import utilities.helper_Functions;

public class TC08 extends BaseTest {

    @Link(
            name = "Automation Exercise - Test Case 08",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Products")
    @Story("View Product Details")

    @Description("""
Verifies that a user can successfully navigate to the All Products page,
open the details page of a selected product, and validate that all product
information including name, category, price, availability, condition,
and brand is displayed correctly.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)


    @Test(groups = "Smoke Test")
    public void TC08_Verify_All_Products_and_product_detail_page() {

        ItemDetailsData productData =
                helper_Functions.read_from_json(
                        "ItemDetails_Info",
                        ItemDetailsData.class);

        Home_page homepage = new Home_page(driver_under_test);

        Allure.step("Navigate to the Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        Allure.step("Verify that the Home page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/";
            String actualUrl = homepage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC08",
                    "Home_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        products_page productsPage = Allure.step(
                "Navigate to the All Products page",
                homepage::Go_To_products_page_from_homepage
        );

        Allure.step("Verify that the All Products page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/products";
            String actualUrl = productsPage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC08",
                    "All_Products_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

//        Allure.step("Verify that the products list is displayed", () -> {
//
//            Assert.assertTrue(productsPage.isProductsListDisplayed());
//
//        });

        itemDetailsPage itemDetails = Allure.step(
                "Open the Product Details page of the first product",
                productsPage::navigate_to_product_details_item_1
        );

        Allure.step("Verify that the Product Details page is displayed", () -> {

            String expectedUrl =
                    "https://automationexercise.com/product_details/1";

            String actualUrl =
                    itemDetails.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC08",
                    "Product_Details_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        Allure.step("Verify the displayed product information", () -> {

            helper_Functions.saveScreenshot(
                    "TC08",
                    "Product_Details");

            Assert.assertEquals(
                    itemDetails.get_item_name(),
                    productData.getName());

            Assert.assertEquals(
                    itemDetails.get_item_category(),
                    productData.getCategory());

            Assert.assertEquals(
                    itemDetails.get_item_price(),
                    productData.getPrice());

            Assert.assertEquals(
                    itemDetails.get_item_availability(),
                    productData.getAvailability());

            Assert.assertEquals(
                    itemDetails.get_item_condition(),
                    productData.getCondition());

            Assert.assertEquals(
                    itemDetails.get_item_brand(),
                    productData.getBrand());

        });


    }

}
//      final  item_details_data tops_product=helper_Functions.read_from_json("item_details_info",item_details_data.class);
//
//        String url_under_test = "https://automationexercise.com";
//        // Step: 1. Launch browser
//        // Step: 2. Navigate to url 'http://automationexercise.com'
//        homepage.Go_to_URL(url_under_test);
//
//        //Step: 3. Verify that home page is visible successfully
//        String expected_url= "https://automationexercise.com/";
//        String actual_url = homepage.get_page_url();
//        helper_Functions.saveScreenshot("TC08","Verify that home page is visible successfully");
//        Assert.assertEquals( actual_url,expected_url);
//
//        // Step: 4. Click on 'Products' button
//        products_page productsPage   =homepage.Go_To_products_page_from_homepage();
//
//        // Step: 5. Verify user is navigated to ALL PRODUCTS page successfully
//        String expected_products_page_url="https://automationexercise.com/products";
//        String actual_products_page_url= productsPage.get_page_url();
//        helper_Functions.saveScreenshot("TC08","Verify user is navigated to ALL PRODUCTS page successfully");
//        //Assert.assertEquals(actual_products_page_url,expected_products_page_url);
//
//        // Step: 6. The products list is visible
//        // Step: 7. Click on 'View Product' of first product
//        itemDetails_page item_1 = productsPage.navigate_to_product_details_item_1();
//
//
//        // Step: 8. User is landed to product detail page
//        String expected_item_1_detailPage_url="https://automationexercise.com/product_details/1";
//        String actual_item_1_detailPage_url= item_1.get_page_url();
//        helper_Functions.saveScreenshot("TC08","Verify User is landed to product detail page");
//        Assert.assertEquals( actual_item_1_detailPage_url,expected_item_1_detailPage_url);
//
//        // Step: 9. Verify that  detail is visible: product name, category, price, availability, condition, brand
//        helper_Functions.saveScreenshot("TC08","Verify that  detail is visible");
//        Assert.assertEquals(item_1.get_item_name(),tops_product.getName());
//        Assert.assertEquals(item_1.get_item_category(),tops_product.getCategory());
//        Assert.assertEquals(item_1.get_item_price(),tops_product.getPrice());
//        Assert.assertEquals(item_1.get_item_availability(),tops_product.getAvailability());
//        Assert.assertEquals(item_1.get_item_condition(),tops_product.getCondition());
//        Assert.assertEquals(item_1.get_item_brand(),tops_product.getBrand());
//