// LeetCode 1207: Unique Number of Occurrences
// https://leetcode.com/problems/unique-number-of-occurrences/
// Difficulty: Easy

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Set<Integer> occurrenceCounts = new HashSet<>();
        for (int count : freq.values()) {
            if (!occurrenceCounts.add(count)) {
                return false; // duplicate occurrence count found
            }
        }

        return true;
    }

    public static void main(String[] args) {
        UniqueNumberOfOccurrences solution = new UniqueNumberOfOccurrences();

        System.out.println(solution.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));       // Expected: true
        System.out.println(solution.uniqueOccurrences(new int[]{1, 2}));                   // Expected: false
        System.out.println(solution.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0})); // Expected: true
    }
}
