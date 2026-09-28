package Test_cases_verify_scroll_up_down;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import utilities.helper_Functions;
import java.io.IOException;

public class TC26 extends BaseTest {

    @Link(
            name = "Automation Exercise - Test Case 26",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Home Page Navigation")
    @Story("Verify Scroll Up without Using the Scroll-Up Arrow")

    @Description("""
Verifies the manual scrolling functionality of the Home page.
The test scrolls to the bottom of the page, validates that the
'SUBSCRIPTION' section is visible, scrolls back to the top without
using the scroll-up arrow, and confirms that the main banner text
is displayed successfully.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.NORMAL)


    @Test(groups = "Smoke Test")
    public void TC26_Verify_Scroll_Up_without_Arrow_button_and_Scroll_Down_functionality() throws IOException {

        Home_page homepage = new Home_page(driver_under_test);

        Allure.step("Navigate to the Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        Allure.step("Verify that the Home page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/";
            String actualUrl = homepage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC26",
                    "Home_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        Allure.step("Scroll down to the bottom of the Home page", () -> {
            homepage.scroll_to_footer();
        });

        Allure.step("Verify that the 'SUBSCRIPTION' section is displayed", () -> {

            String expectedText = "SUBSCRIPTION";
            String actualText = homepage.verify_subscription_text();

            helper_Functions.saveScreenshot(
                    "TC26",
                    "Subscription_Section");

            Assert.assertTrue(actualText.contains(expectedText));

        });

        Allure.step("Scroll back to the top of the page without using the scroll-up arrow", () -> {
            homepage.scroll_Up_page();
        });

        Allure.step("Verify that the page returns to the top successfully", () -> {

            String expectedText =
                    "Full-Fledged practice website for Automation Engineers";

            String actualText =
                    homepage.home_page_text();

            helper_Functions.saveScreenshot(
                    "TC26",
                    "Top_Of_Home_Page");

            Assert.assertEquals(actualText, expectedText);

        });
    }

}
