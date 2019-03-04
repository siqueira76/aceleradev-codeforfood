package com.codeforfood.mapfood.repository;

import com.codeforfood.mapfood.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
