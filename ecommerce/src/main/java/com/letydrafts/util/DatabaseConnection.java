package com.letydrafts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DatabaseConnection {

        private static DatabaseConnection instance;
        private final Connection connection;

        private final String URL = "jdbc:mysql://localhost:3308/letydrafts";
        private final String USER = "letydrafts";
        private final String PASSWORD = "27092016";

        private DatabaseConnection(){
            try {
                this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e){
                throw new RuntimeException("❌ Erro ao conectar ao banco de dados: " + e.getMessage(), e);
            }
        }

        public static synchronized DatabaseConnection getInstance(){
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }

        public Connection getConnection(){
            return connection;
        }
}
