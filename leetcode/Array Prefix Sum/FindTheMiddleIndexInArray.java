// LeetCode 1991: Find the Middle Index in Array
// https://leetcode.com/problems/find-the-middle-index-in-array/
// Difficulty: Easy

public class FindTheMiddleIndexInArray {

    public int findMiddleIndex(int[] nums) {
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
        FindTheMiddleIndexInArray solution = new FindTheMiddleIndexInArray();

        System.out.println(solution.findMiddleIndex(new int[]{2, 3, -1, 8, 4})); // Expected: 3
        System.out.println(solution.findMiddleIndex(new int[]{1, -1, 4}));       // Expected: 2
        System.out.println(solution.findMiddleIndex(new int[]{2, 5}));           // Expected: -1
    }
}
