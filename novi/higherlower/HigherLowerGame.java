package novi.higherlower;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class HigherLowerGame {
    private final Scanner inputScanner;
    private int numberOfTurnsPlayed = 1;

    public HigherLowerGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public void playGame() {
        boolean gameIsRunning = true;

        // Here you should generate the number to guess
        Random random = new Random();
        int randomNumber = random.nextInt(20);
        System.out.println("Random number is: " + randomNumber);

        while (gameIsRunning) {
            System.out.println("Make a guess ");


            try {
                int guess = inputScanner.nextInt();
                System.out.printf("You typed: %s\n", guess);

                // Check if the guess is correct, if so end the game
                if (guess == randomNumber) {
                    System.out.println("Correct! You guessed the number in " + numberOfTurnsPlayed + " turns!");
                    gameIsRunning = false;
                } else if (guess < randomNumber) {
                    System.out.println("That number is too low!");
                    numberOfTurnsPlayed++;
                } else {
                    System.out.println("That number is too high!");
                    numberOfTurnsPlayed++;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Please fill in only numbers!");
                gameIsRunning = false;
            }
        }
        inputScanner.close();
    }
}
