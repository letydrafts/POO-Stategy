package com.letydrafts.dao;

import com.letydrafts.models.BankTicketPayment;
import com.letydrafts.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankTicketPaymentDAO {

    private final Connection connection;

    public BankTicketPaymentDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void create(BankTicketPayment payment) {
        String sql = "INSERT INTO bank_ticket_payments (value) VALUES (?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, payment.getValue());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BankTicketPayment findById(int id) {
        String sql = "SELECT * FROM bank_ticket_payments WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                BankTicketPayment payment = new BankTicketPayment();
                payment.setValue(rs.getDouble("value"));
                return payment;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<BankTicketPayment> findAll() {
        List<BankTicketPayment> payments = new ArrayList<>();
        String sql = "SELECT * FROM bank_ticket_payments";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                BankTicketPayment payment = new BankTicketPayment();
                payment.setValue(rs.getDouble("value"));
                payments.add(payment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payments;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM bank_ticket_payments WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     public void update(int id, double value) {
        String sql = "UPDATE bank_ticket_payments SET value = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, value);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
