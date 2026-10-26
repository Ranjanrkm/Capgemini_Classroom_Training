
import java.time.LocalTime;

class dateTime1 {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("Current Time: " + now);

        LocalTime customTime = LocalTime.of(11, 32, 45);
        System.out.println("Custom Time: " + customTime);

        LocalTime par = LocalTime.parse("15:30:45");
        System.out.println("Parsed Time: " + par);
    }
}