package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryMenTshirtPage extends BasePage {


    // ============================================================
    // PAGE LOCATORS
    // ============================================================

    // Locator for the page title displaying the current Men's
    // product category.
    By men_product_text_locator = By.cssSelector(
            "div[class=\"col-sm-9 padding-right\"] " +
                    "div[class=\"features_items\"] " +
                    "h2[class=\"title text-center\"]"
    );

    // Locator for the "CATEGORY" heading displayed in the
    // left sidebar.
    By category_page_left_text = By.cssSelector(
            "div[class=\"col-sm-3\"] " +
                    "div[class=\"left-sidebar\"]> h2"
    );

    // Locator for the "BRANDS" heading displayed in the
    // left sidebar.
    By brand_page_left_text = By.cssSelector(
            "div[class=\"col-sm-3\"] " +
                    "div[class=\"brands_products\"]> h2"
    );


    // ============================================================
    // WOMEN CATEGORY LOCATORS
    // ============================================================

    // Locator for expanding/collapsing the Women category.
    By women_category_slider = By.cssSelector(
            "div#accordian " +
                    "div[class=\"panel panel-default\"]:nth-of-type(1) " +
                    "span>i"
    );

    // Locator for the Dress sub-category under Women.
    By women_dress_category_button = By.cssSelector(
            "div#Women ul>li:nth-of-type(1) a"
    );

    // Locator for the Tops sub-category under Women.
    By women_tops_category_button = By.cssSelector(
            "div#Women ul>li:nth-of-type(2) a"
    );


    // ============================================================
    // MEN CATEGORY LOCATORS
    // ============================================================

    // Locator for expanding/collapsing the Men category.
    By men_category_slider = By.cssSelector(
            "div#accordian " +
                    "div[class=\"panel panel-default\"]:nth-of-type(2) " +
                    "span>i"
    );

    // Locator for the T-shirts sub-category under Men.
    By men_tshirt_category_button = By.cssSelector(
            "div#Men ul>li:nth-of-type(1) a"
    );


    // ============================================================
    // KIDS CATEGORY LOCATORS
    // ============================================================

    // Locator for expanding/collapsing the Kids category.
    By kids_category_slider = By.cssSelector(
            "div#accordian " +
                    "div[class=\"panel panel-default\"]:nth-of-type(3) " +
                    "span>i"
    );

    // Locator for the Dress sub-category under Kids.
    By kids_dress_category_button = By.cssSelector(
            "div#Kids ul>li:nth-of-type(1)"
    );


    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    /**
     * Initializes the Men's T-shirt category page.
     *
     * @param driver WebDriver instance created by BaseTest.
     */
    public CategoryMenTshirtPage(WebDriver driver) {

        // Initialize the parent BasePage with the same WebDriver.
        super(driver);

    }

    // ============================================================
    // PRODUCT PAGE METHODS
    // ============================================================

    /**
     * Retrieves the heading displayed for the current Men's
     * product category.
     *
     * @return Text displayed in the product category heading.
     */
    public String verify_men_products_text() {

        return frame.getText(men_product_text_locator);
    }


    // ============================================================
    // LEFT SIDEBAR METHODS
    // ============================================================

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

    // ============================================================
    // WOMEN CATEGORY METHODS
    // ============================================================

    /**
     * Expands the Women category in the left sidebar.
     *
     * The page is first scrolled toward the sidebar to ensure
     * that the category control is accessible before clicking it.
     *
     */
    public void choose_women_category() {

        // Scroll to the left-side category/brand section.
        frame.scrollToElement(brand_page_left_text);

        // Expand the Women category.
        frame.click(women_category_slider);
    }


    /**
     * Selects the Dress sub-category under Women.
     *
     * @return Women's Dress category page.
     */
    public CategoryWomenDressPage choose_women_dress_category() {

        // Click the Women's Dress category.
        frame.click(women_dress_category_button);

        // Return the corresponding Page Object after navigation.
        return new CategoryWomenDressPage(driver);
    }


    /**
     * Selects the Tops sub-category under Women.
     *
     * @return Women's Tops category page.
     */
    public CategoryWomenDressPage choose_women_tops_category() {

        // Click the Women's Tops category.
        frame.click(women_tops_category_button);

        // Return the corresponding Page Object after navigation.
        return new CategoryWomenDressPage(driver);
    }


    // ============================================================
    // MEN CATEGORY METHODS
    // ============================================================

    /**
     * Expands the Men category in the left sidebar.
     */
    public void choose_men_category() {

        // Scroll to the category section so the Men category
        // is available for interaction.
        frame.scrollToElement(brand_page_left_text);

        // Expand the Men category.
        frame.click(men_category_slider);
    }


    /**
     * Selects the T-shirt sub-category under Men.
     *
     * @return Men's T-shirt category page.
     */
    public CategoryMenTshirtPage choose_men_Tshirt_category() {

        // Click the Men's T-shirt category.
        frame.click(men_tshirt_category_button);

        // Return a new Page Object representing the
        // Men's T-shirt category page.
        return new CategoryMenTshirtPage(driver);
    }


    }

