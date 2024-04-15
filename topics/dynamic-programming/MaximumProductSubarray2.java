import java.util.*;

/**
 * Idea: Kadane's algorithm. Similar to finding the maximum sum subarray,
 * but since negative products can lead to a maximum value when multiplied
 * with another negative value, we need to keep track of both the minimum
 * and maximum products as we iterate over the array.

 * statement: https://leetcode.com/problems/maximum-product-subarray/
 */

public class MaximumProductSubarray2 {
    
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int currMax = 0;
        int currMin = 0;
        for (int a: nums) {
            if (currMax == 0) {
                currMax = 1;
                currMin = 1;
            }
            currMax *= a;
            currMin *= a;
            if (currMax < currMin) {
                int temp = currMin;
                currMin = currMax;
                currMax = temp;
            }
            currMin = Math.min(currMin, a);
            currMax = Math.max(currMax, a);
            if (currMax > maxProduct) {
                maxProduct = currMax;
            }
        }
        return maxProduct;
    }
}
