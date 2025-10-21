package com.letydrafts.dao;

import com.letydrafts.models.Cart;
import com.letydrafts.models.Product;
import com.letydrafts.util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    private final Connection connection;

    public CartDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public boolean create(Cart cart) {
        String sql = "INSERT INTO carts (description, total, created_on) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cart.getDescription());
            stmt.setDouble(2, cart.getTotal());
            stmt.setTimestamp(3, Timestamp.valueOf(cart.getCreatedOn()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Cart findById(int id) {
        String sql = "SELECT * FROM carts WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                LocalDateTime createdOn = rs.getTimestamp("created_on").toLocalDateTime();
                Timestamp endedOnTs = rs.getTimestamp("ended_on");
                LocalDateTime endedOn = (endedOnTs != null) ? endedOnTs.toLocalDateTime() : null;

                Cart cart = new Cart(createdOn);
                cart.getProducts().addAll(getProductsFromCart(id));
                return cart;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cart> findAll() {
        List<Cart> carts = new ArrayList<>();
        String sql = "SELECT * FROM carts";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                LocalDateTime createdOn = rs.getTimestamp("created_on").toLocalDateTime();
                Timestamp endedOnTs = rs.getTimestamp("ended_on");
                LocalDateTime endedOn = (endedOnTs != null) ? endedOnTs.toLocalDateTime() : null;

                Cart cart = new Cart(createdOn);
                cart.getProducts().addAll(getProductsFromCart(rs.getInt("id")));
                carts.add(cart);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carts;
    }

    public boolean edit(Cart cart, int cartId) {
        String sql = "UPDATE carts SET total = ?, description = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, cart.getTotal());
            stmt.setString(2, cart.getDescription());
            stmt.setInt(3, cartId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int cartId) {
        String sql = "UPDATE carts SET ended_on = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setInt(2, cartId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<Product> getProductsFromCart(int cartId) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.name, p.price FROM products p " +
                     "JOIN cart_products cp ON cp.product_id = p.id " +
                     "WHERE cp.cart_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cartId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getString("name"), rs.getDouble("price"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}
