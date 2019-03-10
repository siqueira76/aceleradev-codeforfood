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

    public boolean decrementProductStock(String id, int val){
        if (this.repository.existsById(id)) {
            Product newProduct = this.repository.findById(id).get();
            try{
                newProduct.decrementQuantity(val);
            }catch (IllegalArgumentException e){
                return false;
            }
            this.repository.save(newProduct);
        }
        return true;
    }

    public boolean incrementProductStock(String id, int val){
        if (this.repository.existsById(id)) {
            Product newProduct = this.repository.findById(id).get();
            try{
                newProduct.incrementQuantity(val);
            }catch (IllegalArgumentException e){
                return false;
            }
            this.repository.save(newProduct);
        }
        return true;
    }

    public int retrieveProductStock(String id){
        if (this.repository.existsById(id)) {
            Product newProduct = this.repository.findById(id).get();
            return newProduct.getQuantity();
        }
        return 0;
    }
}
