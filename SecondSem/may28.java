package SecondSem;

public class may28 {

    // You need a main method (or another method) to run executable code
    public static void main(String[] args) {
      int[] x = new int[100];
        int myLength = 7;

        x[0] = 3;
        x[1] = 4;
        x[2] = 0;
        x[3] = 7;
        x[4] = 10;
        x[5] = 1;
        x[6] = 2;

        myLength = insert(x, myLength, 2, 11);


    }

    private static int insert(int[] v, int length, int pos, int value) {
        for (int i = length - 1; i >= pos; --i) {
            v[i+1] = v[i];
        }

        v[pos] = value;
        return length + 1;
    }


    private static int delete(int[] v, int length, int pos) {
        // Start at the position we want to delete, and shift everything left
        for (int i = pos; i < length - 1; i++) {
            v[i] = v[i + 1];
        }

        return length - 1;
    }



private static void reverse(int[] v, int length) {
        // Only loop halfway through the active elements
        for (int i = 0; i < length / 2; i++) {
            // Calculate the index on the opposite side
            int rightIndex = length - 1 - i;

            // Swap the elements using a temporary variable
            int temp = v[i];
            v[i] = v[rightIndex];
            v[rightIndex] = temp;
        }
    }


    private static void findTwoLargest(int[] v, int length) {
        // We need at least 2 elements to find the top 2!
        if (length < 2) {
            System.out.println("Not enough elements.");
            return;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Loop through the logical part of the array
        for (int i = 0; i < length; i++) {
            // Check if it qualifies for Gold
            if (v[i] > largest) {
                // The old largest gets bumped down to second place
                secondLargest = largest;
                // The new value becomes the largest
                largest = v[i];
            }
            // Otherwise, check if it qualifies for Silver
            else if (v[i] > secondLargest) {
                secondLargest = v[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
    }


    }
