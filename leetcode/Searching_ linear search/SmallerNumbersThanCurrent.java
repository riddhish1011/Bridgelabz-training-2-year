// LeetCode 1365: How Many Numbers Are Smaller Than the Current Number
// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
// Difficulty: Easy
// For each element, linearly scan the array and count how many
// other elements are strictly smaller. O(n^2) but simple and within limits.

public class SmallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        SmallerNumbersThanCurrent sol = new SmallerNumbersThanCurrent();

        System.out.println(java.util.Arrays.toString(
                sol.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3}))); // [4, 0, 1, 1, 3]
        System.out.println(java.util.Arrays.toString(
                sol.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8}))); // [2, 1, 0, 3]
        System.out.println(java.util.Arrays.toString(
                sol.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7}))); // [0, 0, 0, 0]
    }
}
