package com.codeforfood.mapfood.resources;

import com.codeforfood.mapfood.domain.Order;
import com.codeforfood.mapfood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
public class OrderResources {

    @Autowired
    OrderService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orders = service.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/{clientID}")
    public List<Order> findByClientID(@PathVariable String clientID) {
        return service.findByClientID(clientID);
    }

    public Order save(Order order) {
        return service.save(order);
    }
}
