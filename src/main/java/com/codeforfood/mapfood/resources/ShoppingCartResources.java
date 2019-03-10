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

    @PutMapping(value = "/add/{clientID}/{quantity}", produces = "application/json")
    public void addProduct(@PathVariable String clientID, @PathVariable int quantity, @RequestBody Product product) {
        Optional<ShoppingCart> clientCart = service.findByClientID(clientID);

        if(!clientCart.isPresent()) {
            throw new IllegalArgumentException("Shopping Cart not defined for the client id: " + clientID);
        }

        clientCart.get().addProduct(product, quantity);
        service.save(clientCart.get());
    }

    @PutMapping(value = "/remove/{clientID}/{quantity}/{removeAll}", produces = "application/json")
    public void removeProduct(@PathVariable String clientID, @PathVariable int quantity, @PathVariable boolean removeAll, @RequestBody Product product) {
        Optional<ShoppingCart> clientCart = service.findByClientID(clientID);

        if(!clientCart.isPresent()) {
            throw new IllegalArgumentException("Shopping Cart not defined for the client id: " + clientID);
        }

        clientCart.get().removeProduct(product, quantity, removeAll);

        service.save(clientCart.get());
    }

    @PostMapping("/checkout/{clientID}/{minTotalPrice}")
    public void checkout(@PathVariable String clientID, @PathVariable double minTotalPrice) {
        Optional<ShoppingCart> clientCart = service.findByClientID(clientID);

        if(!clientCart.isPresent()) {
           throw new IllegalArgumentException("Client Shopping cart doesn't exists");

        }

        if(clientCart.get().getProducts().size() <= 0) {
            throw new IllegalArgumentException("The shopping cart must have at least one product. Found: " + clientCart.get().getProducts().size());
        }

        if(clientCart.get().getCartTotalPrice() < minTotalPrice) {
            throw new IllegalArgumentException("Total price must exceeds a minimum value established by the restaurant: {" + minTotalPrice + "}. Current Total Price: " + clientCart.get().getCartTotalPrice());
        }

        List<Product> productList = new ArrayList<>(clientCart.get().getProducts().values());
        Order order = new Order(
                productList,
                clientCart.get().getClientID(),
                clientCart.get().getEmporiumId(),
                clientCart.get().getPaymentMethod(),
                clientCart.get().getTotalPrice()
        );
        orderResources.save(order);

        // Clear the client's shopping cart
        clientCart.get().clearShoppingCart();
        service.save(clientCart.get());
    }

}
