
import java.time.LocalDateTime;

class Customdate {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date and Time: " + now);

        LocalDateTime customDate = LocalDateTime.parse("2026-10-26T13:48");
        System.out.println("Parsed Custom Date and Time: " + customDate);
    }
}