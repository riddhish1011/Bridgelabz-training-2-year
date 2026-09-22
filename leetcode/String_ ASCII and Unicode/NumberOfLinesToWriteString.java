// LeetCode 806: Number of Lines To Write String
// https://leetcode.com/problems/number-of-lines-to-write-string/
// Difficulty: Easy

import java.util.Arrays;

public class NumberOfLinesToWriteString {

    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int currentLineWidth = 0;

        for (char c : s.toCharArray()) {
            int charWidth = widths[c - 'a']; // map 'a'-'z' to index 0-25

            if (currentLineWidth + charWidth > 100) {
                lines++;
                currentLineWidth = charWidth; // start new line with this character
            } else {
                currentLineWidth += charWidth;
            }
        }

        return new int[]{lines, currentLineWidth};
    }

    public static void main(String[] args) {
        NumberOfLinesToWriteString solution = new NumberOfLinesToWriteString();

        int[] widths1 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(Arrays.toString(solution.numberOfLines(widths1, "abcdefghijklmnopqrstuvwxyz"))); // Expected: [3, 60]

        int[] widths2 = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        System.out.println(Arrays.toString(solution.numberOfLines(widths2, "bbbcccdddaaa"))); // Expected: [2, 4]
    }
}
