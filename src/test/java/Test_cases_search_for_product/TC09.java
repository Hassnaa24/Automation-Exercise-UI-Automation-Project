package Test_cases_search_for_product;

import Base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.Home_page;


public class TC09 extends BaseTest {

    @Link(
            name = "Automation Exercise - Test Case 09",
            url = "https://automationexercise.com/test_cases"
    )
    @Epic("Automation Exercise Website")
    @Feature("Products")
    @Story("Search Product")

    @Description("""
Verifies that a user can search for a product successfully.
The test navigates to the Products page, searches for a product,
and verifies that the search results are displayed correctly.
""")

    @Owner("Hassnaa Ibrahim")

    @Severity(SeverityLevel.NORMAL)


    @Test
    public void TC09_Search_Product()   {


        Home_page homepage = new Home_page(driver_under_test);

        Allure.step("Execute the Search Product business workflow", () -> {

            SearchForProduct.SearchProduct(homepage,url_under_test);
        });
    }

}
