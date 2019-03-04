package com.codeforfood.mapfood.repository;

import com.codeforfood.mapfood.domain.ProductByEmporium;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductByEmporiumRepository extends MongoRepository<ProductByEmporium, String> {
}
