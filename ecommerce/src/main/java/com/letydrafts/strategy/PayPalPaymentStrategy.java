package com.letydrafts.strategy;

import com.letydrafts.dao.PaymentDAO;

public class PayPalPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("🌐 Processando pagamento via PayPal...");
        System.out.println("Valor: R$" + amount);

        double feePercent = 0.04;
        double fee = amount * feePercent;

        System.out.println("Taxa aplicada: R$" + fee + " (" + (feePercent * 100) + "%)");
        new PaymentDAO().save("PayPal", amount, fee);
    }
}
