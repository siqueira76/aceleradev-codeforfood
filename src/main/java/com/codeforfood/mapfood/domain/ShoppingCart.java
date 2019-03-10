package com.codeforfood.mapfood.domain;

import com.codeforfood.mapfood.exception.ProductNotFoundException;
import com.codeforfood.mapfood.exception.ShoppingCartUniqueEmporiumException;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "shopping-carts")
public class ShoppingCart {

    @Id
    private String id;
    private String clientID;
    private Map<String, Product> products;
    private String emporiumId;
    private String paymentMethod;
    private double totalPrice;

    public ShoppingCart(String id, String clientID) {
        this.id = id;
        this.clientID = clientID;
        this.products = new HashMap<>();
        this.emporiumId = "";
        this.paymentMethod = "";
    }

    /**
     * Add a product to the shopping cart. If the product is already present, increment it's quantity.
     * @param product The product selected by the user to add to the shopping cart
     * @param quantity The quantity to add to the shopping cart
     * @throws ShoppingCartUniqueEmporiumException if the user tries to add an item from a different Emporium
     */
    public void addProduct(Product product, int quantity) {
        if(!products.isEmpty()) {
            if(!product.getRestaurant_id().equals(emporiumId)) {
                throw new ShoppingCartUniqueEmporiumException("It's not possible to add products from different emporiums in a single Shopping Cart");
            }
            if(!products.containsKey(product.getId())) {
                products.put(product.getId(), product);

            } else {
                Product currentProduct = products.get(product.getId());
                currentProduct.incrementQuantity(quantity);

                // Update the product in the Hashmap
                products.replace(product.getId(), currentProduct);
            }

        } else {
            products.put(product.getId(), product);
            emporiumId = product.getRestaurant_id();
        }

        updateCartTotalPrice();
    }

    /**
     * @return The shopping cart size representing the total of unique products products
     */
    public int cartSize() {
        return  this.products.size();
    }

    /**
     * Checkout the client Shopping Cart and generates an Order
     */
    public void checkout() {
        //TODO: Instanciate an Order
    }

    /**
     * Clear all the products from the shopping cart, the unique emporium ID and update the cart total price
     */
    public void clearShoppingCart() {
        products.clear();
        emporiumId = "";
        updateCartTotalPrice();
    }

    /**
     * @return The total price that represents the sums of all products unit_price multiplied by its quantity
     */
    public double getCartTotalPrice() {
        return this.totalPrice;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    /**
     * Remove a product from the shopping cart. If the product is already present, decrement it's quantity.
     * @param product The product selected by the user to remove from the shopping cart
     * @param quantity The quantity to be decremented from the shopping cart
     * @param removeAll If true, remove all the product quantities from the shopping cart
     * @throws ProductNotFoundException if the user tries to decrement an item that don't exists
     */
    public void removeProduct(Product product, int quantity, boolean removeAll) {
        if (removeAll) {
            products.remove(product.getId());
        } else {
            if(!products.containsKey(product.getId()))
                throw new ProductNotFoundException("Cannot remove product unit: Product Not found in the Shopping Cart");

            Product currentProduct = products.get(product.getId());
            currentProduct.decrementQuantity(quantity);

            // Update the product in the Hashmap
            products.replace(product.getId(), currentProduct);
        }

        updateCartTotalPrice();
    }

    private void updateCartTotalPrice() {
        List<Product> productList = new ArrayList<>(products.values());
        this.totalPrice = productList.stream().mapToDouble(product -> product.getUnit_price() * product.getQuantity()).sum();
    }


    /* Getters and Setters */
    public String getId() {
        return id;
    }

    public String getClientID() {
        return clientID;
    }

    public String getEmporiumId() {
        return emporiumId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    public void setEmporiumId(String emporiumId) {
        this.emporiumId = emporiumId;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
