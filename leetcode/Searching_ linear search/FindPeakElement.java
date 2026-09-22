// LeetCode 162: Find Peak Element
// https://leetcode.com/problems/find-peak-element/
// Difficulty: Medium
// A peak is an element strictly greater than its neighbors (edges treated
// as -infinity). Binary search converges on a peak in O(log n) by moving
// toward the side with the larger neighbor.

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // peak is at mid or to its left
                right = mid;
            } else {
                // peak is to the right of mid
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        FindPeakElement sol = new FindPeakElement();

        System.out.println(sol.findPeakElement(new int[]{1, 2, 3, 1}));          // 2
        System.out.println(sol.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4})); // 1 or 5
    }
}
