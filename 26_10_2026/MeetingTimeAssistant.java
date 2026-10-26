
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MeetingTimeAssistant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");

        System.out.println("========== MEETING TIME ASSISTANT ==========\n");

        // 1. Gather inputs
        System.out.print("Enter meeting date (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter meeting time (HH:mm): ");
        LocalTime time = LocalTime.parse(scanner.nextLine());

        System.out.print("Enter meeting duration in minutes: ");
        long durationMinutes = Long.parseLong(scanner.nextLine());

        // Calculate start and end date-times
        LocalDateTime startDateTime = LocalDateTime.of(date, time);
        LocalDateTime endDateTime = startDateTime.plusMinutes(durationMinutes);

        int choice;
        // 7. Loop to keep displaying the menu until Exit
        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display meeting date and time");
            System.out.println("2. Display meeting end time");
            System.out.println("3. Display meeting time in another zone");
            System.out.println("4. Check whether the meeting is in the future");
            System.out.println("5. Exit");
            System.out.print("\nEnter choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number (1-5): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume remaining newline

            // 3. Switch statement for menu handling
            switch (choice) {
                case 1:
                    System.out.println("\nMeeting starts at: " + startDateTime.format(formatter));
                    break;

                case 2:
                    System.out.println("\nMeeting starts at: " + startDateTime.format(formatter));
                    System.out.println("Meeting ends at:   " + endDateTime.format(formatter));
                    break;

                case 3:
                    System.out.print("Enter target time zone (e.g., Asia/Tokyo, America/New_York): ");
                    String zoneIdStr = scanner.nextLine();
                    try {
                        ZoneId targetZone = ZoneId.of(zoneIdStr);
                        ZonedDateTime zonedStart = startDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(targetZone);
                        System.out.println("Meeting time in " + targetZone + ": " + zonedStart.format(formatter));
                    } catch (Exception e) {
                        System.out.println("Invalid time zone ID! Please use standard IDs like 'Europe/London' or 'Asia/Kolkata'.");
                    }
                    break;

                case 4:
                    boolean isFuture = startDateTime.isAfter(LocalDateTime.now());
                    if (isFuture) {
                        System.out.println("\nYes, this meeting is scheduled for the future.");
                    } else {
                        System.out.println("\nNo, this meeting is in the past (or currently ongoing).");
                    }
                    break;

                case 5:
                    System.out.println("\nExiting Meeting Time Assistant. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please choose an option between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}