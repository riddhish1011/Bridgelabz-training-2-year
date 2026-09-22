// LeetCode 1295: Find Numbers with Even Number of Digits
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
// Difficulty: Easy
// Linear scan, counting digits of each number.

public class FindNumbersEvenDigits {

    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (digitCount(num) % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    private int digitCount(int num) {
        if (num == 0) return 1;
        int digits = 0;
        while (num != 0) {
            digits++;
            num /= 10;
        }
        return digits;
    }

    public static void main(String[] args) {
        FindNumbersEvenDigits sol = new FindNumbersEvenDigits();

        System.out.println(sol.findNumbers(new int[]{12, 345, 2, 6, 7896})); // 2
        System.out.println(sol.findNumbers(new int[]{555, 901, 482, 1771})); // 1
    }
}
