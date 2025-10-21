package com.letydrafts.repository;

import com.letydrafts.dao.BankTicketPaymentDAO;
import com.letydrafts.models.BankTicketPayment;

import java.util.List;

public class BankTicketPaymentRepository {

    private final BankTicketPaymentDAO bankTicketPaymentDAO;

    public BankTicketPaymentRepository() {
        this.bankTicketPaymentDAO = new BankTicketPaymentDAO();
    }

    public void create(BankTicketPayment payment) {
        bankTicketPaymentDAO.create(payment);
    }

    public BankTicketPayment findById(int id) {
        return bankTicketPaymentDAO.findById(id);
    }

    public List<BankTicketPayment> findAll() {
        return bankTicketPaymentDAO.findAll();
    }

    public void update(int id, double value) {
        bankTicketPaymentDAO.update(id, value);
    }

    public void deleteById(int id) {
        bankTicketPaymentDAO.deleteById(id);
    }
}
