import java.util.Arrays;

public class MergeTwoSortedArrays {

    /**
     * Merges two sorted integer arrays into a single sorted array.
     * Uses two pointers and a while loop without re-sorting.
     *
     * @param arr1 first sorted array
     * @param arr2 second sorted array
     * @return a new merged and sorted array
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null) {
            arr1 = new int[0];
        }
        if (arr2 == null) {
            arr2 = new int[0];
        }

        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for arr2
        int k = 0; // Pointer for result

        // Repeatedly compare current elements and copy the smaller one
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1, if any
        while (i < n1) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2, if any
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] result1 = mergeSortedArrays(arr1, arr2);
        System.out.println("Input: arr1 = " + Arrays.toString(arr1) + ", arr2 = " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(result1));

        // Sample Test Case 2: One empty array
        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        int[] result2 = mergeSortedArrays(arr3, arr4);
        System.out.println("\nInput: arr1 = " + Arrays.toString(arr3) + ", arr2 = " + Arrays.toString(arr4));
        System.out.println("Output: " + Arrays.toString(result2));

        // Additional Test Case: Arrays with duplicate values and different lengths
        int[] arr5 = {1, 2, 7, 9};
        int[] arr6 = {2, 5, 6};
        int[] result3 = mergeSortedArrays(arr5, arr6);
        System.out.println("\nInput: arr1 = " + Arrays.toString(arr5) + ", arr2 = " + Arrays.toString(arr6));
        System.out.println("Output: " + Arrays.toString(result3));
    }
}
