import java.util.*;
import java.util.stream.*;

class Map {
    public static void main(String[] args) {
        List<Integer> nums =
            Arrays.asList(5, 12, 8, 3, 20, 7, 12);

        List<Integer> result = nums.stream()
            .map(n -> n * 2)
            .collect(Collectors.toList());

        System.out.println(result);
    }
}