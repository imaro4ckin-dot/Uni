package myOwnCode;

public class ShoppingCheckout {

    public static void main(String[] args) {

        // 1. Setup variables
        double myBudget = 100.00;
        double[] cartItemPrices = {25.50, 10.00, 45.00, 15.99};
        double totalAmount = 0.0;
        double discountThreshold = 50.00;

        System.out.println("--- Starting Checkout Process ---");

        // 2. Loop: Calculate total sum
        for (double price : cartItemPrices) {
            totalAmount += price;
            System.out.println("Added item with price: $" + price);
        }

        System.out.println("Subtotal: $" + totalAmount);

        // 3. If Statement: Check for discount
        if (totalAmount > discountThreshold) {
            System.out.println("You qualify for a 10% discount!");
            totalAmount = totalAmount * 0.90; // Apply 10% discount
        } else {
            System.out.println("No discount applied.");
        }

        // 4. If/Else Statement: Check budget
        System.out.println("Final Total: $" + String.format("%.2f", totalAmount));

        if (myBudget >= totalAmount) {
            double remainingBalance = myBudget - totalAmount;
            System.out.println("Payment Approved! Purchase successful.");
            System.out.println("Remaining Budget: $" + String.format("%.2f", remainingBalance));
        } else {
            double amountNeeded = totalAmount - myBudget;
            System.out.println("Payment Declined. Insufficient funds.");
            System.out.println("You need $" + String.format("%.2f", amountNeeded) + " more.");
        }
    }
}