// LeetCode 409: Longest Palindrome
// https://leetcode.com/problems/longest-palindrome/
// Difficulty: Easy
// Given a string of lowercase/uppercase letters, find the length of the
// longest palindrome that can be BUILT using those letters.

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : freq.values()) {
            length += (count / 2) * 2;   // add the largest even part of this count
            if (count % 2 == 1) {
                hasOdd = true;
            }
        }

        // one leftover odd-count character can sit in the middle
        if (hasOdd) length += 1;

        return length;
    }

    public static void main(String[] args) {
        LongestPalindrome sol = new LongestPalindrome();

        System.out.println(sol.longestPalindrome("abccccdd")); // 7
        System.out.println(sol.longestPalindrome("a"));        // 1
        System.out.println(sol.longestPalindrome("bb"));       // 2
    }
}
