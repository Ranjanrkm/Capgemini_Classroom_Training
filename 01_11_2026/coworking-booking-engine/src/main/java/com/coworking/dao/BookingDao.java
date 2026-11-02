package com.coworking.dao;

import com.coworking.model.Booking;
import com.coworking.model.RevenueReport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class BookingDao {

    private final JdbcTemplate jdbcTemplate;
    private final BookingRowMapper rowMapper = new BookingRowMapper();

    public BookingDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Booking> findBySpaceDateAndSlot(int spaceId, LocalDate bookingDate, int slotHour) {
        String sql = "SELECT * FROM bookings WHERE space_id = ? AND booking_date = ? AND slot_hour = ?";
        List<Booking> list = jdbcTemplate.query(sql, rowMapper, spaceId, Date.valueOf(bookingDate), slotHour);
        return list.stream().findFirst();
    }

    // FR-3: Create confirmed reservation
    public int createBooking(int userId, int spaceId, LocalDate bookingDate, int slotHour, BigDecimal totalCost) {
        String sql = """
                INSERT INTO bookings (user_id, space_id, booking_date, slot_hour, total_cost, booking_status)
                VALUES (?, ?, ?, ?, ?, 'CONFIRMED')
                """;
        return jdbcTemplate.update(sql, userId, spaceId, Date.valueOf(bookingDate), slotHour, totalCost);
    }

    // Reactivate a previously cancelled slot if rebooked
    public int reactivateCancelledBooking(int bookingId, int userId, BigDecimal totalCost) {
        String sql = "UPDATE bookings SET user_id = ?, total_cost = ?, booking_status = 'CONFIRMED' WHERE booking_id = ?";
        return jdbcTemplate.update(sql, userId, totalCost, bookingId);
    }

    public Optional<Booking> findById(int bookingId) {
        String sql = "SELECT * FROM bookings WHERE booking_id = ?";
        List<Booking> list = jdbcTemplate.query(sql, rowMapper, bookingId);
        return list.stream().findFirst();
    }

    public List<Booking> findAll() {
        String sql = "SELECT * FROM bookings ORDER BY booking_date DESC, slot_hour ASC";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // FR-4: Update status to CANCELLED
    public int updateBookingStatus(int bookingId, String status) {
        String sql = "UPDATE bookings SET booking_status = ? WHERE booking_id = ?";
        return jdbcTemplate.update(sql, status, bookingId);
    }

    // FR-5: SQL aggregate query for revenue breakdown by space type
    public List<RevenueReport> getRevenueBreakdownBySpaceType() {
        String sql = """
                SELECT w.space_type,
                       COUNT(b.booking_id) AS confirmed_count,
                       COALESCE(SUM(b.total_cost), 0.00) AS total_revenue
                FROM workspaces w
                LEFT JOIN bookings b
                       ON w.space_id = b.space_id AND b.booking_status = 'CONFIRMED'
                GROUP BY w.space_type
                ORDER BY total_revenue DESC
                """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> new RevenueReport(
                rs.getString("space_type"),
                rs.getInt("confirmed_count"),
                rs.getBigDecimal("total_revenue")
        ));
    }
}