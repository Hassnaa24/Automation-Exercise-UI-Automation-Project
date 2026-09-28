package Test_cases_search_for_product;

import Pojo_classes.ItemInSearch;
import org.testng.Assert;
import pages.Home_page;
import pages.products_page;
import utilities.helper_Functions;

import java.io.IOException;

/**
 * Provides a reusable business workflow for searching a product
 * on the Automation Exercise website.
 *
 * This workflow performs all prerequisite steps required to reach
 * the search results page, including:
 * - Opening the application.
 * - Navigating to the Products page.
 * - Searching for a product.
 * - Validating that the search results are displayed correctly.
 *
 * The method returns the Products Page object to allow subsequent
 * test steps to continue from the search results.
 */
public class SearchForProduct {
    /**
     * Test data used for the product search.
     * The data is loaded once from the corresponding JSON file.
     */
    private static final ItemInSearch item =
            helper_Functions.read_from_json(
                    "ItemInSearch",
                    ItemInSearch.class);

    /**
     * Executes the complete "Search Product" business scenario.
     *
     * @param homepage Home page object used to start the workflow.
     * @return Products page after successfully performing the search.
     * @throws IOException If capturing screenshots fails.
     */
    public static products_page SearchProduct(Home_page homepage, String url_under_test) throws IOException {

        products_page productsPage;

        // Navigate to the Automation Exercise home page
        homepage.goToUrl(url_under_test);

        // Verify that the Home page is displayed successfully
        String expected_url = "https://automationexercise.com/";
        String actual_url = homepage.getPageUrl();

        helper_Functions.saveScreenshot(
                "search_for_product",
                "Verify that home page is visible successfully");

        Assert.assertEquals(actual_url, expected_url);

        // Navigate to the Products page
        productsPage = homepage.Go_To_products_page_from_homepage();

        // Verify that the Products page is displayed successfully
        String expected_products_page_url =
                "https://automationexercise.com/products";

        String actual_products_page_url =
                productsPage.getPageUrl();

        helper_Functions.saveScreenshot(
                "search_for_product",
                "Verify user is navigated to ALL PRODUCTS page successfully");

        Assert.assertEquals(
                actual_products_page_url,
                expected_products_page_url);

        // Search for the required product
        productsPage.search_for_item(item.getItem());
        productsPage.search_button_click();

        // Verify that the search results section is displayed
        String expected_searched_product_text =
                "SEARCHED PRODUCTS";

        String actual_searched_product_text =
                productsPage.verify_searched_products_text();

        helper_Functions.saveScreenshot(
                "search_for_product",
                "Verify 'SEARCHED PRODUCTS' is visible");

        Assert.assertEquals(
                actual_searched_product_text,
                expected_searched_product_text);

        // Verify that all displayed products match the search keyword
        helper_Functions.saveScreenshot(
                "search_for_product",
                "Verify all the products related to search are visible");

        Assert.assertTrue(
                productsPage.verity_item_1_top_product_search()
                        .contains(item.getItem()));

        Assert.assertTrue(
                productsPage.verity_item_2_top_product_search()
                        .contains(item.getItem()));

        Assert.assertTrue(
                productsPage.verity_item_3_top_product_search()
                        .contains(item.getItem()));

        // Return the Products page to continue the test workflow
        return productsPage;
    }
}
