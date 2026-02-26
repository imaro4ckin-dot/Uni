package Lesson4;

import java.util.HashMap;

public class MyProgram {


    private static HashMap<Integer, Integer> memo = new HashMap<>();

    static int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static int fibonacciMemo(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (memo.containsKey(n)) return memo.get(n);

        int result = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        memo.put(n, result);
        return result;
    }



    public static void main(String[] args) {
        int[] inputSizes = {5, 10, 15, 20, 25, 30, 35, 40, 45}; // The 'N' values we want to test
        int trials = 1000;

        // Print Table Header
        System.out.printf("%-10s %-20s %-20s%n", "N", "Iterative (ns)", "Memoization (ns)");
        System.out.println("-------------------------------------------------------");

        for (int n : inputSizes) {
            long avgIterative = getAverageIterative(n, trials);
            long avgMemo = getAverageMemo(n, trials);

            // Print Table Row
            System.out.printf("%-10d %-20d %-20d%n", n, avgIterative, avgMemo);
        }
    }


    public static long getAverageIterative(int n, int trials) {
        long totalTime = 0;


        for (int i = 0; i < trials; i++) {
            long start = System.nanoTime();
            fibonacciIterative(n);
            long end = System.nanoTime();
            totalTime += (end - start);
        }
        return totalTime / trials;
    }


    public static long getAverageMemo(int n, int trials) {
        long totalTime = 0;



        for (int i = 0; i < trials; i++) {
            memo.clear();
            long start = System.nanoTime();
            fibonacciMemo(n);
            long end = System.nanoTime();
            totalTime += (end - start);
        }
        return totalTime / trials;
    }
}