package com.letydrafts.models;

public class Product {
    private String name;
    private Double price;
    private Integer stock;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
        this.stock = 0;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}
