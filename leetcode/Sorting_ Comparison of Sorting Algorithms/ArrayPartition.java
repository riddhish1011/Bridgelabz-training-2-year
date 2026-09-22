// LeetCode 561: Array Partition
// https://leetcode.com/problems/array-partition/
// Difficulty: Easy
// Sort, then pair up consecutive elements: sum of the smaller value of
// each pair is maximized when pairs are formed from sorted-adjacent values.

import java.util.Arrays;

public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i]; // take the smaller of each pair
        }

        return sum;
    }

    public static void main(String[] args) {
        ArrayPartition sol = new ArrayPartition();

        System.out.println(sol.arrayPairSum(new int[]{1, 4, 3, 2}));       // 4
        System.out.println(sol.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2})); // 9
    }
}
