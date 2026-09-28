package Pojo_classes;

public class PaymentCardData {

    private String name_on_card;
    private  String card_number;
    private String card_cvs;
    private String card_Expiration_date_month;
    private String card_Expiration_date_year;

    public PaymentCardData(String name_on_card, String card_number, String card_cvs, String card_Expiration_date_month, String card_Expiration_date_year) {
        this.name_on_card = name_on_card;
        this.card_number = card_number;
        this.card_cvs = card_cvs;
        this.card_Expiration_date_month = card_Expiration_date_month;
        this.card_Expiration_date_year = card_Expiration_date_year;
    }

    public String getName_on_card() {
        return name_on_card;
    }

    public String getCard_number() {
        return card_number;
    }

    public String getCard_Expiration_date_year() {
        return card_Expiration_date_year;
    }

    public String getCard_Expiration_date_month() {
        return card_Expiration_date_month;
    }

    public String getCard_cvs() {
        return card_cvs;
    }

    public void setName_on_card(String name_on_card) {
        this.name_on_card = name_on_card;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public void setCard_cvs(String card_cvs) {
        this.card_cvs = card_cvs;
    }

    public void setCard_Expiration_date_month(String card_Expiration_date_month) {
        this.card_Expiration_date_month = card_Expiration_date_month;
    }

    public void setCard_Expiration_date_year(String card_Expiration_date_year) {
        this.card_Expiration_date_year = card_Expiration_date_year;
    }
}
