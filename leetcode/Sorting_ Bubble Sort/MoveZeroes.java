// LeetCode 283: Move Zeroes
// https://leetcode.com/problems/move-zeroes/
// Difficulty: Easy
// Two-pointer, bubble non-zero elements forward, in-place.

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int insertPos = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes sol = new MoveZeroes();

        int[] nums1 = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums1);
        System.out.println(java.util.Arrays.toString(nums1)); // [1, 3, 12, 0, 0]

        int[] nums2 = {0};
        sol.moveZeroes(nums2);
        System.out.println(java.util.Arrays.toString(nums2)); // [0]
    }
}
