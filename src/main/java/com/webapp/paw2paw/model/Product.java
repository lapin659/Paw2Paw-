package com.webapp.paw2paw.model;

public class Product {
    private String productId;
    private String productName;
    private String description;
    private double price;
    private String seller;

    public Product(String productId, String productName, String description, double price, String seller) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.seller = seller;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
