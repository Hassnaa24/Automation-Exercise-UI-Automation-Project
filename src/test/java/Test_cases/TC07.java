package Test_cases;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import pages.TestCases_page;
import utilities.helper_Functions;

public class TC07 extends BaseTest {
    @Link(
            name = "Automation Exercise - Test Case 07",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Test Cases")
    @Story("Navigate to Test Cases Page")

    @Description("""
Verifies that the user can successfully navigate from the Home page
to the Test Cases page. The test validates the visibility of the
Home page, navigates using the 'Test Cases' menu, and confirms that
the correct page is displayed.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.MINOR)
    @Test
    public void TC07_Verify_Test_Cases_Page()  {

        Home_page homepage = new Home_page(driver_under_test);

        Allure.step("Navigate to Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        Allure.step("Verify that the Home page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/";
            String actualUrl = homepage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC07",
                    "Home_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });

        TestCases_page testcasePage = Allure.step(
                "Navigate to the Test Cases page",
                homepage::Go_To_testcase_page
        );

        Allure.step("Verify that the Test Cases page is displayed successfully", () -> {

            String expectedUrl = "https://automationexercise.com/test_cases";
            String actualUrl = testcasePage.getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC07",
                    "Test_Cases_Page");

            Assert.assertEquals(actualUrl, expectedUrl);

        });













//        // Step: 1. Launch browser
//        // Step: 2. Navigate to url 'http://automationexercise.com'
//        homepage.Go_to_URL(url_under_test);
//
//        //Step: 3. Verify that home page is visible successfully
//        String expected_url= "https://automationexercise.com/";
//        String actual_url = homepage.get_page_url();
//        helper_Functions.saveScreenshot("TC07","Verify that home page is visible successfully");
//        Assert.assertEquals( actual_url,expected_url);
//
//        // Step: 4. Click on 'Test Cases' button
//        TestCases_page testcasePage = homepage.Go_To_testcase_page();
//
//        //Step: 5. Verify user is navigated to test cases page successfully
//        String expected_testcases_page_url= "https://automationexercise.com/test_cases";
//        String actual_testcases_page_url = testcasePage.get_page_url() ;
//        helper_Functions.saveScreenshot("TC07","Verify user is navigated to test cases page successfully");
//        Assert.assertEquals( actual_testcases_page_url,expected_testcases_page_url);

    }

}
