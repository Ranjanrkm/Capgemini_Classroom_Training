package com.coworking.model;

import java.math.BigDecimal;

public class RevenueReport {
    private String spaceType;
    private int confirmedBookingsCount;
    private BigDecimal totalRevenue;

    public RevenueReport(String spaceType, int confirmedBookingsCount, BigDecimal totalRevenue) {
        this.spaceType = spaceType;
        this.confirmedBookingsCount = confirmedBookingsCount;
        this.totalRevenue = totalRevenue;
    }

    public String getSpaceType() { return spaceType; }
    public int getConfirmedBookingsCount() { return confirmedBookingsCount; }
    public BigDecimal getTotalRevenue() { return totalRevenue; }

    @Override
    public String toString() {
        return String.format("Space Type: %-16s | Confirmed Bookings: %-4d | Total Revenue: Rs.%.2f",
                spaceType, confirmedBookingsCount, totalRevenue);
    }
}