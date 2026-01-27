package myOwnCode;

import java.util.Scanner;

public class elecatiion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int age =-1;
        while (age < 0 || age > 120) {
            System.out.print("Enter a valid age (0-120): ");
            if (input.hasNextInt()) {
                age = input.nextInt();
                if (age < 0 || age > 120) {
                    System.out.println("That's not a possible age. Try again.");
                }
            } else {
                System.out.println("Error: Please enter a numeric number.");
                input.next(); // Clear the invalid input
            }
        }


        System.out.print("Do you have a Voter ID? (true/false): ");
        boolean hasVoterCard = input.nextBoolean();


        if (age >= 18 && hasVoterCard) {
            System.out.println("Access Granted: You can proceed to vote.");
        } else if (age >= 18 && !hasVoterCard) {
            System.out.println("Access Denied: You are old enough, but you need a card.");
        } else {
            int yearsToWait = 18 - age;
            System.out.println("Access Denied: Please return in " + yearsToWait + " years.");
        }


        System.out.print("\nFinalizing your registration...");
        for (int i = 1; i <= 3; i++) {
            System.out.print(" . ");
            try { Thread.sleep(500); } catch (Exception e) {}
        }

        System.out.println("\nDone! Program safely closed.");
        input.close();
    }
}