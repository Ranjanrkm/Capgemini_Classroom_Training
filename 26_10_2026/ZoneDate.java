
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

class ZoneDate {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("Current ZonedDateTime: " + now); // Uncommented to see output

        Set<String> availableZones = ZoneId.getAvailableZoneIds();
        System.out.println("\nTotal Available Zones: " + availableZones.size());
        
        // Prints all available zones
        availableZones.forEach(System.out::println);
    }
}