// LeetCode 324: Wiggle Sort II
// https://leetcode.com/problems/wiggle-sort-ii/
// Difficulty: Medium
// Rearrange nums so nums[0] < nums[1] > nums[2] < nums[3] ...
//
// Approach: sort the array, then place the smaller half (reversed) into
// the even indices and the larger half (reversed) into the odd indices.
// Reversing each half before placing prevents equal adjacent values from
// ending up next to each other, which a naive split can cause with duplicates.

import java.util.Arrays;

public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int mid = (n + 1) / 2; // size of the smaller (or equal) half
        int smallIdx = mid - 1; // fill even indices from here, descending
        int largeIdx = n - 1;   // fill odd indices from here, descending

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[smallIdx--];
            } else {
                nums[i] = sorted[largeIdx--];
            }
        }
    }

    public static void main(String[] args) {
        WiggleSortII sol = new WiggleSortII();

        int[] nums1 = {1, 5, 1, 1, 6, 4};
        sol.wiggleSort(nums1);
        System.out.println(java.util.Arrays.toString(nums1)); // e.g. [1, 6, 1, 5, 1, 4]

        int[] nums2 = {1, 3, 2, 2, 3, 1};
        sol.wiggleSort(nums2);
        System.out.println(java.util.Arrays.toString(nums2)); // e.g. [2, 3, 1, 3, 1, 2]
    }
}
