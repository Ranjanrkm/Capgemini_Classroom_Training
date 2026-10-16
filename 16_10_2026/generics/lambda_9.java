
import java.util.*;
import java.util.stream.*;

class lambda_9 {
    public static void main(String[] args) {

        // 1. Stream from a List
        List<String> list = List.of("a", "b", "c");

        System.out.println("Stream from a list:");
        list.stream().forEach(System.out::println);

        // 2. Stream from an Array
        int[] arr = {1, 2, 3};

        System.out.println("Stream from an array:");
        Arrays.stream(arr).forEach(System.out::println);

        // 3. Stream from direct values
        System.out.println("Stream from direct values:");
        Stream.of("x", "y", "z")
              .forEach(System.out::println);

        // 4. Filter even numbers and square them
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> res = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("Original List: " + nums);
        System.out.println("Result: " + res);
    }
}
