package com.tns.banking.services;

import com.tns.banking.entities.Account;
import com.tns.banking.entities.Beneficiary;
import com.tns.banking.entities.Customer;
import com.tns.banking.entities.Transaction;
import com.tns.banking.enums.AccountType;
import com.tns.banking.util.DBConnection;

import java.sql.*;
import java.util.*;

public class BankingServiceImpl implements BankingService {
    private Map<Integer, Customer> customers = new HashMap<>();
    private Map<Integer, Account> accounts = new HashMap<>();
    private Map<Integer, Transaction> transactions = new HashMap<>();
    private Map<Integer, Beneficiary> beneficiaries = new HashMap<>();

    public BankingServiceImpl() { loadFromDatabase(); }

    private void loadFromDatabase() {
        Connection conn = DBConnection.getConnection();
        if (conn == null) return;
        try (conn) {
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM customers")) {
                while (rs.next()) customers.put(rs.getInt("customer_id"), new Customer(rs.getInt("customer_id"), rs.getString("name"), rs.getString("address"), rs.getString("contact")));
            }
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM accounts")) {
                while (rs.next()) accounts.put(rs.getInt("account_id"), new Account(rs.getInt("account_id"), rs.getInt("customer_id"), rs.getString("type"), rs.getDouble("balance")));
            }
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM beneficiaries")) {
                while (rs.next()) beneficiaries.put(rs.getInt("beneficiary_id"), new Beneficiary(rs.getInt("beneficiary_id"), rs.getInt("customer_id"), rs.getString("name"), rs.getString("account_number"), rs.getString("bank_details")));
            }
            try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM transactions ORDER BY transaction_id ASC")) {
                while (rs.next()) transactions.put(rs.getInt("transaction_id"), new Transaction(rs.getInt("transaction_id"), rs.getInt("account_id"), rs.getString("type"), rs.getDouble("amount"), rs.getTimestamp("timestamp").toLocalDateTime()));
            }
        } catch (SQLException e) { System.out.println("[WARN] DB Load: " + e.getMessage()); }
    }

    @Override
    public void addCustomer(Customer c) {
        customers.put(c.getCustomerID(), c);
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            try (conn; PreparedStatement ps = conn.prepareStatement("INSERT INTO customers VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE name=VALUES(name)")) {
                ps.setInt(1, c.getCustomerID()); ps.setString(2, c.getName()); ps.setString(3, c.getAddress()); ps.setString(4, c.getContact());
                ps.executeUpdate();
            } catch (SQLException e) { System.out.println("[DB Error]: " + e.getMessage()); }
        }
    }

    @Override
    public void addAccount(Account a) {
        a.setType(AccountType.normalize(a.getType()));
        accounts.put(a.getAccountID(), a);
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            try (conn; PreparedStatement ps = conn.prepareStatement("INSERT INTO accounts VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE balance=VALUES(balance)")) {
                ps.setInt(1, a.getAccountID()); ps.setInt(2, a.getCustomerID()); ps.setString(3, a.getType()); ps.setDouble(4, a.getBalance());
                ps.executeUpdate();
            } catch (SQLException e) { System.out.println("[DB Error]: " + e.getMessage()); }
        }
    }

    @Override
    public void addTransaction(Transaction t) {
        Account acc = accounts.get(t.getAccountID());
        if (acc == null) return;
        double newBal = t.getType().equalsIgnoreCase("Deposit") ? acc.getBalance() + t.getAmount() : acc.getBalance() - t.getAmount();
        acc.setBalance(newBal);
        transactions.put(t.getTransactionID(), t);
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            try (conn) {
                conn.setAutoCommit(false);
                try (PreparedStatement ps1 = conn.prepareStatement("UPDATE accounts SET balance = ? WHERE account_id = ?");
                     PreparedStatement ps2 = conn.prepareStatement("INSERT INTO transactions VALUES (?, ?, ?, ?, ?)")) {
                    ps1.setDouble(1, newBal); ps1.setInt(2, acc.getAccountID()); ps1.executeUpdate();
                    ps2.setInt(1, t.getTransactionID()); ps2.setInt(2, t.getAccountID()); ps2.setString(3, t.getType()); ps2.setDouble(4, t.getAmount()); ps2.setTimestamp(5, Timestamp.valueOf(t.getTimestamp())); ps2.executeUpdate();
                    conn.commit();
                } catch (SQLException ex) { conn.rollback(); }
            } catch (SQLException e) { System.out.println("[DB Error]: " + e.getMessage()); }
        }
    }

    @Override
    public void addBeneficiary(Beneficiary b) {
        beneficiaries.put(b.getBeneficiaryID(), b);
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            try (conn; PreparedStatement ps = conn.prepareStatement("INSERT INTO beneficiaries VALUES (?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE name=VALUES(name)")) {
                ps.setInt(1, b.getBeneficiaryID()); ps.setInt(2, b.getCustomerID()); ps.setString(3, b.getName()); ps.setString(4, b.getAccountNumber()); ps.setString(5, b.getBankDetails());
                ps.executeUpdate();
            } catch (SQLException e) { System.out.println("[DB Error]: " + e.getMessage()); }
        }
    }

    @Override public Customer findCustomerById(int id) { return customers.get(id); }
    @Override public Account findAccountById(int id) { return accounts.get(id); }
    @Override public Transaction findTransactionById(int id) { return transactions.get(id); }
    @Override public Beneficiary findBeneficiaryById(int id) { return beneficiaries.get(id); }
    @Override public Collection<Account> getAllAccounts() { return accounts.values(); }
    @Override public Collection<Customer> getAllCustomers() { return customers.values(); }
    @Override public Collection<Transaction> getAllTransactions() { return transactions.values(); }
    @Override public Collection<Beneficiary> getAllBeneficiaries() { return beneficiaries.values(); }

    @Override
    public List<Account> getAccountsByCustomerId(int cid) {
        List<Account> res = new ArrayList<>();
        for (Account a : accounts.values()) if (a.getCustomerID() == cid) res.add(a);
        return res;
    }

    @Override
    public List<Transaction> getTransactionsByAccountId(int aid) {
        List<Transaction> res = new ArrayList<>();
        for (Transaction t : transactions.values()) if (t.getAccountID() == aid) res.add(t);
        return res;
    }

    @Override
    public List<Beneficiary> getBeneficiariesByCustomerId(int cid) {
        List<Beneficiary> res = new ArrayList<>();
        for (Beneficiary b : beneficiaries.values()) if (b.getCustomerID() == cid) res.add(b);
        return res;
    }

    @Override
    public boolean transferFunds(int fromId, int toId, double amount) {
        Account s = accounts.get(fromId), r = accounts.get(toId);
        if (s == null || r == null || s.getBalance() < amount) return false;
        addTransaction(new Transaction(fromId, "Withdrawal", amount));
        addTransaction(new Transaction(toId, "Deposit", amount));
        return true;
    }

    @Override
    public double calculateAnnualInterest(int aid) {
        Account a = accounts.get(aid);
        return (a != null && a.getType().equalsIgnoreCase("Saving")) ? a.getBalance() * 0.045 : 0.0;
    }
}