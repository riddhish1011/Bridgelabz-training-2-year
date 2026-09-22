// LeetCode 392: Is Subsequence
// https://leetcode.com/problems/is-subsequence/
// Difficulty: Easy

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence sol = new IsSubsequence();

        System.out.println(sol.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(sol.isSubsequence("axc", "ahbgdc")); // false
        System.out.println(sol.isSubsequence("", "ahbgdc"));    // true
    }
}
