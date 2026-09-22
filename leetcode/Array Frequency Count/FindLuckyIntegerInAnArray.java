// LeetCode 1394: Find Lucky Integer in an Array
// https://leetcode.com/problems/find-lucky-integer-in-an-array/
// Difficulty: Easy

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInAnArray {

    public int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int luckyNumber = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            if (value == count) {
                luckyNumber = Math.max(luckyNumber, value);
            }
        }

        return luckyNumber;
    }

    public static void main(String[] args) {
        FindLuckyIntegerInAnArray solution = new FindLuckyIntegerInAnArray();

        System.out.println(solution.findLucky(new int[]{2, 2, 3, 4}));          // Expected: 2
        System.out.println(solution.findLucky(new int[]{1, 2, 2, 3, 3, 3}));    // Expected: 3
        System.out.println(solution.findLucky(new int[]{2, 2, 2, 3, 3}));       // Expected: -1
    }
}
