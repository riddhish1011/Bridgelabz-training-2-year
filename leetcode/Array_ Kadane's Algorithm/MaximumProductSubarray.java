// LeetCode 152: Maximum Product Subarray
// https://leetcode.com/problems/maximum-product-subarray/
// Difficulty: Medium

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // If num is negative, swapping max and min helps
            // because multiplying by a negative flips the sign
            if (num < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            currentMax = Math.max(num, currentMax * num);
            currentMin = Math.min(num, currentMin * num);

            maxProd = Math.max(maxProd, currentMax);
        }

        return maxProd;
    }

    public static void main(String[] args) {
        MaximumProductSubarray solution = new MaximumProductSubarray();

        System.out.println(solution.maxProduct(new int[]{2, 3, -2, 4}));    // Expected: 6
        System.out.println(solution.maxProduct(new int[]{-2, 0, -1}));      // Expected: 0
        System.out.println(solution.maxProduct(new int[]{-2, 3, -4}));      // Expected: 24
    }
}
