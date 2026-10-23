package Pojo_classes;

/**
 * Represents the test data used to search for a product
 * in the application.
 *
 * This POJO class stores the search term entered into
 * the product search field.
 */
public class ItemInSearch {

    // Stores the product name or search term to be entered.
    private String item;

    /**
     * Initializes the search data with the specified item.
     *
     * @param item_in_search the product name or search term to search for
     */
    public ItemInSearch(String item_in_search) {
        this.item = item_in_search;
    }

    /**
     * Updates the search term stored in this object.
     *
     * @param item the new product name or search term
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * Retrieves the search term stored in this object.
     *
     * @return the product name or search term
     */
    public String getItem() {
        return item;

    }
}