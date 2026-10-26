import java.time.LocalDate;
import java.time.Month;

class dataTime {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        System.out.println("Todays date is: " + now);

        int dayOfMonth = now.getDayOfMonth();
        Month month = now.getMonth();
        int year = now.getYear();

        System.out.println("Day: " + dayOfMonth);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
    }
}