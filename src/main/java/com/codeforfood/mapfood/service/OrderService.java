package com.codeforfood.mapfood.service;

import com.codeforfood.mapfood.domain.Order;
import com.codeforfood.mapfood.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public List<Order> findByClientID(String clientID) {
        return repository.findByClientID(clientID);
    }

    public Order save(Order order) {
        return repository.save(order);
    }



}
