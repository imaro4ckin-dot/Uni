package Lesson4;



public class MergeSort {
    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {

            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;

            }
            k++;
        }

        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }

    }

 public static void mergeSort(int[] array) {
        // Base case: if array has 1 or 0 elements, it is already sorted
        if (array.length <= 1) {
            return;
        }

        // Find the middle of the array
        int middle = array.length / 2;

        // Create left and right subarrays
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];

        // Copy data into left array
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        // Copy data into right array
        for (int i = middle; i < array.length; i++) {
            right[i - middle] = array[i];
        }

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves back together
        merge(array, left, right);
    }


public static void main(String[] args){

    int[] array = {38, 27, 43, 3,9, 82,10};
    System.out.println("Before sorting");
    printArray(array);
    mergeSort(array);

    System.out.println("\nAfter sorting:");
printArray(array);
}

 public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}


