import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * Finds all unique triplets in the array that sum up to 0.
     * Sorts the array first, then uses a two-pointer scan for each element,
     * carefully skipping duplicate values at each step.
     *
     * @param nums array of integers
     * @return a 2D array containing all unique triplets [nums[i], nums[j], nums[k]]
     */
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        // Clone and sort the array
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < sorted.length - 2; i++) {
            // If the smallest number in the triplet is > 0, no 3 numbers can sum to 0
            if (sorted[i] > 0) {
                break;
            }

            // Skip duplicate values for the first element
            if (i > 0 && sorted[i] == sorted[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = sorted.length - 1;

            while (left < right) {
                int sum = sorted[i] + sorted[left] + sorted[right];

                if (sum == 0) {
                    triplets.add(new int[]{sorted[i], sorted[left], sorted[right]});

                    // Skip duplicates for the second element
                    while (left < right && sorted[left] == sorted[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the third element
                    while (left < right && sorted[right] == sorted[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets.toArray(new int[triplets.size()][]);
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] result1 = threeSum(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.deepToString(result1));

        // Sample Test Case 2: All zeros
        int[] nums2 = {0, 0, 0};
        int[][] result2 = threeSum(nums2);
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.deepToString(result2));

        // Additional Test Case: No valid triplets
        int[] nums3 = {1, 2, -2, -1};
        int[][] result3 = threeSum(nums3);
        System.out.println("\nInput: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + Arrays.deepToString(result3));
    }
}
