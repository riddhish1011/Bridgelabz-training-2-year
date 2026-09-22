// LeetCode 1876: Substrings of Size Three with Distinct Characters
// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
// Difficulty: Easy
// Fixed-size (3) sliding window.

public class SubstringsSizeThreeDistinct {

    public int countGoodSubstrings(String s) {
        int count = 0;

        for (int i = 0; i + 3 <= s.length(); i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);

            if (a != b && b != c && a != c) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        SubstringsSizeThreeDistinct sol = new SubstringsSizeThreeDistinct();

        System.out.println(sol.countGoodSubstrings("xyzzaz")); // 1
        System.out.println(sol.countGoodSubstrings("aababcabc")); // 4
    }
}
