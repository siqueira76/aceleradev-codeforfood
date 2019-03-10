package com.codeforfood.mapfood.resources;

import com.codeforfood.mapfood.domain.Order;
import com.codeforfood.mapfood.domain.Product;
import com.codeforfood.mapfood.domain.ShoppingCart;
import com.codeforfood.mapfood.exception.ClientShoppingCartAlreadyExistsException;
import com.codeforfood.mapfood.service.OrderService;
import com.codeforfood.mapfood.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/shopping-carts")
public class ShoppingCartResources {

    @Autowired
    ShoppingCartService service;

    @Autowired
    OrderResources orderResources;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ShoppingCart>> findAll(){
        List<ShoppingCart> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{clientID}")
    public ShoppingCart findByClientID(@PathVariable String clientID) {
        return service.findByClientID(clientID).get();
    }


    @PostMapping
    public ShoppingCart save(@RequestBody ShoppingCart cart) {
        Optional<ShoppingCart> clientCart = service.findByClientID(cart.getClientID());

        if(clientCart.isPresent()) {
            throw new ClientShoppingCartAlreadyExistsException("Shopping Cart already defined for the client id: " + cart.getClientID());
        }

        return service.save(cart);
    }

    //TODO: Create a PUT request to update the cart and add an product

    @PostMapping("/checkout/{clientID}/{minTotalPrice}")
    public void checkout(@PathVariable String clientID, @PathVariable double minTotalPrice) {
        Optional<ShoppingCart> clientCart = service.findByClientID(clientID);

        if(!clientCart.isPresent()) {
           throw new IllegalArgumentException("Client Shopping cart doesn't exists");

        }

//        if(clientCart.get().getProducts().size() <= 0) {
//            throw new IllegalArgumentException("The shopping cart must have at least one product. Found: " + clientCart.get().getProducts().size());
//        }

        if(clientCart.get().getCartTotalPrice() < minTotalPrice) {
            throw new IllegalArgumentException("Total price must exceeds a minimum value established by the restaurant: {" + minTotalPrice + "}. Current Total Price: " + clientCart.get().getCartTotalPrice());
        }

        //TODO: Checkout the client shopping cart and generates an order

        List<Product> productList = new ArrayList<>(clientCart.get().getProducts().values());
        System.out.println("PRODUCTs LIST SIZE: " + productList.size());
        Order order = new Order(productList, clientCart.get().getClientID());
        orderResources.save(order);
    }

}
