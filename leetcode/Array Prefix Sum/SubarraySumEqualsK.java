// LeetCode 560: Subarray Sum Equals K
// https://leetcode.com/problems/subarray-sum-equals-k/
// Difficulty: Medium

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        // Map of prefixSum -> number of times that prefixSum has occurred
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // empty prefix

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            // If (sum - k) has been seen before, those subarrays sum to k
            count += prefixSumCount.getOrDefault(sum - k, 0);
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));     // Expected: 2
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));     // Expected: 2
        System.out.println(solution.subarraySum(new int[]{1, -1, 0}, 0));    // Expected: 3
    }
}
