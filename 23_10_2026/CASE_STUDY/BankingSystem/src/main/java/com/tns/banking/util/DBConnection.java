package com.tns.banking.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String SERVER_URL = "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/banking_db?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "MySQL@2025"; // <-- Change to your MySQL password if different

    private static boolean initialized = false;

    public static Connection getConnection() {
        try {
            if (!initialized) {
                createDatabaseAndTables();
                initialized = true;
            }
            return DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("[DB Error]: " + e.getMessage());
            return null;
        }
    }

    private static void createDatabaseAndTables() {
        try (Connection conn = DriverManager.getConnection(SERVER_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS banking_db");
        } catch (SQLException e) {
            System.out.println("[Warning] Could not create database: " + e.getMessage());
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS customers (
                    customer_id INT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    address VARCHAR(255) NOT NULL,
                    contact VARCHAR(20) NOT NULL
                )
            """);

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS accounts (
                    account_id INT PRIMARY KEY,
                    customer_id INT NOT NULL,
                    type VARCHAR(50) NOT NULL,
                    balance DOUBLE NOT NULL,
                    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
                )
            """);

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS beneficiaries (
                    beneficiary_id INT PRIMARY KEY,
                    customer_id INT NOT NULL,
                    name VARCHAR(100) NOT NULL,
                    account_number VARCHAR(50) NOT NULL,
                    bank_details VARCHAR(150) NOT NULL,
                    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
                )
            """);

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS transactions (
                    transaction_id INT PRIMARY KEY,
                    account_id INT NOT NULL,
                    type VARCHAR(50) NOT NULL,
                    amount DOUBLE NOT NULL,
                    timestamp DATETIME NOT NULL,
                    FOREIGN KEY (account_id) REFERENCES accounts(account_id) ON DELETE CASCADE
                )
            """);
            System.out.println("[SUCCESS] Database 'banking_db' and all tables created successfully!");
        } catch (SQLException e) {
            System.out.println("[Warning] Could not create tables: " + e.getMessage());
        }
    }
}