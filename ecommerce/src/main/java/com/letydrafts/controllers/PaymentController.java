package com.letydrafts.controllers;

import com.letydrafts.repository.PaymentRepository;
import com.letydrafts.strategy.PaymentStrategy;
import com.letydrafts.strategy.CardPaymentStrategy;
import com.letydrafts.strategy.PixPaymentStrategy;
import com.letydrafts.strategy.PayPalPaymentStrategy;
import io.javalin.http.Context;

public class PaymentController {

    private final PaymentRepository repository;

    public PaymentController(PaymentRepository repository) {
        this.repository = repository;
    }

    public void process(Context ctx) {
        String type = ctx.queryParam("tipo");
        String amountStr = ctx.queryParam("amount");

        if (type == null || amountStr == null) {
            ctx.status(400).result("Parâmetros 'tipo' e 'amount' são obrigatórios.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            ctx.status(400).result("'amount' deve ser um número.");
            return;
        }

        PaymentStrategy strategy = createStrategy(type.toLowerCase());

        if (strategy == null) {
            ctx.status(400).result("Tipo de pagamento desconhecido: " + type);
            return;
        }

        repository.setPaymentStrategy(strategy);
        repository.processPayment(amount);

        ctx.status(200).result("Pagamento processado: " + type + " - R$" + amount);
    }

    private PaymentStrategy createStrategy(String type) {
        return switch (type) {
            case "cartao", "cartão", "card" -> new CardPaymentStrategy();
            case "pix" -> new PixPaymentStrategy();
            case "paypal", "payPal", "pay" -> new PayPalPaymentStrategy();
            default -> null;
        };
    }
}
