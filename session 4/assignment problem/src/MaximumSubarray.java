import java.util.Arrays;

public class MaximumSubarray {

    /**
     * Finds the contiguous subarray with the largest sum using Kadane's algorithm.
     * At each step, decides whether to extend the current running subarray or start fresh from the current element.
     *
     * @param nums array of integers (may contain negative numbers)
     * @return the maximum subarray sum
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        // Traverse the rest of the array
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the running sum or restart at nums[i]
            if (currentSum + nums[i] > nums[i]) {
                currentSum = currentSum + nums[i];
            } else {
                currentSum = nums[i];
            }

            // Update the maximum sum found so far
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Mixed positive and negative numbers
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = maxSubArray(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + result1);

        // Sample Test Case 2: All negative numbers
        int[] nums2 = {-3, -1, -2};
        int result2 = maxSubArray(nums2);
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + result2);

        // Additional Test Case: Single positive number
        int[] nums3 = {5, 4, -1, 7, 8};
        int result3 = maxSubArray(nums3);
        System.out.println("\nInput: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + result3);
    }
}
