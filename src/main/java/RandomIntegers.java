import java.security.SecureRandom;

public class RandomIntegers {
    public static void main(String[] args) {

        // randomNumbers object will produce secure random numbers
        SecureRandom randomNumbers = new SecureRandom();

        // loop 20 times
        for (int i = 1; i <= 20; i++) {

            // pick random integer from 1 to 6
            int face = 1 + randomNumbers.nextInt(6);
            System.out.printf("%d ", face);

            // if iteration is divisible by 5, start new line of output
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }
}
