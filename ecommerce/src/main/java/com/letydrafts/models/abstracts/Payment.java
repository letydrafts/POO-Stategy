package com.letydrafts.models.abstracts;

public abstract class Payment {
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public abstract void processPayment();
}
