package com.sunshine.co.BINI.STORE.Model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Product {
    
    private @Id
    @GeneratedValue Long id;
    private String productName;
    private String description;
    private double price;

    //Constructors
    Product(){}
    
    public Product (String productName, String description, double price) {
        this.productName = productName;
        this.description = description;
        this.price = price;
    }
    //Setters
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }

     //Getters
    public Long getId() {
        return id;
    }
    public String getProductName() {
        return productName;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
}
