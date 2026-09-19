import java.util.Arrays;

public class ContainsDuplicate {

    /**
     * Checks whether any value appears at least twice in the array.
     * Uses two nested loops to compare every pair of elements.
     *
     * @param nums array of integers
     * @return true if any duplicate exists, false otherwise
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        // Using two nested loops, compare every pair of different positions
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // Duplicate found, early exit
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {1, 2, 3, 1};
        boolean result1 = containsDuplicate(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + result1);

        // Sample Test Case 2
        int[] nums2 = {1, 2, 3, 4};
        boolean result2 = containsDuplicate(nums2);
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + result2);

        // Additional Test Case
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean result3 = containsDuplicate(nums3);
        System.out.println("\nInput: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + result3);
    }
}
