package com.coworking.ui;

import com.coworking.model.Booking;
import com.coworking.model.RevenueReport;
import com.coworking.model.User;
import com.coworking.model.Workspace;
import com.coworking.service.BookingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleUiRunner implements CommandLineRunner {

    private final BookingService bookingService;

    public ConsoleUiRunner(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("\n==============================================================");
        System.out.println("   CO-WORKING SPACE HOT-DESK BOOKING ENGINE (SPRING JDBC)");
        System.out.println("==============================================================");

        while (running) {
            System.out.println("\n------------------------- MAIN MENU --------------------------");
            System.out.println("1. [FR-1] Register New Workspace");
            System.out.println("2. [FR-1] Onboard New Member (with Prepaid Wallet)");
            System.out.println("3. [FR-2] Check Available Workspaces (by Date & Slot Hour)");
            System.out.println("4. [FR-3] Book a Workspace (Atomic Prepaid Transaction)");
            System.out.println("5. [FR-4] Cancel a Booking & Refund Wallet");
            System.out.println("6. [FR-5] View Revenue Breakdown by Space Type");
            System.out.println("7. View All Workspaces, Members & Bookings");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> handleRegisterWorkspace(scanner);
                    case "2" -> handleOnboardMember(scanner);
                    case "3" -> handleCheckAvailability(scanner);
                    case "4" -> handleBookWorkspace(scanner);
                    case "5" -> handleCancelBooking(scanner);
                    case "6" -> handleRevenueBreakdown();
                    case "7" -> handleViewAllData();
                    case "0" -> {
                        running = false;
                        System.out.println("Exiting Co-Working Booking Engine. Goodbye!");
                    }
                    default -> System.out.println("Invalid option. Please choose between 0 and 7.");
                }
            } catch (Exception e) {
                System.out.println(">> ERROR: " + e.getMessage());
            }
        }
    }

    private void handleRegisterWorkspace(Scanner scanner) {
        System.out.print("Enter Space Name (e.g., Desk-A12, Cabin-2): ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Space Type (HOT_DESK / DEDICATED_DESK / MEETING_ROOM / CABIN): ");
        String type = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter Hourly Rate (Rs.): ");
        BigDecimal rate = new BigDecimal(scanner.nextLine().trim());

        bookingService.registerWorkspace(name, type, rate);
        System.out.println(">> SUCCESS: Workspace '" + name + "' registered!");
    }

    private void handleOnboardMember(Scanner scanner) {
        System.out.print("Enter Member Full Name: ");
        String fullName = scanner.nextLine().trim();

        System.out.print("Enter Member Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Initial Prepaid Wallet Balance (Rs.): ");
        BigDecimal credit = new BigDecimal(scanner.nextLine().trim());

        bookingService.onboardMember(fullName, email, credit);
        System.out.println(">> SUCCESS: Member '" + fullName + "' onboarded with Rs." + credit + "!");
    }

    private void handleCheckAvailability(Scanner scanner) {
        System.out.print("Enter Booking Date (YYYY-MM-DD, e.g., 2026-11-10): ");
        LocalDate date = LocalDate.parse(scanner.nextLine().trim());

        System.out.print("Enter Slot Hour (0-23, e.g., 9 for 09:00-10:00): ");
        int slotHour = Integer.parseInt(scanner.nextLine().trim());

        List<Workspace> available = bookingService.getAvailableWorkspaces(date, slotHour);
        System.out.println("\n--- Available Workspaces on " + date + " at " + String.format("%02d:00", slotHour) + " ---");
        if (available.isEmpty()) {
            System.out.println("No workspaces available for this slot.");
        } else {
            available.forEach(System.out::println);
        }
    }

    private void handleBookWorkspace(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int userId = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter Workspace Space ID: ");
        int spaceId = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter Booking Date (YYYY-MM-DD, e.g., 2026-11-10): ");
        LocalDate date = LocalDate.parse(scanner.nextLine().trim());

        System.out.print("Enter Slot Hour (0-23, e.g., 9 for 09:00-10:00): ");
        int slotHour = Integer.parseInt(scanner.nextLine().trim());

        bookingService.bookWorkspace(userId, spaceId, date, slotHour);
        System.out.println(">> SUCCESS: Booking CONFIRMED and wallet debited atomically!");
    }

    private void handleCancelBooking(Scanner scanner) {
        System.out.print("Enter Booking ID to Cancel: ");
        int bookingId = Integer.parseInt(scanner.nextLine().trim());

        bookingService.cancelBooking(bookingId);
        System.out.println(">> SUCCESS: Booking CANCELLED and cost refunded to member wallet!");
    }

    private void handleRevenueBreakdown() {
        List<RevenueReport> reports = bookingService.getRevenueReport();
        System.out.println("\n--- Revenue Breakdown by Space Type (CONFIRMED Bookings) ---");
        reports.forEach(System.out::println);
    }

    private void handleViewAllData() {
        System.out.println("\n--- ALL WORKSPACES ---");
        bookingService.getAllWorkspaces().forEach(System.out::println);

        System.out.println("\n--- ALL MEMBERS & WALLETS ---");
        bookingService.getAllUsers().forEach(System.out::println);

        System.out.println("\n--- ALL BOOKINGS ---");
        bookingService.getAllBookings().forEach(System.out::println);
    }
}