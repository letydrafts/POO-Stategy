package com.letydrafts.dao;

import com.letydrafts.models.Admin;
import com.letydrafts.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    private final Connection connection;

    public AdminDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public Admin findById(int id) {
        String sql = "SELECT * FROM admins WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Admin(
                    rs.getString("email"),
                    rs.getString("name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public List<Admin> findAll() {
        List<Admin> admins = new ArrayList<>();
        String sql = "SELECT * FROM admins";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin(
                    rs.getString("email"),
                    rs.getString("name")
                );
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admins;
    }

    public boolean create(Admin admin) {
        String sql = "INSERT INTO admins (email, name) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, admin.getEmail());
            stmt.setString(2, admin.getName());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM admins WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

