CREATE DATABASE IF NOT EXISTS banking_db;
USE banking_db;

CREATE TABLE IF NOT EXISTS customers (
                                         customer_id INT PRIMARY KEY,
                                         name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    contact VARCHAR(20) NOT NULL
    );

CREATE TABLE IF NOT EXISTS accounts (
                                        account_id INT PRIMARY KEY,
                                        customer_id INT NOT NULL,
                                        type VARCHAR(50) NOT NULL,
    balance DOUBLE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS beneficiaries (
                                             beneficiary_id INT PRIMARY KEY,
                                             customer_id INT NOT NULL,
                                             name VARCHAR(100) NOT NULL,
    account_number VARCHAR(50) NOT NULL,
    bank_details VARCHAR(150) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS transactions (
                                            transaction_id INT PRIMARY KEY,
                                            account_id INT NOT NULL,
                                            type VARCHAR(50) NOT NULL,
    amount DOUBLE NOT NULL,
    timestamp DATETIME NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id) ON DELETE CASCADE
    );