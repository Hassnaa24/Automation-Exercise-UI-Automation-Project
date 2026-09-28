package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.helper_Functions;

import java.io.IOException;

/**
 * TestNG Listener implementation used to monitor the execution lifecycle
 * of test cases.
 *
 * This listener is responsible for:
 * - Tracking the execution status of test cases.
 * - Logging test events to the console.
 * - Capturing and attaching screenshots to the Allure report when a test passes.
 *
 * To activate this listener, register it in the testng.xml file
 * or annotate the test class with @Listeners(__Listener.class).
 */
public class __Listener implements ITestListener
{

    /**
     * Invoked before each test method starts execution.
     *
     * @param result Contains information about the current test method.
     */
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart");
    }

    /**
     * Invoked when a test method completes successfully.
     *
     * Captures a screenshot of the application state and
     * attaches it to the Allure report for documentation.
     *
     * @param result Contains information about the executed test.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess");
        try {
            // Capture and attach a screenshot to the Allure report
            helper_Functions.saveScreenshot("testcase","InputScreenShot");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Invoked when a test method fails.
     *
     * @param result Contains information about the failed test.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
        try {
            // Capture and attach a screenshot to the Allure report
            helper_Functions.saveScreenshot(
                    result.getMethod().getMethodName(),
                    "Failure_" + result.getMethod().getMethodName()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Invoked when a test method is skipped.
     *
     * @param result Contains information about the skipped test.
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped");
    }

    /**
     * Invoked when a test fails but is still considered successful
     * based on the configured success percentage.
     *
     * @param result Contains information about the test.
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage");
    }

    /**
     * Invoked when a test fails because it exceeded its timeout.
     *
     * @param result Contains information about the timed-out test.
     */
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("onTestFailedWithTimeout");
    }

    /**
     * Invoked before any test methods in the current test context are executed.
     *
     * @param context Provides information about the current test context.
     */
    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart");
    }

    /**
     * Invoked after all test methods in the current test context
     * have finished execution.
     *
     * @param context Provides information about the completed test context.
     */
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish");
    }

}
