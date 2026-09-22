// LeetCode 164: Maximum Gap
// https://leetcode.com/problems/maximum-gap/
// Difficulty: Medium
// Must run in O(n) time using linear-time/space sorting. Uses bucket sort:
// with n numbers spanning [min, max], the max possible gap is at least
// ceil((max-min)/(n-1)), so we can bucket numbers into buckets of that
// size and the answer is guaranteed to come from BETWEEN buckets
// (never within a bucket), since each bucket's own range is smaller
// than the guaranteed gap.

public class MaximumGap {

    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0;

        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        java.util.Arrays.fill(bucketMin, Integer.MAX_VALUE);
        java.util.Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int num : nums) {
            int idx = (num - min) / bucketSize;
            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
        }

        int maxGap = 0;
        int prevMax = min;

        for (int i = 0; i < bucketCount; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) continue; // empty bucket
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }

    public static void main(String[] args) {
        MaximumGap sol = new MaximumGap();

        System.out.println(sol.maximumGap(new int[]{3, 6, 9, 1}));    // 3
        System.out.println(sol.maximumGap(new int[]{10}));            // 0
    }
}
