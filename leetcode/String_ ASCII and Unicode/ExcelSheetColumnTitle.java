// LeetCode 168: Excel Sheet Column Title
// https://leetcode.com/problems/excel-sheet-column-title/
// Difficulty: Easy

public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // shift to 0-indexed since this is a base-26 system without a zero digit
            char letter = (char) ('A' + (columnNumber % 26));
            sb.append(letter);
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle solution = new ExcelSheetColumnTitle();

        System.out.println(solution.convertToTitle(1));   // Expected: A
        System.out.println(solution.convertToTitle(28));  // Expected: AB
        System.out.println(solution.convertToTitle(701)); // Expected: ZY
    }
}
