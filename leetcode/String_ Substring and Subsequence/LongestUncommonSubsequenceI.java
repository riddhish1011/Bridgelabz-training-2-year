// LeetCode 521: Longest Uncommon Subsequence I
// https://leetcode.com/problems/longest-uncommon-subsequence-i/
// Difficulty: Easy
//
// Key insight: for two strings a and b,
// - if a == b, every subsequence of one is also a subsequence of the other,
//   so no uncommon subsequence exists -> return -1.
// - if a != b, the longer string itself can never be a subsequence of the
//   shorter (or equal-length-but-different) one, so the longer string is
//   the answer. If lengths are equal (and strings differ), either works.

public class LongestUncommonSubsequenceI {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        LongestUncommonSubsequenceI sol = new LongestUncommonSubsequenceI();

        System.out.println(sol.findLUSlength("aba", "cdc")); // 3
        System.out.println(sol.findLUSlength("aaa", "bbb")); // 3
        System.out.println(sol.findLUSlength("aaa", "aaa")); // -1
    }
}
