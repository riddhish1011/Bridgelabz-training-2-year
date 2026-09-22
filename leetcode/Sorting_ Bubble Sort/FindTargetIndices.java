// LeetCode 2089: Find Target Indices After Sorting Array
// https://leetcode.com/problems/find-target-indices-after-sorting-array/
// Difficulty: Easy
// Sort, then any index i in the sorted array where nums[i] == target
// is a valid target index.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndices {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindTargetIndices sol = new FindTargetIndices();

        System.out.println(sol.targetIndices(new int[]{1, 2, 5, 2, 3}, 2)); // [1, 2]
        System.out.println(sol.targetIndices(new int[]{1, 2, 5, 2, 3}, 3)); // [3]
        System.out.println(sol.targetIndices(new int[]{1, 2, 5, 2, 3}, 5)); // [4]
    }
}
