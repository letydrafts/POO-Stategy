package com.letydrafts.repository;

import com.letydrafts.dao.CardPaymentDAO;
import com.letydrafts.models.CardPayment;

import java.util.List;

public class CardPaymentRepository {

    private final CardPaymentDAO cardPaymentDAO;

    public CardPaymentRepository() {
        this.cardPaymentDAO = new CardPaymentDAO();
    }

    public void create(CardPayment payment) {
        cardPaymentDAO.create(payment);
    }

    public CardPayment findById(int id) {
        return cardPaymentDAO.findById(id);
    }

    public List<CardPayment> findAll() {
        return cardPaymentDAO.findAll();
    }

    public void update(int id, double value) {
        cardPaymentDAO.update(id, value);
    }

    public void deleteById(int id) {
        cardPaymentDAO.deleteById(id);
    }
}