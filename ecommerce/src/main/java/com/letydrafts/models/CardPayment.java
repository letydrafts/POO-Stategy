package com.letydrafts.models;

import com.letydrafts.models.abstracts.*;

public class CardPayment  extends Payment {

    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    }
}
