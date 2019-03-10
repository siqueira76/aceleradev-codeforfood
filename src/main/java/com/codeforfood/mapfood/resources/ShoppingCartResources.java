package com.codeforfood.mapfood.resources;

import com.codeforfood.mapfood.domain.ShoppingCart;
import com.codeforfood.mapfood.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shopping-carts")
public class ShoppingCartResources {

    @Autowired
    ShoppingCartService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ShoppingCart>> findAll(){
        List<ShoppingCart> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

}
