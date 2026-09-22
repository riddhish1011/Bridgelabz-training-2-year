// LeetCode 57: Insert Interval
// https://leetcode.com/problems/insert-interval/
// Difficulty: Medium
// Walk through in three phases: intervals fully before newInterval,
// intervals overlapping newInterval (merge them), then intervals fully after.

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 1) add all intervals ending before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2) merge all intervals that overlap with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // 3) add all remaining intervals starting after newInterval ends
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        InsertInterval sol = new InsertInterval();

        int[][] r1 = sol.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        for (int[] iv : r1) System.out.print(java.util.Arrays.toString(iv) + " ");
        // [1, 5] [6, 9]
        System.out.println();

        int[][] r2 = sol.insert(
                new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        for (int[] iv : r2) System.out.print(java.util.Arrays.toString(iv) + " ");
        // [1, 2] [3, 10] [12, 16]
        System.out.println();
    }
}
