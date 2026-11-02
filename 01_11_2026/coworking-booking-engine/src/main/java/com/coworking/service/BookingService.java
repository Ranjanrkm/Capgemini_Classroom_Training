package com.coworking.service;

import com.coworking.dao.BookingDao;
import com.coworking.dao.UserDao;
import com.coworking.dao.WorkspaceDao;
import com.coworking.model.Booking;
import com.coworking.model.RevenueReport;
import com.coworking.model.User;
import com.coworking.model.Workspace;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final WorkspaceDao workspaceDao;
    private final UserDao userDao;
    private final BookingDao bookingDao;

    public BookingService(WorkspaceDao workspaceDao, UserDao userDao, BookingDao bookingDao) {
        this.workspaceDao = workspaceDao;
        this.userDao = userDao;
        this.bookingDao = bookingDao;
    }

    // FR-1: Workspace Onboarding
    public void registerWorkspace(String spaceName, String spaceType, BigDecimal hourlyRate) {
        if (hourlyRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Hourly rate must be greater than 0.");
        }
        workspaceDao.saveWorkspace(spaceName, spaceType.toUpperCase(), hourlyRate);
    }

    // FR-1: Member Onboarding
    public void onboardMember(String fullName, String email, BigDecimal initialCredit) {
        if (initialCredit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial wallet balance cannot be negative.");
        }
        userDao.saveUser(fullName, email, initialCredit);
    }

    // FR-2: Slot Availability Check
    public List<Workspace> getAvailableWorkspaces(LocalDate date, int slotHour) {
        validateSlotHour(slotHour);
        return workspaceDao.findAvailableSpaces(date, slotHour);
    }

    // FR-3: Atomic Prepaid Booking
    @Transactional
    public void bookWorkspace(int userId, int spaceId, LocalDate bookingDate, int slotHour) {
        validateSlotHour(slotHour);

        User user = userDao.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User ID " + userId + " not found."));

        Workspace workspace = workspaceDao.findById(spaceId)
                .orElseThrow(() -> new IllegalArgumentException("Workspace ID " + spaceId + " not found."));

        if (!workspace.isActive()) {
            throw new IllegalStateException("Workspace '" + workspace.getSpaceName() + "' is currently inactive.");
        }

        Optional<Booking> existingBooking = bookingDao.findBySpaceDateAndSlot(spaceId, bookingDate, slotHour);
        if (existingBooking.isPresent() && "CONFIRMED".equalsIgnoreCase(existingBooking.get().getBookingStatus())) {
            throw new IllegalStateException("Collision detected: Workspace is already CONFIRMED for " + bookingDate + " at slot " + slotHour + ":00.");
        }

        BigDecimal cost = workspace.getHourlyRate();
        if (user.getWalletBalance().compareTo(cost) < 0) {
            throw new IllegalStateException(String.format(
                    "Insufficient wallet balance! Required: Rs.%.2f, Available: Rs.%.2f",
                    cost, user.getWalletBalance()));
        }

        // 1. Deduct wallet balance
        BigDecimal updatedBalance = user.getWalletBalance().subtract(cost);
        userDao.updateWalletBalance(userId, updatedBalance);

        // 2. Record confirmed reservation
        if (existingBooking.isPresent()) {
            bookingDao.reactivateCancelledBooking(existingBooking.get().getBookingId(), userId, cost);
        } else {
            bookingDao.createBooking(userId, spaceId, bookingDate, slotHour, cost);
        }
    }

    // FR-4: Booking Cancellation & Wallet Refund
    @Transactional
    public void cancelBooking(int bookingId) {
        Booking booking = bookingDao.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking ID " + bookingId + " not found."));

        if ("CANCELLED".equalsIgnoreCase(booking.getBookingStatus())) {
            throw new IllegalStateException("Booking ID " + bookingId + " is already CANCELLED.");
        }

        if (booking.getBookingDate().isBefore(LocalDate.now())) {
            throw new IllegalStateException("Cannot cancel a past booking (" + booking.getBookingDate() + ").");
        }

        User user = userDao.findById(booking.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found for refund."));

        // 1. Update booking status to CANCELLED
        bookingDao.updateBookingStatus(bookingId, "CANCELLED");

        // 2. Refund reservation cost back to user's wallet
        BigDecimal refundedBalance = user.getWalletBalance().add(booking.getTotalCost());
        userDao.updateWalletBalance(user.getUserId(), refundedBalance);
    }

    // FR-5: Revenue Breakdown by Space Type
    public List<RevenueReport> getRevenueReport() {
        return bookingDao.getRevenueBreakdownBySpaceType();
    }

    public List<Workspace> getAllWorkspaces() {
        return workspaceDao.findAll();
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public List<Booking> getAllBookings() {
        return bookingDao.findAll();
    }

    private void validateSlotHour(int slotHour) {
        if (slotHour < 0 || slotHour > 23) {
            throw new IllegalArgumentException("Slot hour must be between 0 and 23 (24-hour format).");
        }
    }
}