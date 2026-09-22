// LeetCode 1346: Check If N and Its Double Exist
// https://leetcode.com/problems/check-if-n-and-its-double-exist/
// Difficulty: Easy
// Linear scan with a HashSet: for each number, look up whether its
// double or its half already exists among numbers seen so far.

import java.util.HashSet;
import java.util.Set;

public class CheckDoubleExist {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(num * 2) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        CheckDoubleExist sol = new CheckDoubleExist();

        System.out.println(sol.checkIfExist(new int[]{10, 2, 5, 3}));  // true (10 == 2*5)
        System.out.println(sol.checkIfExist(new int[]{3, 1, 7, 11})); // false
        System.out.println(sol.checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8})); // true
    }
}
