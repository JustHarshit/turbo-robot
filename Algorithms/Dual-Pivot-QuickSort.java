public class DualPivotQuickSort {

    // Main method to sort the array using Dual-Pivot QuickSort
    public static void sort(int[] array) {
        if (array == null || array.length < 2) {
            return; // No need to sort if the array is null or has fewer than 2 elements
        }
        quickSort(array, 0, array.length - 1);
    }

    // Recursive method that performs the sorting
    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int[] pivots = partition(array, left, right);
            int leftPivotIndex = pivots[0];  // Index of the left pivot
            int rightPivotIndex = pivots[1]; // Index of the right pivot

            // Recursively sort the three partitions
            quickSort(array, left, leftPivotIndex - 1);
            quickSort(array, leftPivotIndex + 1, rightPivotIndex - 1);
            quickSort(array, rightPivotIndex + 1, right);
        }
    }

    // Method to partition the array around two pivots
    private static int[] partition(int[] array, int left, int right) {
        if (array[left] > array[right]) {
            swap(array, left, right); // Ensure left pivot is less than right pivot
        }

        int leftPivot = array[left];   // Left pivot value
        int rightPivot = array[right];  // Right pivot value
        int j = left + 1;               // Start from the next element
        int g = right - 1;              // End before the right pivot

        while (j <= g) {
            if (array[j] < leftPivot) {
                swap(array, j++, left++); // Move smaller elements to the left
            } else if (array[j] >= rightPivot) {
                while (j < g && array[g] > rightPivot) {
                    g--; // Find an element less than or equal to the right pivot
                }
                swap(array, j, g--); // Move larger elements to the right
            } else {
                j++; // Move to the next element
            }
        }

        // Place pivots in their final positions
        swap(array, left, --j);
        swap(array, right, ++g);

        return new int[]{j, g}; // Return indices of the pivots
    }

    // Utility method to swap two elements in the array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {24, 8, 42, 75, 29, 16};
        System.out.println("Original Array:");
        printArray(numbers);

        sort(numbers); // Sort the array using Dual-Pivot QuickSort

        System.out.println("Sorted Array:");
        printArray(numbers);
    }

    // Method to print elements of the array
    private static void printArray(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}

//This Java program implements the Dual-Pivot QuickSort algorithm to efficiently sort an integer array. 
//It uses two pivot values to partition the data into three sections: values less than the first pivot, values between the two pivots, and values greater than the second pivot.
//By using two pivots instead of one, this approach can reduce comparisons and improve performance compared to traditional single-pivot QuickSort.
//Time complexity - O(n log n)
//Space complexity - constant due to its in-place sorting nature.
