package mwallpach.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

public class Product {

    private static final String[] PRODUCT_CATEGORIES = {"Getränk", "Lebensmittel", "Haushalt", "Elektronik", "Kleidung"};

    private String warehouseID;
    @JsonProperty("productID")
    private String productID;
    private String productName;
    private String productCategory;
    private double productQuantity;

    public Product() {
    }

    public Product(String warehouseID, String productID, String productName, String productCategory, double productQuantity) {
        this.warehouseID = warehouseID;
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
    }

    // Constructor that generates random values
    public Product(String warehouseID) {
        this.warehouseID = warehouseID;
        this.productID = generateRandomProductID();
        this.productName = "Product " + generateRandomNumber();
        this.productCategory = PRODUCT_CATEGORIES[new Random().nextInt(PRODUCT_CATEGORIES.length)];
        this.productQuantity = generateRandomQuantity();
    }

    private static String generateRandomProductID() {
        Random random = new Random();
        return String.format("%02d-%06d", random.nextInt(100), random.nextInt(1000000));
    }

    private static int generateRandomNumber() {
        return new Random().nextInt(1000);
    }

    private static double generateRandomQuantity() {
        return new Random().nextDouble() * 1000; // Zufällige Menge zwischen 0 und 1000
    }

    // Getters and Setters

    @Override
    public String toString() {
        return "Product{" +
                "warehouseID='" + warehouseID + '\'' +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
