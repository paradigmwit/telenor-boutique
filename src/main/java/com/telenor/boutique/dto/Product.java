package com.telenor.boutique.dto;

public class Product {

    private String type;
    private String properties;
    private String price;
    private String storeAddress;

    public Product() {
    }

    public Product(String type, String properties, String price, String store_address) {
        this.type = type;
        this.properties = properties;
        this.price = price;
        this.storeAddress = store_address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
}
