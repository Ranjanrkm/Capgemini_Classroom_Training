package com.coworking.dao;

import com.coworking.model.Booking;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingRowMapper implements RowMapper<Booking> {
    @Override
    public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Booking(
                rs.getInt("booking_id"),
                rs.getInt("user_id"),
                rs.getInt("space_id"),
                rs.getDate("booking_date").toLocalDate(),
                rs.getInt("slot_hour"),
                rs.getBigDecimal("total_cost"),
                rs.getString("booking_status")
        );
    }
}