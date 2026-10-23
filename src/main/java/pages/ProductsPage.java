package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    // ========================== LOCATORS ==========================

    // -------------------------- Product Details --------------------------

    // Locates the View Product Details option for the first displayed product.
    private final By view_details_first_item = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2) div[class=\"choose\"]");

    // Locates the Add to Cart option for the first product when its overlay is displayed.
    private final By hover_first_item  = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2) div[class=\"product-overlay\"]  a[data-product-id=\"1\"]");

    // Locates the Add to Cart option for the second product when its overlay is displayed.
    private final By hover_second_item = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3) div[class=\"product-overlay\"]  a[data-product-id=\"2\"]");


    // -------------------------- Add to Cart --------------------------

    // Locates the Add to Cart icon for the first product.
    private final By add_chart_first_item  = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2)  a[data-product-id=\"1\"] i");

    // Locates the Add to Cart icon for the second product.
    private final By add_chart_second_item = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3)  a[data-product-id=\"2\"] i");

    // Alternative locators for the Add to Cart buttons of the first and second products.
    // private final By item1_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2) a[class=\"btn btn-default add-to-cart\"]");
    // private final By item2_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3) a[class=\"btn btn-default add-to-cart\"]");

    // Locates the Add to Cart button for the third displayed product.
    private final By item3_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(4) a[class=\"btn btn-default add-to-cart\"]");


    // -------------------------- Search Results: Tops --------------------------

    // Locates the Add to Cart option for the first product in the Tops search results.
    private final By add_chart_first_item_tops_search  = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2)  a[data-product-id=\"1\"]");

    // Locates the Add to Cart option for the second product in the Tops search results.
    private final By add_chart_second_item_tops_search = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3)  a[data-product-id=\"5\"]");

    // Locates the product description of the first item in the Tops search results.
    private final By item_1_inSearch_tops_description = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2) p");

    // Locates the product description of the second item in the Tops search results.
    private final By item_2_inSearch_tops_description = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3) p");

    // Locates the product description of the third item in the Tops search results.
    private final By item_3_inSearch_tops_description = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(4) p");


    // -------------------------- Cart Confirmation Modal --------------------------

    // Locates the Continue Shopping button in the Add to Cart confirmation modal.
    private final By continue_shopping_button   = By.cssSelector("div[class=\"modal-content\"] div[class=\"modal-footer\"] button");

    // Locates the View Cart link in the Add to Cart confirmation modal.
    private final By view_chart_button          = By.cssSelector("div[class=\"modal-content\"] div[class=\"modal-body\"] p a");


    // -------------------------- Product Search --------------------------

    // Locates the input field used to enter a product search term.
    private final By search_box_locator         = By.cssSelector("div[class=\"container\"] input#search_product");

    // Locates the button that submits the product search.
    private final By search_button_locator      = By.cssSelector("div[class=\"container\"] button#submit_search");

    // Locates the heading displayed above the product search results.
    private final By searched_products_text_locator = By.cssSelector("div[class=\"features_items\"] h2");


    // -------------------------- Product Brands --------------------------

    // Locates the heading of the Brands section in the left sidebar.
    private final By brand_page_left_text       = By.cssSelector("div[class=\"col-sm-3\"] div[class=\"brands_products\"]> h2");

    // Locates the Polo brand option.
    private final By polo_brand_text            = By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(1) a span");

    // Locates the H&M brand option.
    private final By HM_brand_text              = By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(2) a span");

    // Locates the Madame brand option.
    private final By Madame_brand_text          = By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(3) a span");

    // Locates the Mast & Harbour brand option.
    private final By MastHarbour_brand_text     = By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(4) a span");

    // Locates the Biba brand option, used as a reference point for scrolling.
    private final By Biba_brand_text            = By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(8) a span");


    // ========================== CONSTRUCTOR ==========================

    /**
     * Initializes the ProductsPage and inherits the shared page functionality
     * and WebDriver setup from BasePage.
     *
     * @param driver the WebDriver instance used to control the browser
     */
    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    // ========================== PAGE NAVIGATION ==========================

    /**
     * Clicks the Cart button from the products page.
     *
     * @return a CartPage page object for subsequent cart interactions
     */
    public CartPage Go_To_cart_page_from_productsPage()
    {
        frame.click(cart_button) ;
        return new CartPage(driver);
    }

    /**
     * Opens the details page for the first displayed product.
     *
     * @return an itemDetailsPage page object for interacting with product details
     */
    public itemDetailsPage navigate_to_product_details_item_1()
    {
        frame.click(view_details_first_item);
        return new itemDetailsPage(driver);
    }


    // ========================== ADD PRODUCTS TO CART ==========================

    /**
     * Scrolls to the Biba brand option and clicks the Add to Cart icon
     * associated with the first product.
     */
    public void add_item1_to_cart()
    {
        frame.scrollToElement(Biba_brand_text);
        frame.click(add_chart_first_item  );
    }

    /**
     * Scrolls to the Biba brand option and clicks the Add to Cart icon
     * associated with the second product.
     */
    public void add_item2_to_cart()
    {
        frame.scrollToElement(Biba_brand_text);
        frame.click( add_chart_second_item);
    }


    // ========================== HOVER-BASED PRODUCT ACTIONS ==========================

    /**
     * Hovers over the first product to display its overlay, then performs
     * the configured Add to Cart click action.
     */
    public void hover_add_item1_to_cart()
    {
        frame.hover_on_element(hover_first_item);
        frame.click( add_chart_second_item );

    }

    /**
     * Hovers over the second product to display its overlay, then performs
     * the configured Add to Cart click action.
     */
    public void hover_add_item2_to_cart()
    {
        frame.hover_on_element(hover_second_item);
        frame.click( add_chart_second_item);

    }


    // ========================== CART MODAL ACTIONS ==========================

    /**
     * Clicks Continue Shopping to close the cart confirmation modal
     * and continue browsing products.
     */
    public void continue_shopping()
    {
        frame.click(continue_shopping_button);
    }

    /**
     * Clicks View Cart in the cart confirmation modal.
     *
     * @return a CartPage page object for subsequent cart interactions
     */
    public CartPage view_chart()
    {
        frame.click(view_chart_button);
        return new CartPage(driver);
    }


    // ========================== PRODUCT SEARCH ==========================

    /**
     * Enters the specified product name or search term into the search field.
     *
     * @param item_name the product name or keyword to search for
     */
    public void search_for_item(String item_name)
    {
        frame.sendKeys(search_box_locator,item_name);
    }

    /**
     * Clicks the Search button to display matching products.
     */
    public void search_button_click()
    {
        frame.click(search_button_locator);
    }

    /**
     * Retrieves the heading displayed above the product search results.
     *
     * @return the search results heading text
     */
    public String verify_searched_products_text()
    {
        return frame.getText(searched_products_text_locator);
    }


    // ========================== SEARCH RESULT DETAILS: TOPS ==========================

    /**
     * Retrieves the description of the first product in the Tops search results.
     *
     * @return the first product's description text
     */
    public String verify_item_1_top_product_search()
    {
        return frame.getText(item_1_inSearch_tops_description);
    }

    /**
     * Retrieves the description of the second product in the Tops search results.
     *
     * @return the second product's description text
     */
    public String verify_item_2_top_product_search()
    {
        return frame.getText(item_2_inSearch_tops_description);
    }

    /**
     * Retrieves the description of the third product in the Tops search results.
     *
     * @return the third product's description text
     */
    public String verify_item_3_top_product_search()
    {
        return frame.getText(item_3_inSearch_tops_description);
    }

    /**
     * Clicks the Add to Cart option for the first product in the Tops search results.
     */
    public void add_item1_in_search_to_cart()
    {
        frame.click( add_chart_first_item_tops_search);
    }

    /**
     * Clicks the Add to Cart option for the second product in the Tops search results.
     */
    public void add_item2_in_search_to_cart()
    {
        frame.click(add_chart_second_item_tops_search);
    }


    // ========================== BRAND SELECTION ==========================

    /**
     * Retrieves the heading displayed above the Brands section in the left sidebar.
     *
     * @return the Brands section heading text
     */
    public String verify_brand_text_left_side()
    {
        return frame.getText(brand_page_left_text);
    }

    /**
     * Scrolls to the brand list and selects Polo.
     *
     * @return a Polo_BrandPage page object for interacting with Polo products
     */
    public Polo_BrandPage choose_polo_brand()
    {
        frame.scrollToElement(Biba_brand_text);
        frame.click(polo_brand_text );
        return new Polo_BrandPage(driver);
    }

    /**
     * Scrolls to the brand list and selects H&M.
     *
     * @return an HM_BrandPage page object for interacting with H&M products
     */
    public HM_BrandPage choose_HM_brand()
    {
        frame.scrollToElement(Biba_brand_text);
        frame.click( HM_brand_text  );
        return new HM_BrandPage(driver);
    }

    /**
     * Scrolls to the brand list and selects Madame.
     */
    public void choose_Madame_brand()
    {
        frame.scrollToElement(Biba_brand_text);
        frame.click(Madame_brand_text  );
    }

    /**
     * Scrolls to the brand list and selects Mast & Harbour.
     */
    public void choose_MastHarbour_brand()
    {
        frame.scrollToElement(Biba_brand_text);
        frame.click(MastHarbour_brand_text);
    }

}
