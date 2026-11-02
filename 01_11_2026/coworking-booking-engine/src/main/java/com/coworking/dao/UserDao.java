package com.coworking.dao;

import com.coworking.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper rowMapper = new UserRowMapper();

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // FR-1: Onboard member with initial wallet credit
    public int saveUser(String fullName, String email, BigDecimal initialWalletBalance) {
        String sql = "INSERT INTO users (full_name, email, wallet_balance) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, fullName, email, initialWalletBalance);
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM users ORDER BY user_id";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Optional<User> findById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        List<User> list = jdbcTemplate.query(sql, rowMapper, userId);
        return list.stream().findFirst();
    }

    // FR-3 & FR-4: Update wallet balance (debit or refund)
    public int updateWalletBalance(int userId, BigDecimal newBalance) {
        String sql = "UPDATE users SET wallet_balance = ? WHERE user_id = ?";
        return jdbcTemplate.update(sql, newBalance, userId);
    }
}