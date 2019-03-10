package com.codeforfood.mapfood.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "order")
public class Order {
    @Id
    private String id;
    /* The list of items that the client ordered */
    private List<Product> productList;
    private String clientID;
    private String emporiumID;
    private String paymentMethod;
    private Double totalPrice;

    public Order(List<Product> productList, String clientID, String emporiumID, String paymentMethod, Double totalPrice) {
        this.productList = productList;
        this.clientID = clientID;
        this.emporiumID = emporiumID;
        this.paymentMethod = paymentMethod;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }


    public void setEmporiumID(String emporiumID) {
        this.emporiumID = emporiumID;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public String getEmporiumID() {
        return emporiumID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
