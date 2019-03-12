package com.codeforfood.mapfood.resources;

import com.codeforfood.mapfood.domain.*;
import com.codeforfood.mapfood.service.ClientService;
import com.codeforfood.mapfood.service.EmporiumService;
import com.codeforfood.mapfood.service.MotoboyService;
import com.codeforfood.mapfood.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/order")
public class OrderResources {

    @Autowired
    OrderService service;

    @Autowired
    EmporiumService emporiumService;

    @Autowired
    ClientService clientService;

    @Autowired
    MotoboyService motoboyService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orders = service.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/{clientID}")
    public List<Order> findByClientID(@PathVariable String clientID) {
        return service.findByClientID(clientID);
    }

    public void save(Order order) {
        service.save(order);

        // TODO: Call and instanciate the Delivery

/*
        Client client = clientService.findById(order.getClientID());
        Emporium emporium = emporiumService.findById(order.getEmporiumID());

        List<Motoboy> motoboys = motoboyService.findByLocationNear(
                new Point(emporium.getLatitude(), emporium.getLongitude()),
                new Distance(5, Metrics.KILOMETERS)
        );

        System.out.println("MOTOBOYS FOUND: " + motoboys.size());
        for (Motoboy motoboy : motoboys) {
            System.out.println(motoboy.toString());
        }

        // Route route = new Route(motoboy.position, restaurant.position, cliente.position);

*/
    }
}
