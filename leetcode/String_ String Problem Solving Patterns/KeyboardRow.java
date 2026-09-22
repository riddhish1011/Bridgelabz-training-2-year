// LeetCode 500: Keyboard Row
// https://leetcode.com/problems/keyboard-row/
// Difficulty: Easy

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {

    public String[] findWords(String[] words) {
        // map each lowercase letter to its keyboard row (0, 1, or 2)
        int[] rowOf = new int[26];
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        for (int r = 0; r < rows.length; r++) {
            for (char c : rows[r].toCharArray()) {
                rowOf[c - 'a'] = r;
            }
        }

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            int row = rowOf[lower.charAt(0) - 'a'];
            boolean sameRow = true;

            for (char c : lower.toCharArray()) {
                if (rowOf[c - 'a'] != row) {
                    sameRow = false;
                    break;
                }
            }

            if (sameRow) result.add(word);
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        KeyboardRow sol = new KeyboardRow();

        System.out.println(java.util.Arrays.toString(
                sol.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}))); // [Alaska, Dad]
        System.out.println(java.util.Arrays.toString(
                sol.findWords(new String[]{"omk"}))); // []
        System.out.println(java.util.Arrays.toString(
                sol.findWords(new String[]{"adsdf", "sfd"}))); // [adsdf, sfd]
    }
}
