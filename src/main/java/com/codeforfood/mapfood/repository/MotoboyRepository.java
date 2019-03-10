package com.codeforfood.mapfood.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codeforfood.mapfood.domain.Motoboy;

public interface MotoboyRepository extends MongoRepository<Motoboy, String> {

}
