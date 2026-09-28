package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Framework;

public class products_page extends BasePage {
    private final WebDriver driver;
    private final Framework frame;

    // ********************************** locators ********************************************************************

    private final  By view_details_first_item = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2) div[class=\"choose\"]");

    private final  By hover_first_item  = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2) div[class=\"product-overlay\"]  a[data-product-id=\"1\"]");
    private final  By hover_second_item = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3) div[class=\"product-overlay\"]  a[data-product-id=\"2\"]");

   private final  By add_chart_first_item  = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2)  a[data-product-id=\"1\"] i");
   private final  By add_chart_second_item = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3)  a[data-product-id=\"2\"] i");

   // private final By item1_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2) a[class=\"btn btn-default add-to-cart\"]");
   // private final By item2_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3) a[class=\"btn btn-default add-to-cart\"]");
   private final By item3_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(4) a[class=\"btn btn-default add-to-cart\"]");

    private final  By add_chart_first_item_tops_search  = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2)  a[data-product-id=\"1\"]");
    private final  By add_chart_second_item_tops_search = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3)  a[data-product-id=\"5\"]");

    private final By item_1_inSearch_tops_description = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2) p");
    private final By item_2_inSearch_tops_description = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3) p");
    private final By item_3_inSearch_tops_description = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(4) p");

    private final  By continue_shopping_button   = By.cssSelector("div[class=\"modal-content\"] div[class=\"modal-footer\"] button");
    private final  By view_chart_button          = By.cssSelector("div[class=\"modal-content\"] div[class=\"modal-body\"] p a");

    private final  By search_box_locator         = By.cssSelector("div[class=\"container\"] input#search_product");
    private final  By search_button_locator      = By.cssSelector("div[class=\"container\"] button#submit_search");
    private final  By searched_products_text_locator = By.cssSelector("div[class=\"features_items\"] h2");

    private final By brand_page_left_text       = By.cssSelector("div[class=\"col-sm-3\"] div[class=\"brands_products\"]> h2");
    private final By polo_brand_text            = By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(1) a span");
    private final By HM_brand_text              = By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(2) a span");
    private final By Madame_brand_text          = By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(3) a span");
    private final By MastHarbour_brand_text     = By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(4) a span");
    private final By Biba_brand_text            = By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(8) a span");


    // constructor
    public products_page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        frame=new Framework(driver);
    }


    public CartPage Go_To_cart_page_from_productsPage()
    {
        frame.click(cart_button) ;
        return new CartPage(driver);
    }
    public itemDetailsPage navigate_to_product_details_item_1()
    {
        frame.click(view_details_first_item);
        return new itemDetailsPage(driver);
    }
    // *********************************************
    public void add_item1_to_cart()
    {
        frame.scrollToElement(Biba_brand_text);
        frame.click(add_chart_first_item  );
    }
    public void add_item2_to_cart()
    {
        frame.scrollToElement(Biba_brand_text);
        frame.click( add_chart_second_item);
    }
    // *********************************************
    public void hover_add_item1_to_cart()
    {
        frame.hover_on_element(hover_first_item);
        frame.click( add_chart_second_item );

    }
    public void hover_add_item2_to_cart()
    {
        frame.hover_on_element(hover_second_item);
        frame.click( add_chart_second_item);

    }
    // *********************************************

    public void continue_shopping()
    {
        frame.click(continue_shopping_button);
    }

    public CartPage view_chart()
    {
        frame.click(view_chart_button);
        return new CartPage(driver);
    }

    public void search_for_item(String item_name)
    {
        frame.sendKeys(search_box_locator,item_name);
    }
    public void search_button_click()
    {
        frame.click(search_button_locator);
    }
    public String verify_searched_products_text()
    {
        return frame.getText(searched_products_text_locator);
    }

    // search for top item methods
    public String verity_item_1_top_product_search()
    {
        return frame.getText(item_1_inSearch_tops_description);
    }
    public String verity_item_2_top_product_search()
    {
        return frame.getText(item_2_inSearch_tops_description);
    }
    public String verity_item_3_top_product_search()
    {
        return frame.getText(item_3_inSearch_tops_description);
    }
    public void add_item1_in_search_to_cart()
    {
        frame.click( add_chart_first_item_tops_search);
    }
    public void add_item2_in_search_to_cart()
    {
        frame.click(add_chart_second_item_tops_search);
    }
    // ***************************************

    public String verify_brand_text_left_side()
    {
        return frame.getText(brand_page_left_text);
    }

    public Polo_BrandPage choose_polo_brand()
    {
        frame.scrollToElement(Biba_brand_text);
        frame.click(polo_brand_text );
        return new Polo_BrandPage(driver);
    }
    public HM_BrandPage choose_HM_brand()
    {
        frame.scrollToElement(Biba_brand_text);
        frame.click( HM_brand_text  );
        return new HM_BrandPage(driver);
    }
    public void choose_Madame_brand()
    {
        frame.scrollToElement(Biba_brand_text);
        frame.click(Madame_brand_text  );
    }
    public void choose_MastHarbour_brand()
    {
        frame.scrollToElement(Biba_brand_text);
        frame.click(MastHarbour_brand_text);
    }

}
