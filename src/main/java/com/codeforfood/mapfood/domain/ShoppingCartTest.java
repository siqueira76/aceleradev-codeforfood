package com.codeforfood.mapfood.domain;

import com.codeforfood.mapfood.exception.ProductNotFoundException;
import com.codeforfood.mapfood.exception.ShoppingCartUniqueEmporiumException;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    public void isValidTest() {
        ShoppingCart cart = new ShoppingCart();

        Product peanuts = new Product("1",
                "id_1",
                "Realy good Peanuts",
                "1",
                "Dominux",
                "food",
                "SP",
                5.00d);

        Product pizza = new Product("2",
                "id_2",
                "Realy good Pizza",
                "1",
                "Dominux",
                "food",
                "SP",
                51.20d);

        Product rice = new Product("3",
                "id_3",
                "Realy good Rice",
                "1",
                "Dominux",
                "food",
                "SP",
                7.00d);

        Product burguer = new Product("4",
                "id_4",
                "Realy good Burguer",
                "2",
                "AppleGezz",
                "food",
                "SP",
                10.00d);

        Product banana = new Product("5",
                "id_5",
                "Realy good Banana",
                "2",
                "AppleGezz",
                "food",
                "SP",
                1.00d);

        cart.addProduct(peanuts, 1);
        cart.addProduct(pizza, 1);
        cart.addProduct(rice, 1);

        assertTrue(cart.getProducts().containsKey(peanuts.getId()));
        assertTrue(cart.getProducts().containsKey(pizza.getId()));
        assertTrue(cart.getProducts().containsKey(rice.getId()));

        assertThrows(ShoppingCartUniqueEmporiumException.class, () -> {
            cart.addProduct(burguer, 1);
        });

        cart.addProduct(peanuts, 1);
        assertEquals(2, cart.getProducts().get(peanuts.getId()).getQuantity());

        cart.removeProduct(peanuts, 1, false);
        assertEquals(1, cart.getProducts().get(peanuts.getId()).getQuantity());

        assertThrows(IllegalArgumentException.class, () -> {
            cart.removeProduct(peanuts, 10, false);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            cart.removeProduct(peanuts, -2, false);
        });

        assertThrows(ProductNotFoundException.class, () -> {
            cart.removeProduct(banana, 1, false);
        });

        assertEquals(63.20d, cart.getCartTotalPrice());

    }
}
