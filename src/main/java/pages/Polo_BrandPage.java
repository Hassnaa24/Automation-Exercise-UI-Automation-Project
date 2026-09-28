package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Polo_BrandPage extends BasePage {


    // ==================== Page Locators ====================

    // Main heading displayed on the selected brand products page.
    private final By brand_product_text_locator =
            By.cssSelector("div[class=\"col-sm-9 padding-right\"] h2[class=\"title text-center\"]");

    // Heading displayed in the Brands section of the left sidebar.
    private final By brand_page_left_text =
            By.cssSelector("div[class=\"col-sm-3\"] div[class=\"brands_products\"]> h2");

    // Link for selecting the Polo brand from the Brands list.
    private final By polo_brand_text =
            By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(1) a span");

    // Link for selecting the H&M brand from the Brands list.
    private final By HM_brand_text =
            By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(2) a span");

    // Link for selecting the Madame brand from the Brands list.
    private final By Madame_brand_text =
            By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(3) a span");

    // Link for selecting the Mast & Harbour brand from the Brands list.
    private final By MastHarbour_brand_text =
            By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(4) a span");

    // Link for selecting the Biba brand from the Brands list.
    private final By Biba_brand_text =
            By.cssSelector("div [class=\"brands_products\"] div ul li:nth-of-type(8) a span");


    // ==================== Constructor ====================

    /**
     * Initializes the Polo Brand Page Object.
     *
     * @param driver WebDriver instance used to interact with the page.
     */
    public Polo_BrandPage(WebDriver driver) {
        super(driver);
    }


    // ==================== Page Verification Methods ====================

    /**
     * Retrieves the heading displayed for the selected brand's products.
     *
     * @return The brand products heading text.
     */
    public String verify_brand_product_text() {
        return frame.getText(brand_product_text_locator);
    }

    /**
     * Retrieves the Brands section heading displayed in the left sidebar.
     *
     * @return The Brands section heading text.
     */
    public String verify_brand_text_left_side() {
        return frame.getText(brand_page_left_text);
    }


    // ==================== Brand Selection Methods ====================

    /**
     * Selects the Polo brand from the Brands list.
     *
     * @return A new Polo Brand Page Object representing the selected brand page.
     */
    public Polo_BrandPage choose_polo_brand() {
        // Scroll the Brands section into view before selecting the brand.
        frame.scrollToElement(Biba_brand_text);

        // Select the Polo brand.
        frame.click(polo_brand_text);

        return new Polo_BrandPage(driver);
    }

    /**
     * Selects the H&M brand from the Brands list.
     *
     * @return A new H&M Brand Page Object representing the selected brand page.
     */
    public HM_BrandPage choose_HM_brand() {
        // Scroll the Brands section into view before selecting the brand.
        frame.scrollToElement(Biba_brand_text);

        // Select the H&M brand.
        frame.click(HM_brand_text);

        return new HM_BrandPage(driver);
    }

    /**
     * Selects the Madame brand from the Brands list.
     */
    public void choose_Madame_brand() {
        // Scroll the Brands section into view before selecting the brand.
        frame.scrollToElement(Biba_brand_text);

        // Select the Madame brand.
        frame.click(Madame_brand_text);
    }

    /**
     * Selects the Mast & Harbour brand from the Brands list.
     */
    public void choose_MastHarbour_brand() {
        // Scroll the Brands section into view before selecting the brand.
        frame.scrollToElement(Biba_brand_text);

        // Select the Mast & Harbour brand.
        frame.click(MastHarbour_brand_text);
    }
}