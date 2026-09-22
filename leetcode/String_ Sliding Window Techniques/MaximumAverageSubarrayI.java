// LeetCode 643: Maximum Average Subarray I
// https://leetcode.com/problems/maximum-average-subarray-i/
// Difficulty: Easy
// Fixed-size sliding window of length k.

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        long windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        long maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI sol = new MaximumAverageSubarrayI();

        System.out.println(sol.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); // 12.75
        System.out.println(sol.findMaxAverage(new int[]{5}, 1)); // 5.0
    }
}
