// LeetCode 1763: Longest Nice Substring
// https://leetcode.com/problems/longest-nice-substring/
// Difficulty: Easy
//
// A "nice" substring has, for every letter present, both its upper and
// lower case versions. Brute force over all substrings, checked with a bitmask.

public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        String best = "";

        for (int i = 0; i < s.length(); i++) {
            int lowerMask = 0, upperMask = 0;

            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (Character.isLowerCase(c)) {
                    lowerMask |= (1 << (c - 'a'));
                } else {
                    upperMask |= (1 << (Character.toLowerCase(c) - 'a'));
                }

                if (lowerMask == upperMask && (j - i + 1) > best.length()) {
                    best = s.substring(i, j + 1);
                }
            }
        }

        return best;
    }

    public static void main(String[] args) {
        LongestNiceSubstring sol = new LongestNiceSubstring();

        System.out.println(sol.longestNiceSubstring("YazaAay")); // "aAa"
        System.out.println(sol.longestNiceSubstring("Bb"));      // "Bb"
        System.out.println(sol.longestNiceSubstring("c"));       // ""
    }
}
