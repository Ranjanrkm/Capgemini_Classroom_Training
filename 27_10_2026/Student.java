public class Student {

    // Private fields
    private String name;
    private int rollNumber;
    private int marks1;
    private int marks2;
    private int marks3;

    // Constructor
    public Student(String name, int rollNumber,
                   int marks1, int marks2, int marks3) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    // Calculate total marks
    public int getTotal() {
        return marks1 + marks2 + marks3;
    }

    // Calculate average marks
    public double getAverage() {
        return getTotal() / 3.0;
    }

    // Calculate grade
    public String getGrade() {
        double average = getAverage();

        if (average >= 90) {
            return "A+";
        } else if (average >= 75) {
            return "A";
        } else if (average >= 60) {
            return "B";
        } else if (average >= 40) {
            return "C";
        } else {
            return "Fail";
        }
    }

    // Display student report
    public void display() {
        System.out.printf(
            "Roll %d | %s | Total: %d | Average: %.2f | Grade: %s%n",
            rollNumber,
            name,
            getTotal(),
            getAverage(),
            getGrade()
        );
    }
}