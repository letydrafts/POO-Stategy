package com.letydrafts.strategy;

import com.letydrafts.dao.PaymentDAO;

public class PixPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("🔹 Processando pagamento com PIX...");
        System.out.println("Valor: R$" + amount);

        double feePercent = 0.01;
        double fee = amount * feePercent;

        System.out.println("Taxa aplicada: R$" + fee + " (" + (feePercent * 100) + "%)");
        new PaymentDAO().save("Pix", amount, fee);
    }
}
