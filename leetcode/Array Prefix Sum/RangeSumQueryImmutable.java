// LeetCode 303: Range Sum Query - Immutable
// https://leetcode.com/problems/range-sum-query-immutable/
// Difficulty: Easy

class NumArray {

    private int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}

public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);

        System.out.println(numArray.sumRange(0, 2)); // Expected: 1
        System.out.println(numArray.sumRange(2, 5)); // Expected: -1
        System.out.println(numArray.sumRange(0, 5)); // Expected: -3
    }
}
