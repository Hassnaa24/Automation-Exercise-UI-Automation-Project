package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Framework;

public class Home_page extends BasePage {
   private final WebDriver driver;
   private final Framework frame;

    // ********************************** locators ********************************************************************

    private final By item1_locator_view_details_button  = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2) div[class=\"choose\"] a i");
    private final By item1_locator                      = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2)");
    private final By item1_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(2)  a[data-product-id=\"1\"]");
    private final By item2_locator_add_to_chart_button = By.cssSelector("div[class=\"features_items\"] div[class=\"col-sm-4\"]:nth-of-type(3)  a[data-product-id=\"2\"]");

    private final  By continue_shopping_button   = By.cssSelector("div[class=\"modal-content\"] div[class=\"modal-footer\"] button");
    private final  By view_chart_button          = By.cssSelector("div[class=\"modal-content\"] div[class=\"modal-body\"] p a");

    private final By item_locator_view_chart_button   = By.cssSelector("div[class=\"modal-content\"] a");

    private final By recommended_item_scroll_locator      = By.cssSelector("div#recommended-item-carousel");
    private final By recommended_item_text                = By.cssSelector("div[class=\"recommended_items\"] h2[class=\"title text-center\"]");

    private final By recommended_item_2_add_chart_locator = By.cssSelector("div#recommended-item-carousel[class=\"carousel slide\"] div[class=\"single-products\"] a[data-product-id=\"2\"]");

    private final By category_page_left_text     = By.cssSelector("div[class=\"col-sm-3\"] div[class=\"left-sidebar\"]> h2");
    private final By brand_page_left_text        = By.cssSelector("div[class=\"col-sm-3\"] div[class=\"brands_products\"]> h2");

    private final By women_category_slider       = By.cssSelector("div#accordian div[class=\"panel panel-default\"]:nth-of-type(1) span>i");
    private final By women_dress_category_button = By.cssSelector("div#Women ul>li:nth-of-type(1) a");
    private final By women_tops_category_button  = By.cssSelector("div#Women ul>li:nth-of-type(2) a");

    private final By men_category_slider        = By.cssSelector("div#accordian div[class=\"panel panel-default\"]:nth-of-type(2) span>i");
    private final By men_tshirt_category_button = By.cssSelector("div#Men ul>li:nth-of-type(1) a");

    private final By kids_category_slider       = By.cssSelector("div#accordian div[class=\"panel panel-default\"]:nth-of-type(3) span>i");
    private final By kids_dress_category_button = By.cssSelector("div#Kids ul>li:nth-of-type(1)");


   // constructor
    public Home_page(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        frame=new Framework(driver);
    }
    //   ************************************* methods ***************************************************

    // navigation from home page to product page
    public products_page Go_To_products_page_from_homepage()
    {
        frame.click(products_button) ;
       return new products_page(driver);
    }
   //   ************************************************************************************************
    public CartPage Go_To_cart_page_from_homepage()
    {
      frame.click(cart_button ) ;
      return new CartPage(driver);
    }
    //   ************************************************************************************************
    public LoginPage Go_To_signup_login_page()
     {
         frame.click(signup_login_button);
         return new LoginPage(driver);
     }
    //   ************************************************************************************************
    public TestCases_page Go_To_testcase_page()
    {
        frame.click(testCases_button);
        return new TestCases_page(driver);
    }
    //   ************************************************************************************************
    public ContactUsPage Go_To_contactus_page_from_homepage()
    {
        frame.click(contactUs_button);
        return new ContactUsPage(driver);
    }

    //   ************************************************************************************************
    public itemDetailsPage go_to_item_details_page()
    {
        frame.scrollToElement(item1_locator);
        frame.click(item1_locator_view_details_button);
        return new itemDetailsPage(driver);
    }
    //   ************************************************************************************************
    public CartPage go_to_item_cart()
    {
        frame.scrollToElement(item1_locator);
        frame.click(item1_locator_add_to_chart_button);
        frame.click(item_locator_view_chart_button);
        return new CartPage(driver);
    }
    //   ************************************************************************************************
    public void add_items_to_cart()
    {
       // frame.hover_on_element(item1_locator);
        frame.click(item1_locator_add_to_chart_button);
        frame.click(continue_shopping_button);
        frame.click(item2_locator_add_to_chart_button);
        frame.click(continue_shopping_button);

    }
    //   ************************************************************************************************
    public CartPage go_to_recommended_item_to_cart()
    {
       scroll_to_recommended_item();
       frame.click(recommended_item_2_add_chart_locator);
       frame.click(item_locator_view_chart_button);
        return new CartPage(driver);
    }

    public void scroll_to_recommended_item()
    {
        frame.scrollToElement(recommended_item_scroll_locator);
    }

    public String verify_recommended_item_text()
    {
        return  frame.getText(recommended_item_text);
    }

    // left side ************** Methods ***********************************************

    public String verify_category_text()
    {
        return frame.getText( category_page_left_text);
    }

    // women category
    public void choose_women_category()
    {
        frame.scrollToElement(brand_page_left_text );
        frame.click(women_category_slider);
    }
    public CategoryWomenDressPage choose_women_dress_category()
    {
        frame.click(women_dress_category_button);
       return new CategoryWomenDressPage(driver);
    }
    public CategoryWomenDressPage choose_women_tops_category()
    {
        frame.click(women_tops_category_button);
        return new CategoryWomenDressPage(driver);
    }

    // men category
    public void choose_men_category()
    {
        frame.scrollToElement(brand_page_left_text );
        frame.click(men_category_slider);
    }
    public CategoryMenTshirtPage choose_men_Tshirt_category()
    {
        frame.click(men_tshirt_category_button);
        return new CategoryMenTshirtPage(driver);
    }




}
