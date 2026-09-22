// LeetCode 977: Squares of a Sorted Array
// https://leetcode.com/problems/squares-of-a-sorted-array/
// Difficulty: Easy
// Two-pointer from both ends: the largest squares come from whichever
// end (most negative or most positive) has the bigger absolute value.

public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;

        for (int k = n - 1; k >= 0; k--) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq) {
                result[k] = leftSq;
                left++;
            } else {
                result[k] = rightSq;
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SquaresOfSortedArray sol = new SquaresOfSortedArray();

        System.out.println(java.util.Arrays.toString(
                sol.sortedSquares(new int[]{-4, -1, 0, 3, 10}))); // [0, 1, 9, 16, 100]
        System.out.println(java.util.Arrays.toString(
                sol.sortedSquares(new int[]{-7, -3, 2, 3, 11}))); // [4, 9, 9, 49, 121]
    }
}
