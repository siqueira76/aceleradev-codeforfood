package com.codeforfood.mapfood.resources;

import com.codeforfood.mapfood.domain.Delivery;
import com.codeforfood.mapfood.domain.Motoboy;
import com.codeforfood.mapfood.service.DeliveryService;
import com.codeforfood.mapfood.service.MotoboyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliveryResources {

    @Autowired
    DeliveryService service;

    @GetMapping()
    public ResponseEntity<List<Delivery>> findAll(){
        List<Delivery> deliveries = service.findAll();
        return ResponseEntity.ok().body(deliveries);
    }
}
