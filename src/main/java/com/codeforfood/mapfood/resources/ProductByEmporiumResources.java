package com.codeforfood.mapfood.resources;

import com.codeforfood.mapfood.domain.ProductByEmporium;
import com.codeforfood.mapfood.service.ProductByEmporiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductByEmporiumResources {

    @Autowired
    ProductByEmporiumService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProductByEmporium>> findAll(){
        List<ProductByEmporium> productsByEmporium = service.findAll();
        return ResponseEntity.ok().body(productsByEmporium);
    }
}
