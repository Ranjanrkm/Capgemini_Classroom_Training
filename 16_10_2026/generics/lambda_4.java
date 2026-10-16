import java.util.function.*;

class lambda_4 {
    public static void main(String[] args) {
        Consumer<String> pr = message -> System.out.println(message);

        pr.accept("Hello I love cricket.");
    }
}