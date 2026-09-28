package Test_cases_with_registration;
import Pojo_classes.AccountCreationData;
import io.qameta.allure.Allure;
import org.testng.Assert;
import pages.HomePageLoggedIn;
import pages.Signup_page;
import pages.AccountCreatedPage;
import pages.LoginPage;
import utilities.helper_Functions;

/**
 * Provides a reusable workflow for creating a new user account.
 *
 * This class handles the complete registration process, including:
 * - Verifying the Signup section.
 * - Entering the user's name and email address.
 * - Filling in account and personal information.
 * - Creating the account.
 * - Verifying successful account creation.
 * - Confirming that the user is logged in.
 *
 * The registration data is loaded from the external JSON test-data file.
 */
    public class create_account {

    /**
     * Creates a new user account using the specified test-data record.
     *
     * @param loginPage The Login page object used to start registration.
     * @param userIndex The index of the user data in the JSON test-data array.
     * @return HomePage_logged_in representing the Home page after successful registration.
     */
      static  AccountCreationData[] accountInfo;

        public static HomePageLoggedIn sign_up(LoginPage loginPage, int userIndex) {

            // =========================================================
            // Load registration test data
            // =========================================================

            /*
             * Read the account registration data from the external JSON file.
             * Each array element represents a different user test-data set.
             */
                 accountInfo =
                    helper_Functions.read_from_json(
                            "Account_Creation_Info",
                            AccountCreationData[].class
                    );

            // =========================================================
            // Verify Signup section
            // =========================================================

            Allure.step(
                    "Verify that the 'New User Signup!' section is displayed",
                    () -> {

                        String expectedSignupText =
                                "New User Signup!";

                        String actualSignupText =
                                loginPage.verify_sign_up_text();

                        helper_Functions.saveScreenshot(
                                "create_account",
                                "Verify_New_User_Signup"
                        );

                        Assert.assertEquals(
                                actualSignupText,
                                expectedSignupText
                        );
                    }
            );
            // =========================================================
            // Enter user name and email address
            // =========================================================

            Signup_page signupPage = Allure.step(
                    "Enter the user's name and email address and start registration",
                    () ->  loginPage.perform_sign_up(
                            accountInfo[userIndex].getName(),
                            accountInfo[userIndex].getEmail_address()
                    )
            );

            // =========================================================
            // Verify Account Information section
            // =========================================================

            Allure.step(
                    "Verify that the 'ENTER ACCOUNT INFORMATION' section is displayed",
                    () -> {

                        String expectedInfoText =
                                "ENTER ACCOUNT INFORMATION";

                        String actualInfoText =
                                signupPage.enter_info_text();

                        helper_Functions.saveScreenshot(
                                "create_account",
                                "Verify_Account_Information"
                        );

                        Assert.assertEquals(
                                actualInfoText,
                                expectedInfoText
                        );
                    }
            );

            // =========================================================
            // Fill account credentials and date of birth
            // =========================================================

            Allure.step(
                    "Fill the user's account credentials and date of birth",
                    () -> {

                        // Select the user's title.
                        signupPage.choose_title();

                        // Enter the user's name.
                        signupPage.enter_name(
                                accountInfo[userIndex].getName()
                        );

                        // Enter the user's password.
                        signupPage.enter_password(
                                accountInfo[userIndex].getPassword()
                        );

                        // Select the user's date of birth.
                        signupPage.select_birth_data(
                                accountInfo[userIndex].getDay(),
                                accountInfo[userIndex].getMonth(),
                                accountInfo[userIndex].getYear()
                        );
                    }
            );

            // =========================================================
            // Select account preferences
            // =========================================================

            Allure.step(
                    "Select the required account preference checkboxes",
                    signupPage::select_checkboxes
            );

            // =========================================================
            // Fill personal and address information
            // =========================================================

            Allure.step(
                    "Enter the user's personal, address, and contact information",
                    () -> {

                        signupPage.enter_first_name(
                                accountInfo[userIndex].getFirst_name()
                        );

                        signupPage.enter_last_name(
                                accountInfo[userIndex].getLast_name()
                        );

                        signupPage.enter_company(
                                accountInfo[userIndex].getCompany()
                        );

                        signupPage.enter_address_1(
                                accountInfo[userIndex].getAddress_1()
                        );

                        signupPage.enter_address_2(
                                accountInfo[userIndex].getAddress_2()
                        );

                        signupPage.select_country(
                                accountInfo[userIndex].getCountry()
                        );

                        signupPage.enter_state(
                                accountInfo[userIndex].getState()
                        );

                        signupPage.enter_city(
                                accountInfo[userIndex].getCity()
                        );

                        signupPage.enter_zipcode(
                                accountInfo[userIndex].getZipcode()
                        );

                        signupPage.enter_mobile_number(
                                accountInfo[userIndex].getMobile_number()
                        );
                    }
            );

            // =========================================================
            // Create the account
            // =========================================================

            AccountCreatedPage accountCreatedPage = Allure.step(
                    "Submit the registration form and create the user account",
                    signupPage::create_account_click
            );

            // =========================================================
            // Verify successful account creation
            // =========================================================

            Allure.step(
                    "Verify that the account has been created successfully",
                    () -> {

                        String expectedCreatedMessage =
                                "ACCOUNT CREATED!";

                        String actualCreatedMessage =
                                accountCreatedPage.getSuccessCreationMessage();

                        helper_Functions.saveScreenshot(
                                "create_account",
                                "Verify_Account_Created"
                        );

                        Assert.assertEquals(
                                actualCreatedMessage,
                                expectedCreatedMessage
                        );
                    }
            );

            // =========================================================
            // Continue to the logged-in Home page
            // =========================================================

            HomePageLoggedIn loggedInPage = Allure.step(
                    "Continue to the Home page after account creation",
                    accountCreatedPage::clickContinue
            );

            // =========================================================
            // Verify authenticated user
            // =========================================================

            Allure.step(
                    "Verify that the newly created user is logged in successfully",
                    () -> {

                        String expectedLoggedInText =
                                "Logged in as";

                        String actualLoggedInText =
                                loggedInPage.verify_logged_as();

                        helper_Functions.saveScreenshot(
                                "create_account",
                                "Verify_Logged_In_User"
                        );

                        Assert.assertTrue(
                                actualLoggedInText.contains(
                                        expectedLoggedInText
                                )
                        );
                    }
            );

            // Return the logged-in Home Page object so that the
            // calling test can continue its workflow.
            return loggedInPage;
        }
    }

