
import java.time.LocalDate;
import java.time.Month;

class dateTime {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        // Custom date example
        LocalDate customDate = LocalDate.of(2026, 12, 31);
        System.out.println("Custom Date: " + customDate);

        int dayOfMonth = now.getDayOfMonth();
        int month = now.getMonthValue();
        int year = now.getYear();

        // Using println or proper printf
        System.out.println("Day: " + dayOfMonth);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
    }
}