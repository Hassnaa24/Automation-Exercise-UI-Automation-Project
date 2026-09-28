package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * DriverFactory is responsible for creating and returning
 * the appropriate WebDriver instance based on the browser name.
 *
 * This class centralizes browser initialization, making it easier
 * to support multiple browsers and maintain the automation framework.
 *
 * Supported browsers:
 * - Chrome
 * - Edge
 * - Firefox
 */
public class DriverFactory {

    /**
     * Creates a WebDriver instance for the specified browser.
     *
     * @param browser The name of the browser to be launched.
     *                Supported values: "chrome", "edge", "firefox".
     * @return A WebDriver instance corresponding to the requested browser.
     * @throws RuntimeException If the provided browser name is not supported.
     */
    public static WebDriver createDriver(String browser){

        switch(browser.toLowerCase()){

            // Launch Google Chrome browser
            case "chrome":
                return new ChromeDriver();

            // Launch Microsoft Edge browser
            case "edge":
                return new EdgeDriver();

            // Launch Mozilla Firefox browser
            case "firefox":
                return new FirefoxDriver();

            // Throw an exception if the browser is not supported
            default:
                throw new RuntimeException("Unsupported browser: " + browser);

        }

    }
}
