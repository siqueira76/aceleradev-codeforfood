package com.codeforfood.mapfood.domain;

import com.codeforfood.mapfood.exception.ProductNotFoundException;
import com.codeforfood.mapfood.exception.ShoppingCartUniqueEmporiumException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ShoppingCartTest {
    private ShoppingCart cart;
    private Product peanuts;
    private Product pizza;
    private Product rice;
    private Product burguer;
    private Product banana;


    @Before
    public void init() {
        cart = new ShoppingCart("shopping-cart-id", "client-id");

        peanuts = new Product("1",
                "id_1",
                "Realy good Peanuts",
                "1",
                "Dominux",
                "food",
                "SP",
                5.00d);

        pizza = new Product("2",
                "id_2",
                "Realy good Pizza",
                "1",
                "Dominux",
                "food",
                "SP",
                51.20d);

        rice = new Product("3",
                "id_3",
                "Realy good Rice",
                "1",
                "Dominux",
                "food",
                "SP",
                7.00d);

        burguer = new Product("4",
                "id_4",
                "Realy good Burguer",
                "2",
                "AppleGezz",
                "food",
                "SP",
                10.00d);

        banana = new Product("5",
                "id_5",
                "Realy good Banana",
                "2",
                "AppleGezz",
                "food",
                "SP",
                1.00d);

        cart.addProduct(peanuts, 1);
        cart.addProduct(peanuts, 1);
        cart.addProduct(pizza, 1);
        cart.addProduct(rice, 1);
    }

    @Test
    public void checkTotalPrice()  {
        assertEquals(68.20d, cart.getCartTotalPrice());
    }

    @Test
    public void checkCartContainsProducts()  {
        assertTrue(cart.getProducts().containsKey(peanuts.getId()));
        assertTrue(cart.getProducts().containsKey(pizza.getId()));
        assertTrue(cart.getProducts().containsKey(rice.getId()));
    }

    @Test
    public void checkShoppingCartUniqueEmporiumException() {
        assertThrows(ShoppingCartUniqueEmporiumException.class, () -> cart.addProduct(burguer, 1));
    }

    @Test
    public void checkIfProductIsCorrectlyIncremented() {
        ShoppingCart testCart = cart;
        testCart.addProduct(peanuts, 1);
        assertEquals(2, testCart.getProducts().get(peanuts.getId()).getQuantity());
    }

    @Test
    public void checkIfProductIsCorrectlyDecremented() {
        ShoppingCart testCart = cart;
        testCart.removeProduct(peanuts, 1, false);
        assertEquals(0, testCart.getProducts().get(peanuts.getId()).getQuantity());
    }

    @Test
    public void checkRemoveProductMethodParametersIllegalValues() {
        assertThrows(IllegalArgumentException.class, () -> cart.removeProduct(peanuts, 10, false));

        assertThrows(IllegalArgumentException.class, () -> cart.removeProduct(peanuts, -2, false));

        assertThrows(ProductNotFoundException.class, () -> cart.removeProduct(banana, 1, false));
    }

    @Test
    public void checkIfAllProductIsRemoved() {
        cart.removeProduct(peanuts, 0, true);
        assertFalse(cart.getProducts().containsKey(peanuts.getId()));
    }
}
