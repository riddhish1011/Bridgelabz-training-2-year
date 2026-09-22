// LeetCode 918: Maximum Sum Circular Subarray
// https://leetcode.com/problems/maximum-sum-circular-subarray/
// Difficulty: Medium

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currentMax = 0, maxSum = nums[0];
        int currentMin = 0, minSum = nums[0];

        for (int num : nums) {
            // Standard Kadane's for maximum subarray sum
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane's variant for minimum subarray sum
            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }

        // If all numbers are negative, maxSum already holds the correct (least negative) answer
        if (maxSum < 0) {
            return maxSum;
        }

        // Circular max is either the normal max, or totalSum minus the minimum subarray (the "wrap-around" case)
        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray solution = new MaximumSumCircularSubarray();

        System.out.println(solution.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));         // Expected: 3
        System.out.println(solution.maxSubarraySumCircular(new int[]{5, -3, 5}));              // Expected: 10
        System.out.println(solution.maxSubarraySumCircular(new int[]{-3, -2, -3}));            // Expected: -2
    }
}
