package com.codeforfood.mapfood.service;

import com.codeforfood.mapfood.domain.Delivery;
import com.codeforfood.mapfood.domain.Motoboy;
import com.codeforfood.mapfood.repository.DeliveryRepository;
import com.codeforfood.mapfood.repository.MotoboyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository repository;

    public List<Delivery> findAll(){
        return repository.findAll();
    }
}
