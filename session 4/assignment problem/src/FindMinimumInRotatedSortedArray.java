import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    /**
     * Finds the minimum element in an array of unique elements that was originally sorted
     * and then rotated at an unknown pivot.
     * Uses modified binary search in O(log n) time.
     *
     * @param nums rotated sorted array of unique integers
     * @return the minimum integer in the array
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than rightmost element,
            // the pivot and minimum must lie in the right half (mid + 1 to right)
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, nums[mid] <= nums[right], so the minimum is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        // Sample Test Case 1: Rotated sorted array
        int[] nums1 = {3, 4, 5, 1, 2};
        int result1 = findMin(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + result1);

        // Sample Test Case 2: Rotated sorted array
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int result2 = findMin(nums2);
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + result2);

        // Sample Test Case 3: Already sorted array (no rotation)
        int[] nums3 = {11, 13, 15, 17};
        int result3 = findMin(nums3);
        System.out.println("\nInput: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + result3);

        // Additional Test Case: Two elements
        int[] nums4 = {2, 1};
        int result4 = findMin(nums4);
        System.out.println("\nInput: nums = " + Arrays.toString(nums4));
        System.out.println("Output: " + result4);
    }
}
