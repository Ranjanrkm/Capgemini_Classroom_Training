
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

class ZoneDateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a time zone (eg. Asia/Tokyo): ");
        String zoneInput = scanner.nextLine();

        try {
            // Use ZoneId.of() instead of getAvailableZoneIds() with parameters
            ZoneId zone = ZoneId.of(zoneInput);
            System.out.println("Time zone: " + zone);

            // Initialize current time for the specified zone
            ZonedDateTime currentTime = ZonedDateTime.now(zone);
            System.out.println("Current date and time: " + currentTime);

        } catch (java.time.DateTimeException e) {
            System.out.println("Invalid time zone! Please enter a valid zone ID.");
        }

        scanner.close();
    }
}