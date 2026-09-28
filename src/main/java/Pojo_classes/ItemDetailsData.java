package Pojo_classes;

public class ItemDetailsData {


        private String name;
        private String category;
        private String price;
        private String availability;
        private String condition;
        private String brand;

    public ItemDetailsData(String name, String category, String price, String availability, String condition, String brand) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.availability = availability;
        this.condition = condition;
        this.brand = brand;
    }
// ===== Getters & Setters =====

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getAvailability() {
            return availability;
        }

        public void setAvailability(String availability) {
            this.availability = availability;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }
    }

