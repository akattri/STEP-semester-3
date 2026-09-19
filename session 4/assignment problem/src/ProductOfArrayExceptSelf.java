import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * Computes an array where answer[i] is the product of all elements in nums except nums[i].
     * Achieved in O(n) time and O(1) extra space (beyond the output array) without using division.
     *
     * @param nums the input integer array
     * @return the product array
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: Forward pass accumulating prefix products
        // answer[i] contains the product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: Backward pass multiplying running suffix products
        // suffixProduct tracks the product of all elements to the right of i
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelf(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(result1));

        // Sample Test Case 2: Array with zero
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelf(nums2);
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(result2));

        // Additional Test Case: Array with multiple zeros
        int[] nums3 = {0, 4, 0};
        int[] result3 = productExceptSelf(nums3);
        System.out.println("\nInput: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + Arrays.toString(result3));
    }
}
