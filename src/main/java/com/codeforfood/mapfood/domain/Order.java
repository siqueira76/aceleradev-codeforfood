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

    public Order(List<Product> productList, String clientID) {
        this.productList = productList;
        this.clientID = clientID;
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
}
