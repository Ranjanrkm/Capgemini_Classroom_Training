import java.security.SecureRandom;
import java.util.function.Supplier;

class lambda_6 {
    public static void main(String[] args) {

        SecureRandom random = new SecureRandom();

        // Supplier generates and returns a 6-digit OTP as a String.
        Supplier<String> otpGen = () -> {
            int number = 100000 + random.nextInt(900000);
            return String.valueOf(number);
        };

        // Call the Supplier to generate the OTP.
        String userOtp = otpGen.get();

        System.out.println("The OTP is: " + userOtp);
    }
}