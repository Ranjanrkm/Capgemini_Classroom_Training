package com.coworking.model;

import java.math.BigDecimal;

public class User {
    private int userId;
    private String fullName;
    private String email;
    private BigDecimal walletBalance;

    public User() {}

    public User(int userId, String fullName, String email, BigDecimal walletBalance) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.walletBalance = walletBalance;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public BigDecimal getWalletBalance() { return walletBalance; }
    public void setWalletBalance(BigDecimal walletBalance) { this.walletBalance = walletBalance; }

    @Override
    public String toString() {
        return String.format("ID: %-3d | Name: %-18s | Email: %-22s | Wallet: Rs.%.2f",
                userId, fullName, email, walletBalance);
    }
}