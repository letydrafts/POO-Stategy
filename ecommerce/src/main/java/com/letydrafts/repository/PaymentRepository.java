package com.letydrafts.repository;

import com.letydrafts.strategy.PaymentStrategy;

// Context
public class PaymentRepository {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("Nenhuma estratégia de pagamento definida!");
        }
        strategy.pay(amount);
    }
}
