package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_page extends BasePage {

    // ========================== PRODUCT LOCATORS ==========================

    // Locates the View Product Details button for the first target product.
    private final By item1_locator_view_details_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2) div[class=\"choose\"] a i");

    // Locates the product container for the first target product.
    // This locator is used as the scroll target before interacting with the product.
    private final By item1_locator = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2)");

    // Locates the Add to Cart button for the first target product.
    private final By item1_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2)  a[data-product-id=\"1\"]");

    // Locates the Add to Cart button for the second target product.
    private final By item2_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3)  a[data-product-id=\"2\"]");


    // ========================== CART MODAL LOCATORS ==========================

    // Locates the Continue Shopping button in the Add to Cart confirmation modal.
    private final By continue_shopping_button = By.cssSelector("div[class=\"modal-content\"] div[class=\"modal-footer\"] button");

    // Locates the View Cart link in the Add to Cart confirmation modal.
    private final By view_chart_button = By.cssSelector("div[class=\"modal-content\"] div[class=\"modal-body\"] p a");

    // Locates a link inside the cart confirmation modal that can be used to open the cart.
    private final By item_locator_view_chart_button = By.cssSelector("div[class=\"modal-content\"] a");


    // ========================== RECOMMENDED PRODUCT LOCATORS ==========================

    // Locates the recommended products carousel, used as the scrolling target.
    private final By recommended_item_scroll_locator = By.cssSelector("div#recommended-item-carousel");

    // Locates the heading text of the Recommended Items section.
    private final By recommended_item_text = By.cssSelector("div[class=\"recommended_items\"] h2[class=\"title text-center\"]");

    // Locates the Add to Cart button for the recommended product with product ID 2.
    private final By recommended_item_2_add_chart_locator = By.cssSelector("div#recommended-item-carousel[class=\"carousel slide\"] div[class=\"single-products\"] a[data-product-id=\"2\"]");


    // ========================== CATEGORY AND BRAND LOCATORS ==========================

    // Locates the heading of the Categories section in the left sidebar.
    private final By category_page_left_text = By.cssSelector("div[class=\"col-sm-3\"] div[class=\"left-sidebar\"]> h2");

    // Locates the heading of the Brands section in the left sidebar.
    private final By brand_page_left_text = By.cssSelector("div[class=\"col-sm-3\"] div[class=\"brands_products\"]> h2");


    // ========================== WOMEN'S CATEGORY LOCATORS ==========================

    // Locates the expand/collapse control for the Women category.
    private final By women_category_slider = By.cssSelector("div#accordian div[class=\"panel panel-default\"]:nth-of-type(1) span>i");

    // Locates the Dresses category link under Women.
    private final By women_dress_category_button = By.cssSelector("div#Women ul>li:nth-of-type(1) a");

    // Locates the Tops category link under Women.
    private final By women_tops_category_button = By.cssSelector("div#Women ul>li:nth-of-type(2) a");


    // ========================== MEN'S CATEGORY LOCATORS ==========================

    // Locates the expand/collapse control for the Men category.
    private final By men_category_slider = By.cssSelector("div#accordian div[class=\"panel panel-default\"]:nth-of-type(2) span>i");

    // Locates the T-shirts category link under Men.
    private final By men_tshirt_category_button = By.cssSelector("div#Men ul>li:nth-of-type(1) a");


    // ========================== KIDS' CATEGORY LOCATORS ==========================

    // Locates the expand/collapse control for the Kids category.
    private final By kids_category_slider = By.cssSelector("div#accordian div[class=\"panel panel-default\"]:nth-of-type(3) span>i");

    // Locates the Dresses category item under Kids.
    private final By kids_dress_category_button = By.cssSelector("div#Kids ul>li:nth-of-type(1)");


    // ========================== CONSTRUCTOR ==========================

    /**
     * Initializes the home page and inherits the shared browser
     * interaction functionality from BasePage.
     *
     * @param driver the WebDriver instance used to control the browser
     */
    public Home_page(WebDriver driver) {
        super(driver);

    }


    // ========================== PAGE NAVIGATION METHODS ==========================

    /**
     * Clicks the Products button to navigate from the home page
     * to the products listing page.
     *
     * @return a ProductsPage object representing the products page
     */
    public ProductsPage Go_To_products_page_from_homepage() {
        frame.click(products_button);
        return new ProductsPage(driver);
    }

    /**
     * Clicks the Cart button to navigate to the shopping cart page.
     *
     * @return a CartPage object representing the shopping cart page
     */
    public CartPage Go_To_cart_page_from_homepage() {
        frame.click(cart_button);
        return new CartPage(driver);
    }

    /**
     * Clicks the Signup/Login button to navigate to the login page.
     *
     * @return a LoginPage object representing the login page
     */
    public LoginPage Go_To_signup_login_page() {
        frame.click(signup_login_button);
        return new LoginPage(driver);
    }

    /**
     * Clicks the Test Cases button to navigate to the test cases page.
     *
     * @return a TestCases_page object representing the test cases page
     */
    public TestCases_page Go_To_testcase_page() {
        frame.click(testCases_button);
        return new TestCases_page(driver);
    }

    /**
     * Clicks the Contact Us button to navigate to the contact form page.
     *
     * @return a ContactUsPage object representing the Contact Us page
     */
    public ContactUsPage Go_To_contactus_page_from_homepage() {
        frame.click(contactUs_button);
        return new ContactUsPage(driver);
    }


    // ========================== PRODUCT DETAILS AND CART METHODS ==========================

    /**
     * Scrolls to the first target product, clicks its View Product Details
     * button, and navigates to the product details page.
     *
     * @return an itemDetailsPage object representing the product details page
     */
    public itemDetailsPage go_to_item_details_page() {
        frame.scrollToElement(item1_locator);
        frame.click(item1_locator_view_details_button);
        return new itemDetailsPage(driver);
    }

    /**
     * Scrolls to the first target product, adds it to the cart,
     * and opens the shopping cart from the confirmation modal.
     *
     * @return a CartPage object representing the shopping cart page
     */
    public CartPage go_to_item_cart() {
        frame.scrollToElement(item1_locator);
        frame.click(item1_locator_add_to_chart_button);
        frame.click(item_locator_view_chart_button);
        return new CartPage(driver);
    }

    /**
     * Adds the first and second target products to the shopping cart.
     * Clicks Continue Shopping after each addition to close the
     * confirmation modal and return to the product listing.
     */
    public void add_items_to_cart() {
        // frame.hover_on_element(item1_locator);
        frame.click(item1_locator_add_to_chart_button);
       // frame.click(item2_locator_add_to_chart_button);
        frame.click(continue_shopping_button);
    }


    //   ************************************************************************************************
    /**
     * Navigates to the cart after adding a recommended item.
     *
     * Scrolls to the recommended items section, adds the specified
     * recommended product to the cart, and opens the cart page.
     *
     * @return a CartPage object representing the shopping cart page
     */
    public CartPage go_to_recommended_item_to_cart()
    {
        scroll_to_recommended_item();
        frame.click(recommended_item_2_add_chart_locator);
        frame.click(item_locator_view_chart_button);
        return new CartPage(driver);
    }

    /**
     * Scrolls the page to the recommended items section.
     */
    public void scroll_to_recommended_item()
    {
        frame.scrollToElement(recommended_item_scroll_locator);
    }

    /**
     * Retrieves the heading text displayed in the recommended items section.
     *
     * @return the recommended items section heading
     */
    public String verify_recommended_item_text()
    {
        return frame.getText(recommended_item_text);
    }

    // ========================== CATEGORY SECTION ==========================

    /**
     * Retrieves the heading text displayed in the category section
     * of the left sidebar.
     *
     * @return the category section heading
     */
    public String verify_category_text()
    {
        return frame.getText(category_page_left_text);
    }

    // ========================== WOMEN'S CATEGORY ==========================

    /**
     * Expands the Women's category in the left sidebar.
     *
     * Scrolls to the sidebar area before clicking the Women's
     * category control.
     */
    public void choose_women_category()
    {
        frame.scrollToElement(brand_page_left_text);
        frame.click(women_category_slider);
    }

    /**
     * Navigates to the Women's Dress category page.
     *
     * @return a CategoryWomenDressPage object representing the
     *         Women's Dress category page
     */
    public CategoryWomenDressPage choose_women_dress_category()
    {
        frame.click(women_dress_category_button);
        return new CategoryWomenDressPage(driver);
    }

    /**
     * Navigates to the Women's Tops category page.
     *
     * @return a CategoryWomenDressPage object representing the
     *         Women's Tops category page
     */
    public CategoryWomenDressPage choose_women_tops_category()
    {
        frame.click(women_tops_category_button);
        return new CategoryWomenDressPage(driver);
    }

    // ========================== MEN'S CATEGORY ==========================

    /**
     * Expands the Men's category in the left sidebar.
     *
     * Scrolls to the sidebar area before clicking the Men's
     * category control.
     */
    public void choose_men_category()
    {
        frame.scrollToElement(brand_page_left_text);
        frame.click(men_category_slider);
    }

    /**
     * Navigates to the Men's T-shirts category page.
     *
     * @return a CategoryMenTshirtPage object representing the
     *         Men's T-shirts category page
     */
    public CategoryMenTshirtPage choose_men_Tshirt_category()
    {
        frame.click(men_tshirt_category_button);
        return new CategoryMenTshirtPage(driver);
    }

}