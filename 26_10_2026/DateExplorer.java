
import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
import java.util.Scanner;

public class DateExplorer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Ask the user to input a date using Scanner
        System.out.print("Enter a date in the format yyyy-MM-dd (e.g., 2026-10-26): ");
        String input = scanner.nextLine();

        LocalDate date;
        try {
            // 2. Use LocalDate.parse() to convert the input into a LocalDate object
            date = LocalDate.parse(input);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            scanner.close();
            return;
        }

        int choice;
        // 7. Use a loop to keep displaying the menu until the user chooses Exit
        do {
            System.out.println("\n==============================");
            System.out.println("       DATE EXPLORER MENU     ");
            System.out.println("==============================");
            System.out.println("1. Display Month");
            System.out.println("2. Display Year & Check Leap Year");
            System.out.println("3. Display Day of Week");
            System.out.println("4. Look Back by Months");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number (1-5): ");
                scanner.next();
            }
            choice = scanner.nextInt();

            // 3. Use a switch statement to handle the menu options
            switch (choice) {
                case 1:
                    displayMonth(date);
                    break;
                case 2:
                    displayYear(date);
                    break;
                case 3:
                    displayDayOfWeek(date);
                    break;
                case 4:
                    lookBackMonths(date, scanner);
                    break;
                case 5:
                    System.out.println("Exiting Date Explorer. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please choose between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // 8. Create a DateExplorer class with methods such as displayMonth()
    public static void displayMonth(LocalDate date) {
        // 5. Use getMonth()
        Month month = date.getMonth();
        System.out.println("\n--- Month Details ---");
        System.out.println("Month: " + month + " (Numeric: " + date.getMonthValue() + ")");
    }

    // 8. Create a DateExplorer class with methods such as displayYear()
    public static void displayYear(LocalDate date) {
        // 5. Use getYear()
        int year = date.getYear();
        System.out.println("\n--- Year Details ---");
        System.out.println("Year: " + year);

        // 6. Use an if-else statement to check whether the entered year is a leap year
        if (date.isLeapYear()) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }

    // Helper method for Day of Week using getDayOfWeek() (Requirement 5)
    public static void displayDayOfWeek(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println("\n--- Day of Week Details ---");
        System.out.println("Day of Week: " + dayOfWeek);
    }

    // 8. Create a DateExplorer class with methods such as lookBackMonths()
    public static void lookBackMonths(LocalDate date, Scanner scanner) {
        System.out.print("\nEnter number of months to look back: ");
        while (!scanner.hasNextLong()) {
            System.out.print("Please enter a valid integer: ");
            scanner.next();
        }
        long monthsToSubtract = scanner.nextLong();

        // 4. Use minusMonths() to look back by a number of months specified by the user
        LocalDate pastDate = date.minusMonths(monthsToSubtract);
        System.out.println(monthsToSubtract + " months before " + date + " was: " + pastDate);
    }
}