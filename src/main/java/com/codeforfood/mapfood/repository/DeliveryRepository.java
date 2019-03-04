package com.codeforfood.mapfood.repository;


import com.codeforfood.mapfood.domain.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryRepository extends MongoRepository<Delivery, String> {

}

