package com.coworking.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private int userId;
    private int spaceId;
    private LocalDate bookingDate;
    private int slotHour;
    private BigDecimal totalCost;
    private String bookingStatus;

    public Booking() {}

    public Booking(int bookingId, int userId, int spaceId, LocalDate bookingDate, int slotHour, BigDecimal totalCost, String bookingStatus) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.spaceId = spaceId;
        this.bookingDate = bookingDate;
        this.slotHour = slotHour;
        this.totalCost = totalCost;
        this.bookingStatus = bookingStatus;
    }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getSpaceId() { return spaceId; }
    public void setSpaceId(int spaceId) { this.spaceId = spaceId; }

    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }

    public int getSlotHour() { return slotHour; }
    public void setSlotHour(int slotHour) { this.slotHour = slotHour; }

    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }

    public String getBookingStatus() { return bookingStatus; }
    public void setBookingStatus(String bookingStatus) { this.bookingStatus = bookingStatus; }

    @Override
    public String toString() {
        return String.format("Booking ID: %-3d | User ID: %-3d | Space ID: %-3d | Date: %s | Slot: %02d:00-%02d:00 | Cost: Rs.%-7.2f | Status: %s",
                bookingId, userId, spaceId, bookingDate, slotHour, (slotHour + 1) % 24, totalCost, bookingStatus);
    }
}