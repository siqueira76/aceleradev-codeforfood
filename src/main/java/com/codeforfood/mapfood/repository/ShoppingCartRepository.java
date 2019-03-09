package com.codeforfood.mapfood.repository;

import com.codeforfood.mapfood.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
}
