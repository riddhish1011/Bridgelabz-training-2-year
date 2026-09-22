// LeetCode 169: Majority Element
// https://leetcode.com/problems/majority-element/
// Difficulty: Easy

public class MajorityElement {

    // Boyer-Moore Voting Algorithm — O(n) time, O(1) space
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();

        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));                // Expected: 3
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));     // Expected: 2
    }
}
