package com.letydrafts.models;

public class User {
    private String name;
    private String email;

    public User(String email, String name){
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Email: " + this.email;
    }
}
