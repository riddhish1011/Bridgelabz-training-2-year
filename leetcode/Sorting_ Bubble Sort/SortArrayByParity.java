// LeetCode 905: Sort Array By Parity
// https://leetcode.com/problems/sort-array-by-parity/
// Difficulty: Easy
// Two-pointer in-place partition: evens to the front, odds to the back.

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 == 0) {
                left++;
            } else if (nums[right] % 2 != 0) {
                right--;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity sol = new SortArrayByParity();

        System.out.println(java.util.Arrays.toString(
                sol.sortArrayByParity(new int[]{3, 1, 2, 4}))); // any valid order, e.g. [4, 2, 1, 3]
        System.out.println(java.util.Arrays.toString(
                sol.sortArrayByParity(new int[]{0})));          // [0]
    }
}
