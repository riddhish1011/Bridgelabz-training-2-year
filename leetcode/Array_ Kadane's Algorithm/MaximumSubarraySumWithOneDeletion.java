// LeetCode 1186: Maximum Subarray Sum with One Deletion
// https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
// Difficulty: Medium

public class MaximumSubarraySumWithOneDeletion {

    public int maximumSum(int[] arr) {
        int n = arr.length;

        // noDeletion: max subarray sum ending at i without any deletion
        // oneDeletion: max subarray sum ending at i with exactly one deletion used
        int noDeletion = arr[0];
        int oneDeletion = 0;
        int result = arr[0];

        for (int i = 1; i < n; i++) {
            // Update oneDeletion BEFORE noDeletion (uses previous noDeletion value):
            // either delete arr[i] (carry forward previous no-deletion sum),
            // or delete an earlier element (carry forward previous one-deletion sum) and add arr[i]
            oneDeletion = Math.max(oneDeletion + arr[i], noDeletion);

            // Standard Kadane's for no-deletion case
            noDeletion = Math.max(noDeletion + arr[i], arr[i]);

            result = Math.max(result, Math.max(noDeletion, oneDeletion));
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumSubarraySumWithOneDeletion solution = new MaximumSubarraySumWithOneDeletion();

        System.out.println(solution.maximumSum(new int[]{1, -2, 0, 3}));      // Expected: 4
        System.out.println(solution.maximumSum(new int[]{1, -2, -2, 3}));     // Expected: 3
        System.out.println(solution.maximumSum(new int[]{-1, -1, -1, -1}));   // Expected: -1
    }
}
