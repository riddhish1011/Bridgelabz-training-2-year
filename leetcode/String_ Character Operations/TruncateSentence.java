// LeetCode 1816: Truncate Sentence
// https://leetcode.com/problems/truncate-sentence/
// Difficulty: Easy

public class TruncateSentence {

    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int wordCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                wordCount++;
                if (wordCount == k) {
                    break; // stop right before starting the (k+1)-th word
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TruncateSentence solution = new TruncateSentence();

        System.out.println(solution.truncateSentence("Hello how are you Contestant", 4)); // Expected: "Hello how are you"
        System.out.println(solution.truncateSentence("What is the solution to this problem", 4)); // Expected: "What is the solution"
        System.out.println(solution.truncateSentence("chopper is not a tanuki", 5)); // Expected: "chopper is not a tanuki"
    }
}
