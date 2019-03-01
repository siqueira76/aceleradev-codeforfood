package com.codeforfood.mapfood.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codeforfood.mapfood.domain.Client;

public interface ClientRepository extends MongoRepository<Client, String> {

}
