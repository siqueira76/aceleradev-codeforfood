package com.codeforfood.mapfood.service;

import com.codeforfood.mapfood.domain.ShoppingCart;
import com.codeforfood.mapfood.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository repository;

    public List<ShoppingCart> findAll(){
        return repository.findAll();
    }

    public Optional<ShoppingCart> findByClientID(String clientID) {
        return repository.findByClientID(clientID);
    }

    public ShoppingCart save(ShoppingCart cart) {
        return repository.save(cart);
    }
}
