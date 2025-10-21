package com.letydrafts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DatabaseConnection {

        private static DatabaseConnection instance;
        private final Connection connection;

    // Postgres container `postgres-rails` is available on 127.0.0.1:5432
    private final String URL = "jdbc:postgresql://127.0.0.1:5432/postgres-rails?connectTimeout=5";
    private final String USER = "postgres";
    private final String PASSWORD = "password";

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
