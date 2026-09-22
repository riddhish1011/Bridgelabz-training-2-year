// LeetCode 1749: Maximum Absolute Sum of Any Subarray
// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
// Difficulty: Medium

public class MaximumAbsoluteSumOfAnySubarray {

    public int maxAbsoluteSum(int[] nums) {
        int currentMax = 0, maxSum = 0;
        int currentMin = 0, minSum = 0;

        for (int num : nums) {
            // Track max subarray sum ending here (Kadane's)
            currentMax = Math.max(0, currentMax) + num;
            maxSum = Math.max(maxSum, currentMax);

            // Track min subarray sum ending here (Kadane's variant)
            currentMin = Math.min(0, currentMin) + num;
            minSum = Math.min(minSum, currentMin);
        }

        // The largest absolute sum is either the max positive sum or the max negative magnitude
        return Math.max(maxSum, -minSum);
    }

    public static void main(String[] args) {
        MaximumAbsoluteSumOfAnySubarray solution = new MaximumAbsoluteSumOfAnySubarray();

        System.out.println(solution.maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}));  // Expected: 5
        System.out.println(solution.maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2})); // Expected: 8
    }
}
