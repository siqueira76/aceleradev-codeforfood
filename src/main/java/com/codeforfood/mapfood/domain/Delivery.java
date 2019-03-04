package com.codeforfood.mapfood.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "deliveries")
public class Delivery {

    @Id
    private String id;
    private Order order;
    private Motoboy motoboy;
    private Route route;

    public Delivery(String id, Order order, Motoboy motoboy, Route route) {
        this.id = id;
        this.order = order;
        this.motoboy = motoboy;
        this.route = route;
    }

    public String getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Motoboy getMotoboy() {
        return motoboy;
    }

    public Route getRoute() {
        return route;
    }
}
