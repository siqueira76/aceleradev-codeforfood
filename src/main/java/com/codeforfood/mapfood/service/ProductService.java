package com.codeforfood.mapfood.service;

import com.codeforfood.mapfood.domain.Product;
import com.codeforfood.mapfood.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }
}
