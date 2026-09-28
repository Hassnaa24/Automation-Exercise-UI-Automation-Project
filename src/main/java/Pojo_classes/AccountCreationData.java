package Pojo_classes;

/**
 * POJO (Plain Old Java Object) representing the test data
 * required for user account registration.
 *
 * This class is used to deserialize the account_creation_data.json
 * file into a Java object using the Gson library.
 *
 * It stores all registration details required to create a new
 * user account during automated test execution, including:
 * - Personal information
 * - Login credentials
 * - Address information
 * - Contact details
 */

public class AccountCreationData {

    // ===========================
    // Login Information
    // ===========================

    // User email address used during registration
    private String email_address;

    // User full name
    private String name;

    // User password
    private String password;

    // ===========================
    // Date of Birth
    // ===========================

    private String day;
    private String month;
    private String year;

    // ===========================
    // Personal Information
    // ===========================
    private String first_name;
    private String last_name;
    private String company;

    // ===========================
    // Address Information
    // ===========================
    private String address_1;
    private String address_2;
    private String country;
    private String state;
    private String city;
    private String zipcode;

    // Contact number
    private String mobile_number;


    /**
     * Default constructor required by JSON deserialization
     * libraries such as Gson.
     */
    public AccountCreationData() {
    }

    /**
     * Parameterized constructor used to initialize
     * all account registration data.
     *
     * @param email_address User email address.
     * @param name User full name.
     * @param first_name User first name.
     * @param year Birth year.
     * @param month Birth month.
     * @param day Birth day.
     * @param password User password.
     * @param last_name User last name.
     * @param company Company name.
     * @param address_1 Primary address.
     * @param address_2 Secondary address.
     * @param country Country.
     * @param state State or province.
     * @param city City.
     * @param mobile_number Mobile phone number.
     * @param zipcode Postal code.
     */
    public AccountCreationData(String email_address, String name, String first_name, String year, String month, String day, String password, String last_name, String company, String address_1, String address_2, String country, String state, String city, String mobile_number, String zipcode) {
        this.email_address = email_address;
        this.name = name;
        this.first_name = first_name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.password = password;
        this.last_name = last_name;
        this.company = company;
        this.address_1 = address_1;
        this.address_2 = address_2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.mobile_number = mobile_number;
        this.zipcode = zipcode;
    }

    // ===========================
    // Setters
    // ===========================
    // Updates account registration data.

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    // ===========================
    // Getters
    // ===========================
    // Retrieves account registration data.

    public String getEmail_address() {
        return email_address;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getFirst_name() {return first_name;}

    public String getLast_name() {return last_name;}

    public String getCompany() {
        return company;
    }

    public String getAddress_1() {
        return address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getMobile_number() {
        return mobile_number;
    }
}
