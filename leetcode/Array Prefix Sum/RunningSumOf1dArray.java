// LeetCode 1480: Running Sum of 1d Array
// https://leetcode.com/problems/running-sum-of-1d-array/
// Difficulty: Easy

import java.util.Arrays;

public class RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        RunningSumOf1dArray solution = new RunningSumOf1dArray();

        System.out.println(Arrays.toString(solution.runningSum(new int[]{1, 2, 3, 4})));       // Expected: [1, 3, 6, 10]
        System.out.println(Arrays.toString(solution.runningSum(new int[]{1, 1, 1, 1, 1})));     // Expected: [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(solution.runningSum(new int[]{3, 1, 2, 10, 1})));    // Expected: [3, 4, 6, 16, 17]
    }
}
