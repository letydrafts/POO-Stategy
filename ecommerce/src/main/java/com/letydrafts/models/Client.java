package com.letydrafts.models;


public class Client extends User {

    private Cart cart;

    public Client(String email, String name) {
        super(email, name);
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Boolean AddProductsOnCart(Product newProduct) {
        if (newProduct == null)
            return false;

        return this.cart.getProducts().add(newProduct);
    }

}
