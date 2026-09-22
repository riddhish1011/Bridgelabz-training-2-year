// LeetCode 53: Maximum Subarray
// https://leetcode.com/problems/maximum-subarray/
// Difficulty: Medium

public class MaximumSubarray {

    // Kadane's Algorithm — O(n) time, O(1) space
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();

        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // Expected: 6
        System.out.println(solution.maxSubArray(new int[]{1}));                              // Expected: 1
        System.out.println(solution.maxSubArray(new int[]{5, 4, -1, 7, 8}));                  // Expected: 23
    }
}
