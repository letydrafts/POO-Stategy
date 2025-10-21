package com.letydrafts.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cart {
    private Integer id;
    private ArrayList<Product> products;
    private Double total;
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime endedOn;
    public Object getProducts;

    public Cart(Double total, String description, LocalDateTime createdOn, LocalDateTime endedOn) {
        this.products = new ArrayList<>();
        this.total = total;
        this.description = description;
        this.createdOn = createdOn;
        this.endedOn = endedOn;
    }

    public Cart(LocalDateTime createdOn) {
        this.products = new ArrayList<>();
        this.total = 0.0;
        this.description = "Pending";
        this.createdOn = createdOn;
    }

    public Double getTotal() {
        return total;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getEndedOn() {
        return endedOn;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public Integer getId() {
        return id;
    }
}
