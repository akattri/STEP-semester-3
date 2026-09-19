import java.util.Arrays;

public class RotateArray {

    /**
     * Rotates an integer array to the right by k positions.
     * Calculates target positions using modulo arithmetic and builds the rotated array.
     *
     * @param nums the array to rotate
     * @param k    the number of positions to rotate to the right
     * @return the rotated array
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        // Reduce k in case it is greater than the array length
        k = k % n;
        if (k < 0) {
            k += n; // Handle negative k safely
        }

        int[] newArray = new int[n];

        // Work out each element's new position after rotation
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        // Copy values back into nums
        for (int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        int[] result1 = rotateArray(nums1, k1);
        System.out.println("Output: " + Arrays.toString(result1));

        // Sample Test Case 2
        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println("\nInput: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        int[] result2 = rotateArray(nums2, k2);
        System.out.println("Output: " + Arrays.toString(result2));

        // Additional Test Case: k equals length
        int[] nums3 = {10, 20, 30, 40};
        int k3 = 4;
        System.out.println("\nInput: nums = " + Arrays.toString(nums3) + ", k = " + k3);
        int[] result3 = rotateArray(nums3, k3);
        System.out.println("Output: " + Arrays.toString(result3));
    }
}
