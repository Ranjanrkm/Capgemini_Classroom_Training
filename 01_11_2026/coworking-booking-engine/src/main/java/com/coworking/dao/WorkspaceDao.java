package com.coworking.dao;

import com.coworking.model.Workspace;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class WorkspaceDao {

    private final JdbcTemplate jdbcTemplate;
    private final WorkspaceRowMapper rowMapper = new WorkspaceRowMapper();

    public WorkspaceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // FR-1: Register workspace
    public int saveWorkspace(String spaceName, String spaceType, BigDecimal hourlyRate) {
        String sql = "INSERT INTO workspaces (space_name, space_type, hourly_rate, is_active) VALUES (?, ?, ?, TRUE)";
        return jdbcTemplate.update(sql, spaceName, spaceType, hourlyRate);
    }

    public List<Workspace> findAll() {
        String sql = "SELECT * FROM workspaces ORDER BY space_id";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Optional<Workspace> findById(int spaceId) {
        String sql = "SELECT * FROM workspaces WHERE space_id = ?";
        List<Workspace> list = jdbcTemplate.query(sql, rowMapper, spaceId);
        return list.stream().findFirst();
    }

    // FR-2: Query unoccupied workspaces for a given date and slot hour
    public List<Workspace> findAvailableSpaces(LocalDate bookingDate, int slotHour) {
        String sql = """
                SELECT * FROM workspaces w
                WHERE w.is_active = TRUE
                  AND w.space_id NOT IN (
                      SELECT b.space_id FROM bookings b
                      WHERE b.booking_date = ?
                        AND b.slot_hour = ?
                        AND b.booking_status = 'CONFIRMED'
                  )
                ORDER BY w.space_id
                """;
        return jdbcTemplate.query(sql, rowMapper, Date.valueOf(bookingDate), slotHour);
    }
}