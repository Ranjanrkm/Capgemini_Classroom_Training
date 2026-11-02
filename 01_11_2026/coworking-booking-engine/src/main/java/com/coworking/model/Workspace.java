package com.coworking.model;

import java.math.BigDecimal;

public class Workspace {
    private int spaceId;
    private String spaceName;
    private String spaceType;
    private BigDecimal hourlyRate;
    private boolean isActive;

    public Workspace() {}

    public Workspace(int spaceId, String spaceName, String spaceType, BigDecimal hourlyRate, boolean isActive) {
        this.spaceId = spaceId;
        this.spaceName = spaceName;
        this.spaceType = spaceType;
        this.hourlyRate = hourlyRate;
        this.isActive = isActive;
    }

    public int getSpaceId() { return spaceId; }
    public void setSpaceId(int spaceId) { this.spaceId = spaceId; }

    public String getSpaceName() { return spaceName; }
    public void setSpaceName(String spaceName) { this.spaceName = spaceName; }

    public String getSpaceType() { return spaceType; }
    public void setSpaceType(String spaceType) { this.spaceType = spaceType; }

    public BigDecimal getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(BigDecimal hourlyRate) { this.hourlyRate = hourlyRate; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    @Override
    public String toString() {
        return String.format("ID: %-3d | Name: %-14s | Type: %-15s | Rate: Rs.%-7.2f | Active: %s",
                spaceId, spaceName, spaceType, hourlyRate, isActive ? "YES" : "NO");
    }
}