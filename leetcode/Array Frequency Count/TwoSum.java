// LeetCode 1: Two Sum
// https://leetcode.com/problems/two-sum/
// Difficulty: Easy

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }

        return new int[]{-1, -1}; // no solution found
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));  // Expected: [0, 1]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));        // Expected: [1, 2]
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));           // Expected: [0, 1]
    }
}
