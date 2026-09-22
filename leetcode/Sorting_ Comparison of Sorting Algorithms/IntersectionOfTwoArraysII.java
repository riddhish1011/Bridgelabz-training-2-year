// LeetCode 350: Intersection of Two Arrays II
// https://leetcode.com/problems/intersection-of-two-arrays-ii/
// Difficulty: Easy
// Unlike problem 349, duplicates matter here (result includes an element
// as many times as it appears in both arrays). Use a frequency map.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums1) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int n : nums2) {
            int count = freq.getOrDefault(n, 0);
            if (count > 0) {
                result.add(n);
                freq.put(n, count - 1);
            }
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = result.get(i);

        return arr;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII sol = new IntersectionOfTwoArraysII();

        System.out.println(java.util.Arrays.toString(
                sol.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}))); // [2, 2]
        System.out.println(java.util.Arrays.toString(
                sol.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); // [9, 4] (order may vary)
    }
}
