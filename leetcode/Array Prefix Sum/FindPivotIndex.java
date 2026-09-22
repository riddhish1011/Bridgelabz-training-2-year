// LeetCode 724: Find Pivot Index
// https://leetcode.com/problems/find-pivot-index/
// Difficulty: Easy

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex solution = new FindPivotIndex();

        System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6})); // Expected: 3
        System.out.println(solution.pivotIndex(new int[]{1, 2, 3}));          // Expected: -1
        System.out.println(solution.pivotIndex(new int[]{2, 1, -1}));         // Expected: 0
    }
}
