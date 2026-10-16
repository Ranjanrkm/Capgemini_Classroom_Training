// Lambda Expression

@FunctionalInterface
interface Greater {
    void greet(String name);
}

public class lambda_3 {
    public static void main(String[] args) {

        Greater g = name -> System.out.println("Hello, " + name);

        g.greet("Ranjan");
    }
}