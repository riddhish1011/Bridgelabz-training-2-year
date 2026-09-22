// LeetCode 8: String to Integer (atoi)
// https://leetcode.com/problems/string-to-integer-atoi/
// Difficulty: Medium

public class StringToIntegerAtoi {

    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();

        // 1. Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n) return 0;

        // 2. Handle optional sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Read digits and build the number, checking overflow as we go
        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;

            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        StringToIntegerAtoi solution = new StringToIntegerAtoi();

        System.out.println(solution.myAtoi("42"));            // Expected: 42
        System.out.println(solution.myAtoi("   -042"));        // Expected: -42
        System.out.println(solution.myAtoi("1337c0d3"));       // Expected: 1337
        System.out.println(solution.myAtoi("0-1"));            // Expected: 0
        System.out.println(solution.myAtoi("words and 987"));  // Expected: 0
    }
}
