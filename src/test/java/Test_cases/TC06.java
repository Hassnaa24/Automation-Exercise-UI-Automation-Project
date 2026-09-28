package Test_cases;

import Base.BaseTest;
import Pojo_classes.ContactUsData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home_page;
import pages.ContactUsPage;
import utilities.helper_Functions;

import java.io.IOException;


public class TC06 extends BaseTest {

    protected final ContactUsData contactus_info = helper_Functions.read_from_json("ContactUs_Info", ContactUsData.class);

    @Link(
            name = "Automation Exercise - Test Case 06",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Contact Us")
    @Story("Submit Contact Us Form Successfully")

    @Description("""
Verifies that a registered user can successfully submit the Contact Us form.
The test validates page navigation, form submission, success confirmation,
and navigation back to the home page.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.CRITICAL)


    @Test(groups = "Smoke Test")
    public void  TC06_Contact_Us_Form() throws IOException {
        Home_page homepage = new Home_page(driver_under_test);

        Allure.step("Navigate to Automation Exercise home page", () -> {
            homepage.goToUrl(url_under_test);
        });

        Allure.step("Open the Contact Us page", () -> {
            ContactUsPage contact_us = homepage.Go_To_contactus_page_from_homepage();
        });

        ContactUsPage contact_us = homepage.Go_To_contactus_page_from_homepage();

        Allure.step("Verify 'GET IN TOUCH' page title", () -> {

            String expected = "GET IN TOUCH";
            String actual = contact_us.get_page_message();

            helper_Functions.saveScreenshot(
                    "TC06",
                    "GET_IN_TOUCH_Page");

            Assert.assertEquals(actual, expected);
        });

        Allure.step("Enter contact information", () -> {

            contact_us.enter_name(contactus_info.getName());
            contact_us.enter_email(contactus_info.getEmail());
            contact_us.enter_subject(contactus_info.getSubject());
            contact_us.enter_message(contactus_info.getMessage());

        });

        Allure.step("Submit Contact Us form", () -> {

            contact_us.submit();

        });

        Allure.step("Accept confirmation alert", () -> {

            contact_us.OK_message_click();

        });

        Allure.step("Verify successful form submission", () -> {

            String expected =
                    "Success! Your details have been submitted successfully.";

            String actual =
                    contact_us.success_submit_message();

            helper_Functions.saveScreenshot(
                    "TC06",
                    "Contact_Form_Submitted");

            Assert.assertEquals(actual, expected);

        });

        Allure.step("Return to Home page and verify URL", () -> {

            String expected =
                    "https://automationexercise.com/";

            String actual =
                    contact_us
                            .Back_home_page_from_contactus_page()
                            .getPageUrl();

            helper_Functions.saveScreenshot(
                    "TC06",
                    "Home_Page");

            Assert.assertEquals(actual, expected);

        });

    }


}









//          Home_page homepage = new Home_page(driver_under_test);
//
//        // Step: 1. Launch browser
//        // Step: 2. Navigate to url 'http://automationexercise.com'
//        homepage.Go_to_URL(url_under_test);
//
//        // Step: 4. Click on 'Contact Us' button
//        contact_us_page contact_us = homepage.Go_To_contactus_page_from_homepage();
//
//        // Step: 5. Verify 'GET IN TOUCH' is visible
//        String actual_page_message= contact_us.get_page_message();
//        String expected_page_message="GET IN TOUCH";
//        helper_Functions.saveScreenshot("TC06"," Verify 'GET IN TOUCH' is visible");
//        Assert.assertEquals(actual_page_message,expected_page_message);
//
//        // Step: 6. Enter name, email, subject and message
//        contact_us.enter_name(contactus_info.getName());
//        contact_us.enter_email(contactus_info.getEmail());
//        contact_us.enter_subject(contactus_info.getSubject());
//        contact_us.enter_message(contactus_info.getMessage());
//
//        // Step: 7. Upload file
//       // contact_us.upload_file("C:\\Users\\pc\\OneDrive\\Desktop\\upload_file.txt");
//
//        // Step: 8. Click 'Submit' button
//        contact_us.submit();
//
//        // Step: 9. Click OK button
//        contact_us.OK_message_click();
//
//        // Step: 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
//        String expected_success_submit_message="Success! Your details have been submitted successfully.";
//        String actual_success_submit_message= contact_us.success_submit_message();
//        helper_Functions.saveScreenshot("TC06","Verify success message 'Success! Your details have been submitted successfully.' is visible");
//        Assert.assertEquals(actual_success_submit_message,expected_success_submit_message);
//
//        // Step: 11. Click 'Home' button and verify that landed to home page successfully
//        String expected_back_home_url ="https://automationexercise.com/";
//        String actual_back_home_url =(contact_us.Back_home_page_from_contactus_page()).get_page_url();
//        helper_Functions.saveScreenshot("TC06","verify that landed to home page successfully");
//        Assert.assertEquals(actual_back_home_url,expected_back_home_url);