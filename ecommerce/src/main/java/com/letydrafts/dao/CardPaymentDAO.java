package com.letydrafts.dao;

import com.letydrafts.models.CardPayment;
import com.letydrafts.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardPaymentDAO {

    private final Connection connection;

    public CardPaymentDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void create(CardPayment payment) {
        String sql = "INSERT INTO card_payments (value) VALUES (?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, payment.getValue());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CardPayment findById(int id) {
        String sql = "SELECT * FROM card_payments WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                CardPayment payment = new CardPayment();
                payment.setValue(rs.getDouble("value"));
                return payment;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CardPayment> findAll() {
        List<CardPayment> payments = new ArrayList<>();
        String sql = "SELECT * FROM card_payments";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CardPayment payment = new CardPayment();
                payment.setValue(rs.getDouble("value"));
                payments.add(payment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payments;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM card_payments WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     public void update(int id, double value) {
        String sql = "UPDATE card_payments SET value = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, value);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}