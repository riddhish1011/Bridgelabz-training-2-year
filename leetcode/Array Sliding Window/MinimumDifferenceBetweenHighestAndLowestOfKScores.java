// LeetCode 1984: Minimum Difference Between Highest and Lowest of K Scores
// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
// Difficulty: Easy

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        if (k == 1) {
            return 0;
        }

        int minDiff = Integer.MAX_VALUE;
        // Slide a window of size k over the sorted array
        for (int i = 0; i + k - 1 < nums.length; i++) {
            int diff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        MinimumDifferenceBetweenHighestAndLowestOfKScores solution =
                new MinimumDifferenceBetweenHighestAndLowestOfKScores();

        System.out.println(solution.minimumDifference(new int[]{90}, 1));                  // Expected: 0
        System.out.println(solution.minimumDifference(new int[]{9, 4, 1, 7}, 2));           // Expected: 2
    }
}
