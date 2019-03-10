package com.codeforfood.mapfood.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codeforfood.mapfood.domain.Order;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByClientID(String clientID);

}
