package Pojo_classes;

/**
 * Represents the details of a product displayed on the product details page.
 *
 * This POJO class stores product information, including its name, category,
 * price, availability, condition, and brand.
 */
public class ItemDetailsData {

    // Stores the name of the product.
    private String name;

    // Stores the category to which the product belongs.
    private String category;

    // Stores the displayed price of the product.
    private String price;

    // Stores the availability status of the product.
    private String availability;

    // Stores the condition of the product.
    private String condition;

    // Stores the brand associated with the product.
    private String brand;

    /**
     * Initializes the product details with the provided values.
     *
     * @param name the name of the product
     * @param category the category of the product
     * @param price the displayed price of the product
     * @param availability the availability status of the product
     * @param condition the condition of the product
     * @param brand the brand of the product
     */
    public ItemDetailsData(String name, String category, String price, String availability, String condition, String brand) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.availability = availability;
        this.condition = condition;
        this.brand = brand;
    }

    // ========================== GETTERS AND SETTERS ==========================

    /**
     * Retrieves the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the product name.
     *
     * @param name the new product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the product category.
     *
     * @return the product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Updates the product category.
     *
     * @param category the new product category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Retrieves the product price.
     *
     * @return the product price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Updates the product price.
     *
     * @param price the new product price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Retrieves the product availability status.
     *
     * @return the product availability status
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * Updates the product availability status.
     *
     * @param availability the new availability status
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     * Retrieves the product condition.
     *
     * @return the product condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Updates the product condition.
     *
     * @param condition the new product condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * Retrieves the product brand.
     *
     * @return the product brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Updates the product brand.
     *
     * @param brand the new product brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
}