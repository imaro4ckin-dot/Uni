package myOwnCode;
import java.util.Scanner;

public class BonusCalculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("--- Corporate Bonus Calculation System ---");


        System.out.print("Enter your KPI score (0-100): ");
        int score = input.nextInt();
        double performanceMultiplier;

        if (score >= 90) {
            performanceMultiplier = 1.5; // Excellent
            System.out.println("Rating: Excellent");
        } else if (score >= 75) {
            performanceMultiplier = 1.2; // Good
            System.out.println("Rating: Good");
        } else if (score >= 50) {
            performanceMultiplier = 1.0; // Satisfactory
            System.out.println("Rating: Meets Expectations");
        } else {
            performanceMultiplier = 0.0; // Unsatisfactory
            System.out.println("Rating: Below Expectations (No Bonus)");
        }


        System.out.print("\nEnter position level (JUNIOR, MIDDLE, SENIOR): ");
        String position = input.next().toUpperCase();
        int baseSalary = 0;


        switch (position) {
            case "JUNIOR" -> {
                baseSalary = 50000;
                System.out.println("Base rate for Junior: " + baseSalary);
            }
            case "MIDDLE" -> {
                baseSalary = 100000;
                System.out.println("Base rate for Middle: " + baseSalary);
            }
            case "SENIOR" -> {
                baseSalary = 150000;
                System.out.println("Base rate for Senior: " + baseSalary);
            }
            default -> {
                System.out.println("Error: Unknown position. Calculation aborted.");
                return;
            }
        }


        double finalBonus = baseSalary * performanceMultiplier;

        System.out.println("---------------------------------------------");
        if (finalBonus > 0) {
            System.out.printf("Final bonus payout: $%.2f\n", finalBonus);
        } else {
            System.out.println("Unfortunately, no bonus is awarded this year.");
        }

        input.close(); // Good practice to close the scanner
    }
}