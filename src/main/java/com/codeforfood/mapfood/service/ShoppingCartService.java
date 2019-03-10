package com.codeforfood.mapfood.service;

import com.codeforfood.mapfood.domain.ShoppingCart;
import com.codeforfood.mapfood.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository repository;

    public List<ShoppingCart> findAll(){
        return repository.findAll();
    }

}
