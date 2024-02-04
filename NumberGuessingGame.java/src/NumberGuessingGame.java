import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        playGame(scanner, random);

        scanner.close();
    }

    public static void playGame(Scanner scanner, Random random) {
        // Step 1: Generate a random number within the specified range
        int secretNumber = random.nextInt(100) + 1;

        // Additional details
        int attemptsLimit = 10;
        int totalAttempts = 0;
        int roundsPlayed = 0;

        while (true) {
            // Step 2: Prompt the user to enter their guess
            System.out.print("Enter your guess (between 1 to 100): ");
            int userGuess = scanner.nextInt();

            // Step 3: Compare the user's guess and provide feedback
            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number!");
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            // Additional details
            totalAttempts++;

            // Check if attempts limit reached
            if (totalAttempts >= attemptsLimit) {
                System.out.println("Sorry, you've reached the maximum attempts. The correct number was " + secretNumber + ".");
                break;
            }
        }

        // Additional details
        roundsPlayed++;

        // Ask if the user wants to play again
        System.out.print("Do you want to play again? (yes/no): ");
        String playAgain = scanner.next().toLowerCase();

        if (playAgain.equals("yes")) {
            playGame(scanner, random);
        } else {
            System.out.println("Thanks for playing! Your score: " + roundsPlayed + " rounds won with " + totalAttempts + " total attempts.");
        }
    }
}
