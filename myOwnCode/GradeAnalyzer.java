package myOwnCode;

public class GradeAnalyzer {
    public static void main(String[] args) {

        // Array of scores (Integers)
        int[] scores = {55, 90, 45, 82, 76, 30, 95};

        int totalPassingScore = 0;
        int passingCount = 0;

        System.out.println("Processing Scores...");

        // 1. LOOP: Iterate through the array
        for (int i = 0; i < scores.length; i++) {

            // 2. IF STATEMENT: Filter for passing grades
            if (scores[i] >= 60) {
                totalPassingScore += scores[i];
                passingCount++;
            }
        }

        if (passingCount > 0) {
            // 3. INT TO DOUBLE:
            // We cast 'totalPassingScore' to (double) BEFORE dividing.
            double average = (double) totalPassingScore / passingCount;

            System.out.println("Total Passing Score (int): " + totalPassingScore);
            System.out.println("Average Passing Score (double): " + average);
        } else {
            System.out.println("No passing scores.");
        }
    }
}