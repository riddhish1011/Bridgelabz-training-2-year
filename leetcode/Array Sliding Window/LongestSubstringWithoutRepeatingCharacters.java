// LeetCode 3: Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Difficulty: Medium

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeenIndex = new HashMap<>();
        int maxLength = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currentChar = s.charAt(windowEnd);

            if (lastSeenIndex.containsKey(currentChar) && lastSeenIndex.get(currentChar) >= windowStart) {
                // Shrink window: move start right after the last occurrence
                windowStart = lastSeenIndex.get(currentChar) + 1;
            }

            lastSeenIndex.put(currentChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution =
                new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Expected: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));    // Expected: 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));   // Expected: 3
    }
}
