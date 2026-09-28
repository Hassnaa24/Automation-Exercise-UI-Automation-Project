package Test_cases_verify_subscription;

import Base.BaseTest;
import Pojo_classes.SubscriptionData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import utilities.helper_Functions;

public class TC10 extends BaseTest {

    @Link(
            name = "Automation Exercise - Test Case 10",
            url = "https://automationexercise.com/test_cases"
    )

    @Epic("Automation Exercise Website")
    @Feature("Subscription")
    @Story("Subscribe from Home Page")

    @Description("""
Verifies that a user can successfully subscribe to the newsletter
from the Home page. The test scrolls to the footer, validates the
visibility of the 'SUBSCRIPTION' section, submits a valid email
address, and confirms that the subscription is completed successfully.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.NORMAL)

    @Test
    public void TC10_Verify_Subscription_in_home_page()  {


        Home_page homepage = new Home_page(driver_under_test);

        SubscriptionData subscriptionData =
                helper_Functions.read_from_json(
                        "Subscription_Info",
                        SubscriptionData.class);


        Allure.step("Navigate to the Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        Allure.step("Verify that the Home page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/";
            String actualUrl = homepage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC10",
                    "Home_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        Allure.step("Scroll to the footer section", () -> {
            homepage.scroll_to_footer();
        });

        Allure.step("Verify that the 'SUBSCRIPTION' section is displayed", () -> {

            String expectedText = "SUBSCRIPTION";
            String actualText = homepage.verify_subscription_text();

            helper_Functions.saveScreenshot(
                    "TC10",
                    "Subscription_Section");

            Assert.assertTrue(actualText.contains(expectedText));

        });

        Allure.step("Enter a valid email address and submit the subscription request", () -> {

            homepage.send_subscription_email_and_click(subscriptionData.getEmail());

        });

        Allure.step("Verify that the subscription is completed successfully", () -> {

            String expectedMessage =
                    "You have been successfully subscribed!";

            String actualMessage =
                    homepage.verify_success_subscription_text();

            helper_Functions.saveScreenshot(
                    "TC10",
                    "Subscription_Success");

            Assert.assertTrue(actualMessage.contains(expectedMessage));

        });
    }




}
