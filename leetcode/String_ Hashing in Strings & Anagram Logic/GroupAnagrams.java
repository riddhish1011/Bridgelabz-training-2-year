// LeetCode 49: Group Anagrams
// https://leetcode.com/problems/group-anagrams/
// Difficulty: Medium

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // Map: sorted-word (key) -> list of original words that are anagrams of each other
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(input));
        // Expected (order may vary): [[eat, tea, ate], [tan, nat], [bat]]
    }
}
