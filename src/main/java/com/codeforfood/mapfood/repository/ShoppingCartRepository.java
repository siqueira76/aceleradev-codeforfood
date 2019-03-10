package com.codeforfood.mapfood.repository;

import com.codeforfood.mapfood.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

    Optional<ShoppingCart> findByClientID(String clientID);
}
