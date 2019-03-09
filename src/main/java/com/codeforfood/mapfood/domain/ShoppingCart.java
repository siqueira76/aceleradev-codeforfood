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
    private Map<String, Product> products = new HashMap<>();
    private String emporiumId = "";
    private String paymentMethod = "";
    private double totalPrice;

    public ShoppingCart() { }

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

    public int cartSize() {
        return  this.products.size();
    }

    /**
     * Checkout the client Shopping Cart and generates an Order
     */
    public void checkout() {
        //Instanciate an Order
    }

    public void clearShoppingCart() {
        products.clear();
        emporiumId = "";
        updateCartTotalPrice();
    }

    public double getCartTotalPrice() {
        return this.totalPrice;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public void removeProduct(Product product, int quantity, boolean removeAll) {
        if (removeAll) {
            products.remove(product.getRestaurant_id());
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
        this.totalPrice = productList.stream().mapToDouble(Product::getUnit_price).sum();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
