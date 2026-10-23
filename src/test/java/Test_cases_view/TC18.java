package Test_cases_view;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import pages.CategoryMenTshirtPage;
import pages.CategoryWomenDressPage;
import utilities.helper_Functions;



public class TC18 extends BaseTest {

    @Link(
            name = "Automation Exercise - Test Case 18",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Category Products")
    @Story("View Products by Category")

    @Description("""
Verifies that a user can browse products by category.
The test validates the visibility of the Categories section,
navigates to the Women's Dress category, verifies the displayed
category page and heading, then switches to the Men's T-Shirts
category and confirms that the corresponding category page is
displayed successfully.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.NORMAL)

    @Test
    public void TC18_View_Category_Products(){

        Home_page homepage = new Home_page(driver_under_test);

        Allure.step("Navigate to the Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        Allure.step("Verify that the Categories section is displayed", () -> {

            String expectedText = "CATEGORY";
            String actualText = homepage.verify_category_text();

            helper_Functions.saveScreenshot(
                    "TC18",
                    "Categories_Section");

            Assert.assertEquals(actualText, expectedText);

        });

        Allure.step("Expand the Women category", () -> {
            homepage.choose_women_category();
        });

        CategoryWomenDressPage womenDress = Allure.step(
                "Open the Women's Dress category",
                homepage::choose_women_dress_category
        );

        Allure.step("Verify that the Women's Dress category page is displayed", () -> {

            String expectedUrl =
                    "WOMEN -  Dress PRODUCTS";

            String actualUrl =
                    womenDress.verify_women_products_text();

            helper_Functions.saveScreenshot(
                    "TC18",
                    "Women_Dress_Category");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        Allure.step("Verify the Women's category heading", () -> {

            String expectedHeading = "WOMEN -  Dress PRODUCTS";
            String actualHeading = womenDress.verify_women_products_text();

            helper_Functions.saveScreenshot(
                    "TC18",
                    "Women_Category_Header");

            Assert.assertEquals(actualHeading, expectedHeading);

        });

        Allure.step("Expand the Men category", () -> {
            womenDress.choose_men_category();
        });

        CategoryMenTshirtPage menTshirt = Allure.step(
                "Open the Men's T-Shirts category",
                womenDress::choose_men_Tshirt_category
        );

        Allure.step("Verify that the Men's T-Shirts category page is displayed", () -> {

            String expectedUrl =
                    " Men -  Tshirts PRODUCTS";

            String actualUrl =
                    menTshirt.verify_men_products_text();

            helper_Functions.saveScreenshot(
                    "TC18",
                    "Men_TShirt_Category");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

    }

}
