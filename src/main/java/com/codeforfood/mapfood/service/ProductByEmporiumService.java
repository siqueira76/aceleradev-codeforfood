package com.codeforfood.mapfood.service;

import com.codeforfood.mapfood.domain.ProductByEmporium;
import com.codeforfood.mapfood.repository.ProductByEmporiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductByEmporiumService {

    @Autowired
    ProductByEmporiumRepository repository;

    public List<ProductByEmporium> findAll(){
        return repository.findAll();
    }
}
