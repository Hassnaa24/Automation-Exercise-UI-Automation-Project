package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.DriverFactory;

    /**
     * BaseTest is the parent class for all test classes.
     *
     * Responsibilities:
     * - Initialize the WebDriver before each test execution.
     * - Maximize the browser window.
     * - Close the browser after each test to ensure test isolation.
     *
     * All test classes should extend this class to avoid duplicating
     * browser setup and teardown logic.
     */
    public class BaseTest {

        // WebDriver instance shared with child test classes
        protected WebDriver driver_under_test;

        final protected String url_under_test = "https://automationexercise.com";

        /**
         * Executes before every test method.
         *
         * Initializes the required browser using DriverFactory
         * and prepares it for test execution.
         */
        @BeforeClass
        public void setup() {

            // Create a new browser instance
            driver_under_test =  DriverFactory.createDriver("edge");

            // Maximize the browser window for consistent execution
            driver_under_test.manage().window().maximize();

            System.out.println("Browser Initialized.");

        }

        /**
         * Executes after every test method.
         *
         * Closes the browser session and releases all associated
         * resources to ensure each test starts with a fresh browser.
         */
        @AfterClass
        public void tearDown() {

            // Close the browser only if it was successfully initialized
            if(driver_under_test != null)
                driver_under_test.quit();

        }


    }


