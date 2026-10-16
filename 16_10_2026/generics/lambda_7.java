import java.util.*;

class lambda_7 {
    public static void main(String[] args) {

        // Store the numbers in a list.
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 5);

        // Create a list to store the squares of even numbers.
        List<Integer> result = new ArrayList<>();

        // Iterate through each number in the list.
        for (int n : nums) {

            // Check whether the number is even.
            if (n % 2 == 0) {

                // Square the even number and add it to the result.
                result.add(n * n);
            }
        }

        // Print the final result.
        System.out.println(result);
    }
}

/*
Output:
[4, 16]
*/ 