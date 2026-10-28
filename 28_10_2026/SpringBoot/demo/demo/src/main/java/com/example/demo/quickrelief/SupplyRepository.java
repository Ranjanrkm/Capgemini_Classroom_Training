package com.example.demo.quickrelief;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class SupplyRepository {

    private final JdbcTemplate jdbcTemplate;

    public SupplyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        initializeTables();
    }

    // Ensures tables exist even if schema.sql auto-init is skipped
    private void initializeTables() {
        jdbcTemplate.execute("""
            CREATE TABLE IF NOT EXISTS supplies (
                id INT AUTO_INCREMENT PRIMARY KEY,
                item_name VARCHAR(100) NOT NULL UNIQUE,
                quantity INT NOT NULL
            )
        """);
        jdbcTemplate.execute("""
            CREATE TABLE IF NOT EXISTS requests (
                id INT AUTO_INCREMENT PRIMARY KEY,
                item_name VARCHAR(100) NOT NULL,
                quantity INT NOT NULL,
                status VARCHAR(50) NOT NULL,
                requested_by VARCHAR(100) NOT NULL
            )
        """);
    }

    // Custom JdbcTemplate RowMapper as required by the challenge
    public static class SupplyRowMapper implements RowMapper<Supply> {
        @Override
        public Supply mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Supply(
                    rs.getInt("id"),
                    rs.getString("item_name"),
                    rs.getInt("quantity")
            );
        }
    }

    public List<Supply> findAll() {
        String sql = "SELECT id, item_name, quantity FROM supplies";
        return jdbcTemplate.query(sql, new SupplyRowMapper());
    }

    public Optional<Supply> findByItemName(String itemName) {
        String sql = "SELECT id, item_name, quantity FROM supplies WHERE LOWER(item_name) = LOWER(?)";
        List<Supply> list = jdbcTemplate.query(sql, new SupplyRowMapper(), itemName);
        return list.stream().findFirst();
    }

    public int insertSupply(String itemName, int quantity) {
        String sql = "INSERT INTO supplies (item_name, quantity) VALUES (?, ?)";
        return jdbcTemplate.update(sql, itemName, quantity);
    }

    public int updateQuantity(String itemName, int newQuantity) {
        String sql = "UPDATE supplies SET quantity = ? WHERE LOWER(item_name) = LOWER(?)";
        return jdbcTemplate.update(sql, newQuantity, itemName);
    }

    public int insertRequest(SupplyRequest request) {
        String sql = "INSERT INTO requests (item_name, quantity, status, requested_by) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                request.getItemName(),
                request.getQuantity(),
                request.getStatus(),
                request.getRequestedBy()
        );
    }
}