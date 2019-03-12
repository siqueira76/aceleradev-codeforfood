package com.codeforfood.mapfood.repository;

import org.springframework.data.geo.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.codeforfood.mapfood.domain.Motoboy;

import java.util.List;

public interface MotoboyRepository extends MongoRepository<Motoboy, String> {

    List<Motoboy> findByLocationNear(Point location, Distance distance);
}
