package Pojo_classes;

/**
 * Represents the payment card test data used during checkout.
 *
 * This POJO class stores the cardholder's name, card number,
 * CVS/CVV security code, and card expiration date.
 */
public class PaymentCardData {

    // Stores the name printed on the payment card.
    private String name_on_card;

    // Stores the payment card number.
    private String card_number;

    // Stores the card security code (commonly called CVV or CVC).
    private String card_cvc;

    // Stores the card expiration month.
    private String card_Expiration_date_month;

    // Stores the card expiration year.
    private String card_Expiration_date_year;

    /**
     * Initializes the payment card data with the provided values.
     *
     * @param name_on_card the cardholder's name
     * @param card_number the payment card number
     * @param card_cvs the card security code
     * @param card_Expiration_date_month the card expiration month
     * @param card_Expiration_date_year the card expiration year
     */
    public PaymentCardData(String name_on_card, String card_number, String card_cvs, String card_Expiration_date_month, String card_Expiration_date_year) {
        this.name_on_card = name_on_card;
        this.card_number = card_number;
        this.card_cvc = card_cvs;
        this.card_Expiration_date_month = card_Expiration_date_month;
        this.card_Expiration_date_year = card_Expiration_date_year;
    }

    // ========================== GETTERS ==========================

    /**
     * Retrieves the cardholder's name.
     *
     * @return the name printed on the card
     */
    public String getName_on_card() {
        return name_on_card;
    }

    /**
     * Retrieves the payment card number.
     *
     * @return the card number
     */
    public String getCard_number() {
        return card_number;
    }

    /**
     * Retrieves the card expiration year.
     *
     * @return the expiration year
     */
    public String getCard_Expiration_date_year() {
        return card_Expiration_date_year;
    }

    /**
     * Retrieves the card expiration month.
     *
     * @return the expiration month
     */
    public String getCard_Expiration_date_month() {
        return card_Expiration_date_month;
    }

    /**
     * Retrieves the card security code.
     *
     * @return the card security code
     */
    public String getCard_cvc() {
        return card_cvc;
    }


    // ========================== SETTERS ==========================

    /**
     * Updates the cardholder's name.
     *
     * @param name_on_card the new cardholder's name
     */
    public void setName_on_card(String name_on_card) {
        this.name_on_card = name_on_card;
    }

    /**
     * Updates the payment card number.
     *
     * @param card_number the new card number
     */
    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    /**
     * Updates the card security code.
     *
     * @param card_cvs the new card security code
     */
    public void setCard_cvs(String card_cvs) {
        this.card_cvc = card_cvs;
    }

    /**
     * Updates the card expiration month.
     *
     * @param card_Expiration_date_month the new expiration month
     */
    public void setCard_Expiration_date_month(String card_Expiration_date_month) {
        this.card_Expiration_date_month = card_Expiration_date_month;
    }

    /**
     * Updates the card expiration year.
     *
     * @param card_Expiration_date_year the new expiration year
     */
    public void setCard_Expiration_date_year(String card_Expiration_date_year) {
        this.card_Expiration_date_year = card_Expiration_date_year;
    }
}