// LeetCode 171: Excel Sheet Column Number
// https://leetcode.com/problems/excel-sheet-column-number/
// Difficulty: Easy

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (char c : columnTitle.toCharArray()) {
            int digit = c - 'A' + 1; // A=1, B=2, ... Z=26
            result = result * 26 + digit;
        }

        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber solution = new ExcelSheetColumnNumber();

        System.out.println(solution.titleToNumber("A"));   // Expected: 1
        System.out.println(solution.titleToNumber("AB"));  // Expected: 28
        System.out.println(solution.titleToNumber("ZY"));  // Expected: 701
    }
}
