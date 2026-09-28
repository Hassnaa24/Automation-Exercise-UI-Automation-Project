package Test_cases_verify_subscription;

import Base.BaseTest;
import Pojo_classes.SubscriptionData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import pages.CartPage;
import utilities.helper_Functions;


public class TC11 extends BaseTest {

    @Link(
            name = "Automation Exercise - Test Case 11",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Subscription")
    @Story("Subscribe from Cart Page")

    @Description("""
Verifies that a user can successfully subscribe to the newsletter
from the Cart page. The test navigates to the Cart page, scrolls
to the footer, validates the visibility of the 'SUBSCRIPTION'
section, submits a valid email address, and confirms that the
subscription is completed successfully.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.NORMAL)

    @Link(
            name = "Automation Exercise - Test Case 11",
            url = "https://automationexercise.com/test_cases"
    )

    @Test(groups = "Smoke Test")
    public void TC11_Verify_Subscription_in_Cart_page() {

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
                    "TC11",
                    "Home_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        CartPage cart = Allure.step(
                "Navigate to the Cart page",
                homepage::Go_To_cart_page_from_homepage
        );

        Allure.step("Scroll to the footer section of the Cart page", () -> {
            cart.scroll_to_footer();
        });

        Allure.step("Verify that the 'SUBSCRIPTION' section is displayed", () -> {

            String expectedText = "SUBSCRIPTION";
            String actualText = cart.verify_subscription_text();

            helper_Functions.saveScreenshot(
                    "TC11",
                    "Subscription_Section");

            Assert.assertTrue(actualText.contains(expectedText));

        });

        Allure.step("Enter a valid email address and submit the subscription request", () -> {

            cart.send_subscription_email_and_click(
                    subscriptionData.getEmail());

        });

        Allure.step("Verify that the subscription is completed successfully", () -> {

            String expectedMessage =
                    "You have been successfully subscribed!";

            String actualMessage =
                    cart.verify_success_subscription_text();

            helper_Functions.saveScreenshot(
                    "TC11",
                    "Subscription_Success");

            Assert.assertTrue(actualMessage.contains(expectedMessage));

        });

    }



}

