// LeetCode 349: Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays/
// Difficulty: Easy
// Each element in the result must be unique. Use a HashSet.

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) set1.add(n);

        Set<Integer> result = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                result.add(n);
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for (int n : result) arr[i++] = n;

        return arr;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays sol = new IntersectionOfTwoArrays();

        System.out.println(java.util.Arrays.toString(
                sol.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}))); // [2]
        System.out.println(java.util.Arrays.toString(
                sol.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); // [9, 4] (order may vary)
    }
}
