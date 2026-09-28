package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryWomenDressPage extends BasePage {

    // ==================== Page Locators ====================

    // Main heading displayed on the Women's category products section.
    By women_product_text_locator = By.cssSelector(
            "div[class=\"col-sm-9 padding-right\"] " +
                    "div[class=\"features_items\"] h2[class=\"title text-center\"]"
    );

    // Heading displayed in the left sidebar for product categories.
    By category_page_left_text = By.cssSelector(
            "div[class=\"col-sm-3\"] div[class=\"left-sidebar\"]> h2"
    );

    // Heading displayed in the left sidebar for product brands.
    By brand_page_left_text = By.cssSelector(
            "div[class=\"col-sm-3\"] div[class=\"brands_products\"]> h2"
    );


    // ==================== Women's Category Locators ====================

    // Expand/collapse the Women's category section.
    By women_category_slider = By.cssSelector(
            "div#accordian div[class=\"panel panel-default\"]:nth-of-type(1) span>i"
    );

    // Navigate to the Women's > Dress category.
    By women_dress_category_button = By.cssSelector(
            "div#Women ul>li:nth-of-type(1) a"
    );

    // Navigate to the Women's > Tops category.
    By women_tops_category_button = By.cssSelector(
            "div#Women ul>li:nth-of-type(2) a"
    );


    // ==================== Men's Category Locators ====================

    // Expand/collapse the Men's category section.
    By men_category_slider = By.cssSelector(
            "div#accordian div[class=\"panel panel-default\"]:nth-of-type(2) span>i"
    );

    // Navigate to the Men's > T-shirts category.
    By men_tshirt_category_button = By.cssSelector(
            "div#Men ul>li:nth-of-type(1) a"
    );


    // ==================== Kids' Category Locators ====================

    // Expand/collapse the Kids' category section.
    By kids_category_slider = By.cssSelector(
            "div#accordian div[class=\"panel panel-default\"]:nth-of-type(3) span>i"
    );

    // Navigate to the Kids' > Dress category.
    By kids_dress_category_button = By.cssSelector(
            "div#Kids ul>li:nth-of-type(1)"
    );


    // ==================== Constructor ====================

    /**
     * Initializes the Women's Dress Category Page.
     *
     * @param driver WebDriver instance used to interact with the page.
     */
    public CategoryWomenDressPage(WebDriver driver) {
        super(driver);
    }


    // ==================== Product Section Methods ====================

    /**
     * Retrieves the heading displayed for the Women's products section.
     *
     * @return The text of the Women's products heading.
     */
    public String verify_women_products_text() {
        return frame.getText(women_product_text_locator);
    }


    // ==================== Left Sidebar Methods ====================

    /**
     * Retrieves the category heading displayed in the
     * left sidebar.
     *
     * @return Category heading text.
     */
    public String verify_categoryHeaderText() {

        return frame.getText(category_page_left_text);
    }

    /**
     * Retrieves the brand heading displayed in the
     * left sidebar.
     *
     * @return brand heading text.
     */
    public String verify_brandHeaderText() {

        return frame.getText(brand_page_left_text);
    }

    // ==================== Women's Category Methods ====================

    /**
     * Expands the Women's category section in the left sidebar.
     *
     * The sidebar is scrolled into view before clicking the category slider
     * to make sure the element is visible and interactable.
     */
    public void choose_women_category() {
        frame.scrollToElement(brand_page_left_text);
        frame.click(women_category_slider);
    }

    /**
     * Navigates to the Women's > Dress category.
     *
     * @return A new page object representing the Women's Dress category page.
     */
    public CategoryWomenDressPage choose_women_dress_category() {
        frame.click(women_dress_category_button);
        return new CategoryWomenDressPage(driver);
    }

    /**
     * Navigates to the Women's > Tops category.
     *
     * @return A page object representing the Women's category page.
     */
    public CategoryWomenDressPage choose_women_tops_category() {
        frame.click(women_tops_category_button);
        return new CategoryWomenDressPage(driver);
    }


    // ==================== Men's Category Methods ====================

    /**
     * Expands the Men's category section in the left sidebar.
     *
     * The sidebar is scrolled into view before interacting with the slider.
     */
    public void choose_men_category() {
        frame.scrollToElement(brand_page_left_text);
        frame.click(men_category_slider);
    }

    /**
     * Navigates to the Men's > T-shirts category.
     *
     * @return A page object representing the Men's T-shirt category page.
     */
    public CategoryMenTshirtPage choose_men_Tshirt_category() {
        frame.click(men_tshirt_category_button);
        return new CategoryMenTshirtPage(driver);
    }


}
