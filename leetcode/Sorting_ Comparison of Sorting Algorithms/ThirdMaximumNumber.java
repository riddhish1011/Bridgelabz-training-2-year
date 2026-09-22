// LeetCode 414: Third Maximum Number
// https://leetcode.com/problems/third-maximum-number/
// Difficulty: Easy
// Single pass, tracking the top 3 distinct values seen so far.

public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        Long first = null, second = null, third = null;

        for (int n : nums) {
            long num = n;

            if (first != null && num == first) continue;
            if (second != null && num == second) continue;
            if (third != null && num == third) continue;

            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }

        return (third != null) ? third.intValue() : first.intValue();
    }

    public static void main(String[] args) {
        ThirdMaximumNumber sol = new ThirdMaximumNumber();

        System.out.println(sol.thirdMax(new int[]{3, 2, 1}));    // 1
        System.out.println(sol.thirdMax(new int[]{1, 2}));       // 2
        System.out.println(sol.thirdMax(new int[]{2, 2, 3, 1})); // 1
    }
}
