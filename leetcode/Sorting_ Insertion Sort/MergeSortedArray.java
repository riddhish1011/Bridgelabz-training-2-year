// LeetCode 88: Merge Sorted Array
// https://leetcode.com/problems/merge-sorted-array/
// Difficulty: Easy
// Merge from the back to avoid overwriting unread elements of nums1.

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // last valid element in nums1
        int j = n - 1;       // last element in nums2
        int k = m + n - 1;   // last position in nums1

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray sol = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        sol.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(java.util.Arrays.toString(nums1)); // [1, 2, 2, 3, 5, 6]

        int[] nums2 = {1};
        sol.merge(nums2, 1, new int[]{}, 0);
        System.out.println(java.util.Arrays.toString(nums2)); // [1]
    }
}
