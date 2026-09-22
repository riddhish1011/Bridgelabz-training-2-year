// LeetCode 643: Maximum Average Subarray I
// https://leetcode.com/problems/maximum-average-subarray-i/
// Difficulty: Easy

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k]; // slide the window
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI solution = new MaximumAverageSubarrayI();

        System.out.println(solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); // Expected: 12.75
        System.out.println(solution.findMaxAverage(new int[]{5}, 1));                    // Expected: 5.0
    }
}
