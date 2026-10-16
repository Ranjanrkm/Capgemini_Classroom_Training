import java.util.function.Function;

public class lambda_1 {
    public static void main(String[] args) {

        Function<String, Integer> getLength = name -> name.length();

        System.out.println(getLength.apply("Ranjan"));
        System.out.println(getLength.apply("Mahato"));
    }
}
