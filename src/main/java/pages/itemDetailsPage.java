package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class itemDetailsPage extends BasePage {


    // ==================== Constructor ====================

    /**
     * Initializes the Item Details Page Object.
     *
     * @param driver WebDriver instance used to interact with the page.
     */
    public itemDetailsPage(WebDriver driver) {
        super(driver);
    }


    // ==================== Page Locators ====================

    // Button used to add the current product to the shopping cart.
    private final By add_to_chart_button =
            By.cssSelector("button[class=\"btn btn-default cart\"]");

    // Button/link displayed after adding a product, used to navigate to the cart.
    private final By view_chart_button =
            By.cssSelector("p[class=\"text-center\"]:nth-of-type(2)");

    // Quantity input field used to set the desired product quantity.
    private final By increase_quantity =
            By.cssSelector("input#quantity[type=\"number\"]");

    // Product ID input field used by the page when handling product information.
    private final By decrease_quantity =
            By.cssSelector("input#product_id[name=\"product_id\"]");


    // ==================== Product Information Locators ====================

    // Product name displayed on the Item Details page.
    private final By item_name_locator =
            By.cssSelector("div[class=\"product-information\"] h2");

    // Product category displayed on the Item Details page.
    private final By item_category_locator =
            By.cssSelector("div[class=\"product-information\"] p:nth-of-type(1)");

    // Product price displayed on the Item Details page.
    private final By item_price_locator =
            By.cssSelector("div[class=\"product-information\"] span span");

    // Product availability status displayed on the Item Details page.
    private final By item_availability_locator =
            By.cssSelector("div[class=\"product-information\"] p:nth-of-type(2)");

    // Product condition displayed on the Item Details page.
    private final By item_condition_locator =
            By.cssSelector("div[class=\"product-information\"] p:nth-of-type(3)");

    // Product brand displayed on the Item Details page.
    private final By item_brand_locator =
            By.cssSelector("div[class=\"product-information\"] p:nth-of-type(4)");


    // ==================== Review Locators ====================

    // Link used to open the product review section.
    private final By item_write_review_locator =
            By.cssSelector("div[class=\"category-tab shop-details-tab\"] li a");

    // Input field for entering the reviewer's name.
    private final By review_name_box_locator =
            By.cssSelector("div[class=\"category-tab shop-details-tab\"] form input#name");

    // Input field for entering the reviewer's email address.
    private final By review_email_box_locator =
            By.cssSelector("div[class=\"category-tab shop-details-tab\"] form input#email");

    // Text area for entering the product review message.
    private final By review_message_box_locator =
            By.cssSelector("div[class=\"category-tab shop-details-tab\"] form textarea");

    // Button used to submit the product review.
    private final By review_submit_button_locator =
            By.cssSelector("div[class=\"category-tab shop-details-tab\"] form button");

    // Success message displayed after the product review is submitted successfully.
    private final By success_review_submit_message =
            By.cssSelector(
                    "div[class=\"category-tab shop-details-tab\"] " +
                            "div[class=\"alert-success alert\"] span"
            );


    // ==================== Quantity Methods ====================

    /**
     * Sets the desired quantity for the current product.
     *
     * @param quantity Quantity value to be entered.
     */
    public void increase_item_quantity(String quantity) {
        // Clear the existing quantity before entering the new value.
        frame.clear_text(increase_quantity);

        // Enter the requested product quantity.
        frame.sendKeys(increase_quantity, quantity);
    }

    /**
     * Sets the product quantity using the product ID field.
     *
     * @param quantity Quantity value to be entered.
     */
    public void decrease_item_quantity(String quantity) {
        // Clear the existing value before entering the new quantity.
        frame.clear_text(decrease_quantity);

        // Enter the requested quantity.
        frame.sendKeys(decrease_quantity, quantity);
    }


    // ==================== Cart Methods ====================

    /**
     * Adds the current product to the shopping cart and opens the cart page.
     *
     * @return Cart Page Object representing the shopping cart.
     */
    public CartPage add_and_view_chart() {

        // Add the selected product to the shopping cart.
        frame.click(add_to_chart_button);

        // Open the cart after the product has been added.
        frame.click(view_chart_button);

        return new CartPage(driver);
    }


    // ==================== Product Information Methods ====================

    /**
     * Retrieves the product name.
     *
     * @return Product name displayed on the page.
     */
    public String get_item_name() {
        return frame.getText(item_name_locator);
    }

    /**
     * Retrieves the product category.
     *
     * @return Product category displayed on the page.
     */
    public String get_item_category() {
        return frame.getText(item_category_locator);
    }

    /**
     * Retrieves the product price.
     *
     * @return Product price displayed on the page.
     */
    public String get_item_price() {
        return frame.getText(item_price_locator);
    }

    /**
     * Retrieves the product availability status.
     *
     * @return Product availability information.
     */
    public String get_item_availability() {
        return frame.getText(item_availability_locator);
    }

    /**
     * Retrieves the product condition.
     *
     * @return Product condition information.
     */
    public String get_item_condition() {
        return frame.getText(item_condition_locator);
    }

    /**
     * Retrieves the product brand.
     *
     * @return Product brand displayed on the page.
     */
    public String get_item_brand() {
        return frame.getText(item_brand_locator);
    }


    // ==================== Product Review Methods ====================

    /**
     * Retrieves the text displayed for the product review section.
     *
     * @return Product review section text.
     */
    public String verify_review_text() {
        return frame.getText(item_write_review_locator);
    }

    /**
     * Enters the review details and submits the product review.
     *
     * @param name           Reviewer's name.
     * @param email          Reviewer's email address.
     * @param review_message Product review message.
     */
    public void write_review(String name, String email, String review_message) {

        // Scroll to the review submission area to make the fields accessible.
        frame.scrollToElement(review_submit_button_locator);

        // Enter the reviewer's name.
        frame.sendKeys(review_name_box_locator, name);

        // Enter the reviewer's email address.
        frame.sendKeys(review_email_box_locator, email);

        // Enter the product review message.
        frame.sendKeys(review_message_box_locator, review_message);

        // Submit the completed product review.
        frame.click(review_submit_button_locator);
    }

    /**
     * Retrieves the success message displayed after submitting the product review.
     *
     * @return Review submission success message.
     */
    public String verify_success_review_submit() {
        return frame.getText(success_review_submit_message);
    }
}