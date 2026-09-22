// LeetCode 290: Word Pattern
// https://leetcode.com/problems/word-pattern/
// Difficulty: Easy

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) return false;
            } else {
                charToWord.put(c, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) return false;
            } else {
                wordToChar.put(word, c);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        WordPattern solution = new WordPattern();

        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));     // Expected: true
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));    // Expected: false
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));     // Expected: false
    }
}
