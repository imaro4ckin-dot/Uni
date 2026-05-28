package SecondSem;

public class ArrayEx {
    public static void main(String[] args) throws Exception {
        int[][] inp = new int[10][10];

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                inp[i][j] = Math.round((float) Math.random() * 10.0f);
                System.out.printf("%d\t", inp[i][j]);
            }

            System.out.printf("\n\n");
        }
        System.out.printf("\n");

        System.out.printf("Diagonal difference: %d\n", diagonalDifference(inp));
        System.out.printf("Min-Max sum: %d\n", minMaxSum(inp[0]));
        System.out.printf("Birthday cake candles: %d\n", birthDayCakeCandles(inp[0]));
    }

    /*
     * The following algorithms must be implemented using a single-pass loop.
     * You can use additional variables, but no additional arrays.
     */

    private static int diagonalDifference(int[][] m) {

        int firstSum  = 0;
        int secondSum = 0;


for (int i = 0; i<m.length; i++){
    firstSum += m[i][i];
    secondSum += m[i][m.length - 1 -i];


}

return Math.abs(firstSum - secondSum);

    }


    private static int minMaxSum(int[] v) {
        int totalSum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Single pass to find the total sum, the smallest integer, and the largest integer
        for (int i = 0; i < v.length; i++) {
            int current = v[i];
            totalSum += current;

            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }
        }

        // The minimum sum is the total sum minus the largest element.
        int minSum = totalSum - max;

        // The maximum sum is the total sum minus the smallest element.
        int maxSum = totalSum - min;

        // Print the respective minimum and maximum values as a single line of two space-separated long integers
       int Answer = minSum + maxSum;

       return Answer; // Satisfies the int return type of your method signature
    }

    private static int birthDayCakeCandles(int[] v) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < v.length; i++) {
            if (v[i] > max) {
                max = v[i];
                count = 1; // Found a new max, reset count
            } else if (v[i] == max) {
                count++;   // Found another candle of the current max height
            }
        }

        return count;
    }
}
