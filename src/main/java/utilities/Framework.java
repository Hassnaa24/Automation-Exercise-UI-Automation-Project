package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class Framework {

    private static   WebDriver driver;
    private   WebDriverWait explicit_wait;
    private  final int default_time_out = 10;

    public Framework(WebDriver driver)
    {
       this.driver = driver;
       this.explicit_wait = new WebDriverWait(driver, Duration.ofSeconds( default_time_out));
    }

    static public File takeScreenshot(String test_case,String Filename) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("screenshot_" + test_case + "_" + Filename + "_" + timestamp + ".png");
        FileHandler.copy(src, Dest);
        return Dest;
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Browser implicitly wait
    public  void implicitWait(int seconds)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        System.out.println("Set Implicit Wait to " + seconds + " seconds.");
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Explicit wait for element presence
    public void explicitWait(By locator, int timeoutSeconds)
    {
        new WebDriverWait(driver,Duration.ofSeconds(timeoutSeconds)).
                until(ExpectedConditions.presenceOfElementLocated(locator));
        System.out.println("Explicit wait for presence of " + locator);
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Fluent wait for element visibility with customizable timeout and polling interval
    public void fluentWait(By locator, int timeoutSeconds, int pollingMillis, String timeoutMessage)
    {
        Wait<WebDriver> fluent_wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(pollingMillis))
                .withMessage(timeoutMessage)
                .ignoring(NoSuchElementException.class);

        fluent_wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        System.out.println("Fluent wait found element " + locator);
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Navigate to URL
    public  void navigateToURL(String url)
    {
        driver.get(url);
        System.out.println("Navigated to URL: " + url);
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Get page title
    public  String getPageTitle()
    {
        String title=driver.getTitle();
        System.out.println("Page title is '" + title + "'");
        return  title ;
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Get current URL
    public  String getCurrentURL()
    {
        String current_url= driver.getCurrentUrl();
        System.out.println("Current URL is '" + current_url + "'");
        return current_url;
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Click element using explicit wait
    public void click(By locator)
    {
        //driver.findElement(locator).click();
        //explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        explicit_wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        System.out.println("Clicked element " + locator);
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // new added ***************
    public void hover_on_element(By locator)
    {
        Actions hover= new Actions(driver);
        hover.moveToElement(driver.findElement(locator)).perform();
        System.out.println("hovered element and clicked " + locator);
    }
    public void clear_text(By locator)
    {
        Actions clear= new Actions(driver);
        clear.moveToElement(driver.findElement(locator)).click().sendKeys(Keys.BACK_SPACE).perform();

    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Right click (context click) on element
    public void rightClick(By locator)
    {
        WebElement element=explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Actions right_click_action=new Actions(driver);
        right_click_action.contextClick(element).perform();
        System.out.println("Right-clicked on element " + locator);
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    //Send keys to element
    public void sendKeys(By locator, String text)
    {
        //explicit_wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)).sendKeys(text);
        //driver.findElement(locator).sendKeys(text);
        explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
    public void click_enter(By locator)
    {
        //explicit_wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)).sendKeys(text);
        //driver.findElement(locator).sendKeys(text);
        explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.ENTER);
    }


    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Get text from element
    public String getText(By locator)
    {
        String text=explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        System.out.println("Got text from element " + locator + ": " + text);
        return text;
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Dropdown handling by visible text
    public void selectDropdownByVisibleText(By locator, String visibleText)
    {
        WebElement dropdown = explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
        System.out.println("Selected dropdown value by visible text: " + visibleText);
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Dropdown handling by value
    public void selectDropdownByValue(By locator, String value)
    {
        WebElement dropdown = explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select select = new Select(dropdown);
        select.selectByValue(value);
        System.out.println("Selected dropdown value by value: " + value);
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Dropdown handling by index
    public void selectDropdownByIndex(By locator, int index)
    {
        WebElement dropdown = explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select select = new Select(dropdown);
        select.selectByIndex(index);
        System.out.println("Selected dropdown by index: " + index);

    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Drag and drop element
    public void dragAndDrop(By sourceLocator, By targetLocator)
    {
        WebElement source=explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
        WebElement target=explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
        Actions drag_action=new Actions(driver);
        drag_action.dragAndDrop(source,target).perform();
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Checkbox handling: check checkbox
    public void checkCheckbox(By locator)
    {
        WebElement checkbox = explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if(!checkbox.isSelected())
        {
            checkbox.click();
            System.out.println("Checked the checkbox " + locator);
        }
        else
        {
            System.out.println("Checkbox already checked " + locator);
        }
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Checkbox handling: uncheck checkbox
    public void uncheckCheckbox(By locator)
    {
        WebElement checkbox = explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if(checkbox.isSelected())
        {
            checkbox.click();
            System.out.println("Unchecked the checkbox " + locator);
        }
        else
        {
            System.out.println("Checkbox already unchecked " + locator);
        }
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Radio button handling: select radio button
    public void selectRadioButton(By locator)
    {
        WebElement RadioButton = explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if(!RadioButton.isSelected())
        {
            RadioButton.click();
            System.out.println("Selected radio button " + locator);
        }
        else
        {
            System.out.println("Radio button already selected " + locator);
        }
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Window handle: switch to window by title
    public void switchToWindowByTitle(String windowTitle)
    {
        String current_window=driver.getWindowHandle();
        Set<String> all_windows=driver.getWindowHandles();

        for(String window:all_windows)
        {
            driver.switchTo().window(window);
            if(driver.getTitle().equals(windowTitle))
            {
                System.out.println(driver.getTitle());
                return;
            }
        }
        driver.switchTo().window(current_window);
        System.out.println("Window with title '" + windowTitle + "' not found. Stayed in original window.");
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    //  Window handle: switch to window by handle
    public void switchToWindowByHandle(String windowHandle)
    {
        Set<String> all_windows=driver.getWindowHandles();
        if(all_windows.contains(windowHandle))
        {
            driver.switchTo().window(windowHandle);
            System.out.println("Switched to window handle: " + windowHandle);
        }
        else
        {
            System.out.println("Window handle " + windowHandle + " does not exist. No switch performed.");
        }
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Close current window
    public void closeCurrentWindow()
    {
        driver.close();
        System.out.println("Closed current window.");
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Navigate back
    public  void navigateBack()
    {
        driver.navigate().back();
        System.out.println("Navigated back.");
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Navigate forward
    public void navigateForward()
    {
        driver.navigate().forward();
        System.out.println("Navigated forward.");
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Refresh the page
    public void refreshPage()
    {
        driver.navigate().refresh();
        System.out.println("Page refreshed.");
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Scroll to element using JavaScript
    public void scrollToElement(By locator)
    {
        WebElement element=explicit_wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Actions scroll_action=new Actions(driver);
        scroll_action.scrollToElement(element).perform();
        System.out.println("Scrolled to element " + locator + " using Actions.scrollToElement().");
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    //Handle alert: accept alert
    public  void acceptAlert()
    {
        // driver.switchTo().alert().accept();

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(default_time_out));
        //Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Alert alert=explicit_wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        System.out.println("Alert accepted.");
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    //Handle alert: dismiss alert
    public void dismissAlert()
    {
       // driver.switchTo().alert().dismiss();

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(default_time_out));
       // Alert alert=wait.until(ExpectedConditions.alertIsPresent());

       Alert alert=explicit_wait.until(ExpectedConditions.alertIsPresent());
       alert.dismiss();
        System.out.println("Alert dismissed.");
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    //Handle alert: get alert text
    public  String getAlertText()
    {
        //String text = driver.switchTo().alert().getText();

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(default_time_out));
        //Alert alert=wait.until(ExpectedConditions.alertIsPresent());

        Alert alert=explicit_wait.until(ExpectedConditions.alertIsPresent());
        String text= alert.getText();
        System.out.println("Alert text: " + text);
        return text;
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    //
    public void sendTextToAlert(String text)
    {
        //driver.switchTo().alert().sendKeys(text);
        //driver.switchTo().alert().accept();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(default_time_out));
        //Alert alert=wait.until(ExpectedConditions.alertIsPresent());

        Alert alert=explicit_wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(text);
        alert.accept();
        System.out.println("Sent text to alert and accepted it: " + text);
    }
    // / ///////////////////////////////////////////////////////////////////////////////////////////////////
    // Close the browser
    public  void closeBrowser()
    {
        if(driver!= null)
        {
            driver.quit();
            System.out.println("Browser Closed.");
        }
    }


}
