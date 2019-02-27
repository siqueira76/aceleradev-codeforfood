package com.codeforfood.mapfood.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codeforfood.mapfood.domain.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {

}
