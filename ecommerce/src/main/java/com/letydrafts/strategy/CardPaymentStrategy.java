package com.letydrafts.strategy;

import com.letydrafts.dao.PaymentDAO;

public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("💳 Processando pagamento com Cartão de Crédito...");
        System.out.println("Valor: R$" + amount);

        double feePercent = 0.03;
        double fee = amount * feePercent;

        System.out.println("Taxa aplicada: R$" + fee + " (" + (feePercent * 100) + "%)");
        new PaymentDAO().save("Cartão", amount, fee);
    }
}
