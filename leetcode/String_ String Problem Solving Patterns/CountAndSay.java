// LeetCode 38: Count and Say
// https://leetcode.com/problems/count-and-say/
// Difficulty: Medium

public class CountAndSay {

    public String countAndSay(int n) {
        String result = "1";

        for (int i = 2; i <= n; i++) {
            result = nextTerm(result);
        }

        return result;
    }

    private String nextTerm(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char current = s.charAt(i);
            int count = 0;

            while (i < s.length() && s.charAt(i) == current) {
                count++;
                i++;
            }

            sb.append(count).append(current);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay sol = new CountAndSay();

        System.out.println(sol.countAndSay(1)); // "1"
        System.out.println(sol.countAndSay(4)); // "1211"
        System.out.println(sol.countAndSay(5)); // "111221"
    }
}
