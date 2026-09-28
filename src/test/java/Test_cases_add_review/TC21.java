package Test_cases_add_review;

import Base.BaseTest;
import Pojo_classes.ReviewData;
import io.qameta.allure.*;
import org.testng.Assert;

import org.testng.annotations.Test;
import pages.Home_page;
import pages.itemDetailsPage;
import pages.products_page;
import utilities.helper_Functions;


public class TC21 extends BaseTest {

    @Link(
            name = "Automation Exercise - Test Case 21",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Product Reviews")
    @Story("Submit Product Review")

    @Description("""
Verifies that a user can successfully submit a review for a product.
The test navigates to the Products page, opens the product details page,
validates the visibility of the review section, submits a product review,
and verifies that a successful confirmation message is displayed.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.NORMAL)

    @Test(groups = "Smoke Test")
    public void TC21_Add_review_on_product() {


        ReviewData reviewItem = helper_Functions.read_from_json(
                "Review_Info",
                ReviewData.class);

        Home_page  homepage = new Home_page(driver_under_test);

        Allure.step("Navigate to the Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        products_page products = Allure.step(
                "Navigate to the Products page",
                homepage::Go_To_products_page_from_homepage
        );

        Allure.step("Verify that the All Products page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/products";
            String actualUrl = products.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC21",
                    "Products_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        itemDetailsPage item = Allure.step(
                "Open the Product Details page",
                products::navigate_to_product_details_item_1
        );

        Allure.step("Verify that the 'WRITE YOUR REVIEW' section is displayed", () -> {

            String expectedText = "WRITE YOUR REVIEW";
            String actualText = item.verify_review_text();

            helper_Functions.saveScreenshot(
                    "TC21",
                    "Write_Review_Section");

            Assert.assertEquals(actualText, expectedText);

        });

        Allure.step("Enter review information and submit the review", () -> {

            item.write_review(
                    reviewItem.getName(),
                    reviewItem.getEmail(),
                    reviewItem.getMessage());

        });

        Allure.step("Verify that the review submission was successful", () -> {

            String expectedMessage = "Thank you for your review.";
            String actualMessage = item.verify_success_review_submit();

            helper_Functions.saveScreenshot(
                    "TC21",
                    "Review_Submitted");

            Assert.assertEquals(actualMessage, expectedMessage);

        });
    }

}