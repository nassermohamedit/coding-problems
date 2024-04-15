import java.util.*;

/**
 * Idea: Let A be an array of size N such that A[i] > 0 (no 0 elements) for all 0 <= i < N.
 * Let's prove that the optimal subarray either starts at index 0 or ends at index N - 1.
 * Proof: Let [i, j] be the longest optimal subarray such that i > 0 and j < N - 1.
 * Let P be the product of [i, j]. Since it is optimal: P * A[i - 1] < P and P * A[j + 1] < P and P * A[i - 1] * A[j + 1] < P.
 * The first inequality implies that A[i - 1] < 0, and the second implies that A[j + 1] < 0, which contradicts the third inequality.
 * Thus, the optimal subarray is in the form [i, j] where i = 0 or j = N - 1.
 * So, we can compare all the suffix products and prefix products and return their maximum.
 * If the array contains zeros we can solve for each longest subarray with no zerors
 *
 * statement: https://leetcode.com/problems/maximum-product-subarray/
 */

public class MaximumProductSubarray {
    
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        int prefProduct = 1;
        int suffProduct = 1;
        for (int i = 0; i < n; ++i) {
            if (prefProduct == 0) prefProduct = 1;
            if (suffProduct == 0) suffProduct = 1;
            prefProduct *= nums[i];
            suffProduct *= nums[n - i - 1];
            maxProduct = Math.max(maxProduct, prefProduct);
            maxProduct = Math.max(maxProduct, suffProduct);
        }
        return maxProduct;
    }
}
