// LeetCode 709: To Lower Case
// https://leetcode.com/problems/to-lower-case/
// Difficulty: Easy

public class ToLowerCase {

    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // If the character is an uppercase letter (ASCII 'A'-'Z'),
            // add 32 to its ASCII value to get the lowercase equivalent
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        ToLowerCase solution = new ToLowerCase();

        System.out.println(solution.toLowerCase("Hello")); // Expected: hello
        System.out.println(solution.toLowerCase("here"));  // Expected: here
        System.out.println(solution.toLowerCase("LOVELY")); // Expected: lovely
    }
}
