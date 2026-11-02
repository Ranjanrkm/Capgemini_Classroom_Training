package com.coworking.dao;

import com.coworking.model.Workspace;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkspaceRowMapper implements RowMapper<Workspace> {
    @Override
    public Workspace mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Workspace(
                rs.getInt("space_id"),
                rs.getString("space_name"),
                rs.getString("space_type"),
                rs.getBigDecimal("hourly_rate"),
                rs.getBoolean("is_active")
        );
    }
}