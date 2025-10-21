package com.letydrafts.dao;

import com.letydrafts.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDAO {

    public void save(String type, double amount, double fee) {
        String sql = "INSERT INTO payments (type, amount, fee) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, type);
            stmt.setDouble(2, amount);
            stmt.setDouble(3, fee);
            stmt.executeUpdate();

            System.out.println("💾 Pagamento salvo no banco: " + type + " - R$" + amount + " (taxa R$" + fee + ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
