package com.codeforfood.mapfood.repository;

import org.springframework.data.geo.GeoResults;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.codeforfood.mapfood.domain.Motoboy;

import java.awt.*;

public interface MotoboyRepository extends MongoRepository<Motoboy, String> {

    GeoResults<Motoboy> findByLocationNear(Point location);

}
