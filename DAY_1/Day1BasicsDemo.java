// File Name MUST match the public class name: Day1BasicsDemo.java
public class Day1BasicsDemo {

    public static void main(String[] args) {

        // 1. PRIMITIVE DATA TYPES
        byte smallNum = 100;
        int marks = 86;
        long phone = 9876543210L;     // 'L' required for long literals
        float temp = 36.5f;           // 'f' required; decimals default to double
        double salary = 45000.75;
        char grade = 'A';             // Single quotes for char
        boolean isPassed = true;      // Only true or false
        String name = "Ranjan";       // Non-primitive (Reference type)

        System.out.println("Student: " + name + " | Marks: " + marks + " | Passed: " + isPassed);

        // 2. TYPECASTING
        // Widening (Automatic): int (4 bytes) -> double (8 bytes)
        double exactMarks = marks;
        System.out.println("Widening int to double: " + exactMarks); // 86.0

        // Narrowing (Manual): double (8 bytes) -> int (4 bytes), decimals truncated
        int roundedSalary = (int) salary;
        System.out.println("Narrowing double to int: " + roundedSalary); // 45000

        // 3. OPERATORS (Arithmetic, Unary, Ternary)
        int a = 10, b = 3;
        System.out.println("Integer Division (10/3): " + (a / b)); // 3
        System.out.println("Remainder (10%3): " + (a % b));        // 1

        int count = 5;
        System.out.println("Post-increment (count++): " + (count++)); // Prints 5, then count becomes 6
        System.out.println("Pre-increment (++count): " + (++count));  // count becomes 7, then prints 7

        String result = (marks >= 60) ? "PASS" : "FAIL"; // Ternary operator
        System.out.println("Ternary Result: " + result);

        // 4. CONDITIONALS (if-else-if & switch)
        if (marks >= 90) {
            grade = 'O';
        } else if (marks >= 75) {
            grade = 'A';
        } else if (marks >= 60) {
            grade = 'B';
        } else {
            grade = 'F';
        }
        System.out.println("Computed Grade: " + grade);

        switch (grade) {
            case 'O':
                System.out.println("Switch: Outstanding");
                break; // Prevents executing the next case
            case 'A':
                System.out.println("Switch: Excellent");
                break;
            default:
                System.out.println("Switch: Keep Practicing");
        }

        // 5. LOOPS (for, while, do-while, break, continue)
        // Hands-on Program 1: Sum of even numbers from 1 to 10 using for + continue
        int evenSum = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                continue; // Skip odd numbers
            }
            evenSum += i; // Same as evenSum = evenSum + i
        }
        System.out.println("Sum of even numbers (1 to 10): " + evenSum); // 30

        // Hands-on Program 2: Reverse a number using while loop
        int num = 1234;
        int reversed = 0;
        while (num > 0) {
            int lastDigit = num % 10;           // Extract last digit
            reversed = reversed * 10 + lastDigit;
            num = num / 10;                     // Remove last digit
        }
        System.out.println("Reversed 1234 -> " + reversed); // 4321

        // do-while runs at least once even though condition (x < 0) is false
        int x = 1;
        do {
            System.out.println("do-while ran once, x = " + x);
            x++;
        } while (x < 0);
    }
}