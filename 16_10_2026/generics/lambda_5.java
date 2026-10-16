
import java.util.function.*;

class lambda_5 {
    public static void main(String[] args) {
        Consumer<String> smsNotifier = mobNo -> {
            System.out.println("Sending the OTP to the ph no.: " + mobNo);
        };

        smsNotifier.accept("+91 12345678");
    }
}
