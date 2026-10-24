package com.tns.banking.entities;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Transaction {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    private int transactionID;
    private int accountID;
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(int accountID, String type, double amount) {
        this.transactionID = ID_GENERATOR.getAndIncrement();
        this.accountID = accountID;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public Transaction(int transactionID, int accountID, String type, double amount, LocalDateTime timestamp) {
        this.transactionID = transactionID;
        this.accountID = accountID;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        ID_GENERATOR.updateAndGet(current -> Math.max(current, transactionID + 1));
    }

    public int getTransactionID() { return transactionID; }
    public int getAccountID() { return accountID; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getAmount() { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionID + ", Type: " + type + ", Amount: " + amount + ", Timestamp: " + timestamp;
    }
}