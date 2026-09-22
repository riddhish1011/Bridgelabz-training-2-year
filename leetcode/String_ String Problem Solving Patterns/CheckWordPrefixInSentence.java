// LeetCode 1455: Check If a Word Occurs As a Prefix of Any Word in a Sentence
// https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
// Difficulty: Easy

public class CheckWordPrefixInSentence {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1; // 1-indexed
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        CheckWordPrefixInSentence sol = new CheckWordPrefixInSentence();

        System.out.println(sol.isPrefixOfWord("i love eating burger", "burg")); // 4
        System.out.println(sol.isPrefixOfWord("this problem is an easy problem", "pro")); // 2
        System.out.println(sol.isPrefixOfWord("i am tired", "you")); // -1
    }
}
