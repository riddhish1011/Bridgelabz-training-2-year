// LeetCode 520: Detect Capital
// https://leetcode.com/problems/detect-capital/
// Difficulty: Easy

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        int upperCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }

        // Valid if: all uppercase, all lowercase, or only the first letter is uppercase
        boolean allUpper = upperCount == word.length();
        boolean allLower = upperCount == 0;
        boolean onlyFirstUpper = upperCount == 1 && Character.isUpperCase(word.charAt(0));

        return allUpper || allLower || onlyFirstUpper;
    }

    public static void main(String[] args) {
        DetectCapital solution = new DetectCapital();

        System.out.println(solution.detectCapitalUse("USA"));   // Expected: true
        System.out.println(solution.detectCapitalUse("FlaG"));  // Expected: false
        System.out.println(solution.detectCapitalUse("leetcode")); // Expected: true
        System.out.println(solution.detectCapitalUse("Google")); // Expected: true
    }
}
