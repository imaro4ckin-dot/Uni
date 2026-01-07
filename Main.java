import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 1. Setup
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;
        int userGuess = 0;
        int attempts = 0;

        System.out.println("--- WELCOME TO MY FIRST GITHUB PROJECT ---");
        System.out.println("I'm thinking of a number between 1 and 100.");

        // 2. Game Logic
        while (userGuess != targetNumber) {
            System.out.print("Enter your guess: ");
            
            // Check if input is a number
            if (input.hasNextInt()) {
                userGuess = input.nextInt();
                attempts++;

                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("BINGO! You got it in " + attempts + " tries.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                input.next(); // Clear the bad input
            }
        }
        
        input.close();
    }
}