package com.letydrafts.models;

import com.letydrafts.models.abstracts.Payment;

public class BankTicketPayment extends Payment {

    @Override
    public void processPayment() {
        System.out.println("Processing bank ticket payment...");
    }

}
