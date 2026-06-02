package SecondSem;

import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        int[][] mat = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        Scanner sc = new Scanner(System.in);
        int emptyCells = 0;


        for (int[] row : mat) {
            for (int val : row) {
                if (val == 0) emptyCells++;
            }
        }


        while (emptyCells > 0) {


            System.out.println();
            for (int i = 0; i < mat.length; ++i) {
                for (int j = 0; j < mat[i].length; ++j) {
                    System.out.printf("%d\t", mat[i][j]);
                }
                System.out.println();
                System.out.println();
            }

            System.out.print("Enter Row (0-8), Column (0-8), and Number (1-9): ");
            int r = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();


            if (mat[r][c] == 0 && isValid(mat, r, c, n)) {
                mat[r][c] = n;
                emptyCells--;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        System.out.println("You solved it!");
        sc.close();
    }


    private static boolean isValid(int[][] mat, int r, int c, int n) {
        for (int i = 0; i < 9; i++) {

            if (mat[r][i] == n || mat[i][c] == n) return false;
        }

        int boxR = (r / 3) * 3;
        int boxC = (c / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mat[boxR + i][boxC + j] == n) return false;
            }
        }
        return true;
    }
}