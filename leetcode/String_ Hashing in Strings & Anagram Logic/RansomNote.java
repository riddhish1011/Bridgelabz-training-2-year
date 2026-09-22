// LeetCode 383: Ransom Note
// https://leetcode.com/problems/ransom-note/
// Difficulty: Easy

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0) {
                return false; // not enough of this character in magazine
            }
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote solution = new RansomNote();

        System.out.println(solution.canConstruct("a", "b"));       // Expected: false
        System.out.println(solution.canConstruct("aa", "ab"));     // Expected: false
        System.out.println(solution.canConstruct("aa", "aab"));    // Expected: true
    }
}
