package com.codeforfood.mapfood.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtos-por-estabelecimento")
public class Product {

    @Id
    private String id;
    private String item_id;
    private String item_description;
    private String restaurant_id;
    private String restaurant;
    private String classification;
    private String address_city;
    private Double unit_price;
    private int    quantity;

    public Product() { }

    public Product(String id, String item_id, String item_description, String restaurant_id, String restaurant, String classification, String address_city, Double unit_price) {
        this.id = id;
        this.item_id = item_id;
        this.item_description = item_description;
        this.restaurant_id = restaurant_id;
        this.restaurant = restaurant;
        this.classification = classification;
        this.address_city = address_city;
        this.unit_price = unit_price;
        this.quantity = 1;
    }

    public void incrementQuantity(int value) {
        if(value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }

        quantity += value;
    }

    public void decrementQuantity(int value) throws  IllegalArgumentException {
        if(value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        if(value > quantity) {
            throw new IllegalArgumentException("Value to be decremented cannot be bigger than the product quantity");
        }

        quantity -= value;
    }

    /* Getters and Setters */
    public int getQuantity() {
        return quantity;
    }

    public String getId() {
        return id;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getItem_description() {
        return item_description;
    }

    public String getRestaurant_id() {
        return restaurant_id;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public String getClassification() {
        return classification;
    }

    public String getAddress_city() {
        return address_city;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }
}
