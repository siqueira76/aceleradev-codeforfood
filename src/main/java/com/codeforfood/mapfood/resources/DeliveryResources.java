package com.codeforfood.mapfood.resources;

import com.codeforfood.mapfood.Integration.Maplink;
import com.codeforfood.mapfood.domain.Delivery;
import com.codeforfood.mapfood.domain.Motoboy;
import com.codeforfood.mapfood.domain.Position;
import com.codeforfood.mapfood.domain.Route;
import com.codeforfood.mapfood.exception.AlreadyWaitingForProblemSolutionException;
import com.codeforfood.mapfood.service.DeliveryService;
import com.codeforfood.mapfood.service.MotoboyService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliveryResources {

    Maplink maplink;

    @Autowired
    DeliveryService service;

    @GetMapping()
    public ResponseEntity<List<Delivery>> findAll(){
        List<Delivery> deliveries = service.findAll();
        return ResponseEntity.ok().body(deliveries);
    }

    @GetMapping("/trajectory")
    public ResponseEntity<ResponseEntity<?>> trajectory() throws JSONException {

        Position initial = new Position(-4.00, 1.00);
        Position middle = new Position(-4.00, 1.00);
        Position target = new Position(-4.00, 1.00);

        Route route = new Route(initial, target, middle);

        maplink = new Maplink(route);

        ResponseEntity<?> response = maplink.requestTrajectory();
        return ResponseEntity.ok().body(response);
    }

//    @GetMapping("callback")
//    public ResponseEntity<?> callback() {
//
//    }
}
