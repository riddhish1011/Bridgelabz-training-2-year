// LeetCode 455: Assign Cookies
// https://leetcode.com/problems/assign-cookies/
// Difficulty: Easy
// Greedy: sort both arrays, try to satisfy the least-greedy child with
// the smallest cookie that is big enough.

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0, cookie = 0;

        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                child++;
            }
            cookie++;
        }

        return child;
    }

    public static void main(String[] args) {
        AssignCookies sol = new AssignCookies();

        System.out.println(sol.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1})); // 1
        System.out.println(sol.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3})); // 2
    }
}
