import java.security.SecureRandom;

public class Craps {

    private static final SecureRandom randomNumbers = new SecureRandom();

    private enum Status {CONTINUE, WON, LOST}

    ;

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    // play the game
    public static void main(String[] args) {

        int myPoint = 0;    // point if no win or loss on first roll
        Status gameStatus;  // can contain CONTINUE, WON, or LOST

        int sumOfDice = rollDice(); // first roll of the dice

        // determine game status and point based on first roll
        switch (sumOfDice) {
            case SEVEN:             // win with 7 on first roll
            case YO_LEVEN:          // win with 11 on first roll
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES:        // lose with 2 on first roll
            case TREY:              // lose with 3 on first roll
            case BOX_CARS:          // lose with 12 on first roll
                gameStatus = Status.LOST;
                break;
            default:                // did not win or lose, remember point
                gameStatus = Status.CONTINUE;
                System.out.printf("Point is %d%n", myPoint);
                break;
        }

        // while game is not complete
        while (gameStatus == Status.CONTINUE) {
            sumOfDice = rollDice();

            if (sumOfDice == myPoint) {
                gameStatus = Status.WON;
            } else {
                if (sumOfDice == SEVEN) {
                    gameStatus = Status.LOST;
                }
            }
        }

        // display won or lost message
        if (gameStatus == Status.WON) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Player loses.");
        }

    }

    public static int rollDice() {
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);

        int sum = die1 + die2;

        System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

        return sum;
    }


}
