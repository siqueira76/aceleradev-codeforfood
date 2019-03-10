package com.codeforfood.mapfood.resources;

import com.codeforfood.mapfood.domain.Product;
import com.codeforfood.mapfood.service.ProductService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {

    @Autowired
    ProductService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    /*usage example on Postman:
     *http://localhost:8080/products/5c797a2ddabb4f210ea52e6a/decrement_quantity/1*/
    @PostMapping("/{id}/decrement_quantity/{qnt}")
    public ResponseEntity decrementProductStock(@PathVariable String id, @PathVariable int qnt){
        if(service.decrementProductStock(id, qnt)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /*usage example on Postman:
     *http://localhost:8080/products/5c797a2ddabb4f210ea52e6a/increment_quantity/1*/
    @PostMapping("/{id}/increment_quantity/{qnt}")
    public ResponseEntity incrementProductStock(@PathVariable String id, @PathVariable int qnt){
        if(service.incrementProductStock(id, qnt)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /*usage example on Postman:
     *http://localhost:8080/products/total_stocked/5c797a2ddabb4f210ea52e6a*/
    @PostMapping(value = "/total_stocked/{id}", produces = "application/json")
    public String incrementProductStock(@PathVariable String id){
        int qnt = service.retrieveProductStock(id);
        System.out.println(qnt);
        if(qnt > 0){
            return "{\"quantity\" : " + Integer.toString(qnt) + "}";
        }
        return "{\"quantity\" : " + Integer.toString(0) + "}";
    }
}
