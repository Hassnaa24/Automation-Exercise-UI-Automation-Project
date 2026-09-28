package Test_cases_verify_scroll_up_down;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import utilities.helper_Functions;



public class TC25 extends BaseTest {

    @Link(
            name = "Automation Exercise - Test Case 25",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Home Page Navigation")
    @Story("Verify Scroll Up and Scroll Down Functionality")

    @Description("""
Verifies the scrolling functionality of the home page. The test scrolls
to the bottom of the page, validates that the 'SUBSCRIPTION' section is
visible, clicks the scroll-up arrow, and confirms that the page returns
to the top by verifying the main banner text.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.NORMAL)

    @Link(
            name = "Automation Exercise - Test Case 25",
            url = "https://automationexercise.com/test_cases"
    )


    @Test
    public void TC25_Verify_Scroll_Up_using_Arrow_button_and_Scroll_Down_functionality()  {
        Home_page homepage = new Home_page(driver_under_test);

        Allure.step("Navigate to the Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        Allure.step("Verify that the Home page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/";
            String actualUrl = homepage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC25",
                    "Home_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        Allure.step("Scroll down to the bottom of the Home page", () -> {
            homepage.scroll_to_footer();
        });

        Allure.step("Verify that the 'SUBSCRIPTION' section is visible", () -> {

            String expectedText = "SUBSCRIPTION";
            String actualText = homepage.verify_subscription_text();

            helper_Functions.saveScreenshot(
                    "TC25",
                    "Subscription_Section");

            Assert.assertTrue(actualText.contains(expectedText));

        });

        Allure.step("Click the scroll-up arrow", () -> {
            homepage.up_arrow_click();
        });

        Allure.step("Verify that the page scrolls back to the top successfully", () -> {

            String expectedText =
                    "Full-Fledged practice website for Automation Engineers";

            String actualText =
                    homepage.home_page_text();

            helper_Functions.saveScreenshot(
                    "TC25",
                    "Top_Of_Home_Page");

            Assert.assertEquals(actualText, expectedText);

        });

    }



}

