// LeetCode 459: Repeated Substring Pattern
// https://leetcode.com/problems/repeated-substring-pattern/
// Difficulty: Easy
//
// Trick: if s is made of repeated substrings, then s must appear inside
// (s + s) with the first and last characters removed (to avoid the
// trivial match at the very start/end).

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        String doubled = (s + s).substring(1, 2 * s.length() - 1);
        return doubled.contains(s);
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern sol = new RepeatedSubstringPattern();

        System.out.println(sol.repeatedSubstringPattern("abab"));     // true
        System.out.println(sol.repeatedSubstringPattern("aba"));      // false
        System.out.println(sol.repeatedSubstringPattern("abcabcabcabc")); // true
    }
}
