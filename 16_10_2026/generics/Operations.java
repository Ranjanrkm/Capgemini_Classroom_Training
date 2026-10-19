import java.util.*;
import java.util.stream.*;

class Operations {
    public static void main(String[] args) {
        List<Integer> nums =
            Arrays.asList(5, 12, 8, 3, 20, 7, 12);

        List<Integer> result = nums.stream()
            .filter(n -> n > 7)
            .distinct()
            .sorted()
            .map(n -> n * 2)
            .limit(3)
            .collect(Collectors.toList());

        System.out.println(result);
    }
}