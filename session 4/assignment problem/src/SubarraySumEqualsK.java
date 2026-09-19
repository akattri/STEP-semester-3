import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /**
     * Finds the total number of continuous subarrays whose sum equals k.
     * Uses prefix sums combined with a HashMap storing frequency of prefix sums.
     * Time Complexity: O(n), Space Complexity: O(n).
     *
     * @param nums array of integers (may contain negative numbers)
     * @param k    target sum
     * @return count of subarrays summing to k
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int currentSum = 0;

        // Map to store prefix sum frequencies: prefixSum -> frequency
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();

        // Base case: prefix sum of 0 has occurred once before traversing any elements
        prefixSumFreq.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) has occurred before, add its frequency
            if (prefixSumFreq.containsKey(currentSum - k)) {
                count += prefixSumFreq.get(currentSum - k);
            }

            // Record the current prefix sum frequency
            prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        int result1 = subarraySum(nums1, k1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + result1);

        // Sample Test Case 2: Array with zero and negative numbers
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        int result2 = subarraySum(nums2, k2);
        System.out.println("\nInput: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + result2);

        // Additional Test Case: Multiple matches
        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k3 = 7;
        int result3 = subarraySum(nums3, k3);
        System.out.println("\nInput: nums = " + Arrays.toString(nums3) + ", k = " + k3);
        System.out.println("Output: " + result3);
    }
}
