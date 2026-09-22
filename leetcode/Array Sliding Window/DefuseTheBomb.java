// LeetCode 1652: Defuse the Bomb
// https://leetcode.com/problems/defuse-the-bomb/
// Difficulty: Easy

import java.util.Arrays;

public class DefuseTheBomb {

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result; // all zeros
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                // sum of next k elements (circular)
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
            } else {
                // sum of previous k elements (circular)
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n];
                }
            }
            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        DefuseTheBomb solution = new DefuseTheBomb();

        System.out.println(Arrays.toString(solution.decrypt(new int[]{5, 7, 1, 4}, 3)));  // Expected: [12, 10, 16, 13]
        System.out.println(Arrays.toString(solution.decrypt(new int[]{1, 2, 3, 4}, 0)));   // Expected: [0, 0, 0, 0]
        System.out.println(Arrays.toString(solution.decrypt(new int[]{2, 4, 9, 3}, -2)));  // Expected: [12, 5, 6, 13]
    }
}
