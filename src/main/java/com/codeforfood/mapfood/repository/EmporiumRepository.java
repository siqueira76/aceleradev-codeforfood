package com.codeforfood.mapfood.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codeforfood.mapfood.domain.Emporium;

public interface EmporiumRepository extends MongoRepository<Emporium, String> {

}
