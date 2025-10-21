package com.letydrafts.models;

public class Admin extends User {

    public Admin(String email, String name) {
        super(email, name);
    }

    public Boolean createProduct(Product newProduct) {
        if (newProduct == null) return false;
        return true;
    }
}
