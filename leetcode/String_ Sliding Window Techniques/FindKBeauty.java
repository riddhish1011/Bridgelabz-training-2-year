// LeetCode 2269: Find the K-Beauty of a Number
// https://leetcode.com/problems/find-the-k-beauty-of-a-number/
// Difficulty: Easy
// Fixed-size sliding window of length k over the digit string.

public class FindKBeauty {

    public int divisorSubstrings(int num, int k) {
        String s = Integer.toString(num);
        int count = 0;

        for (int i = 0; i + k <= s.length(); i++) {
            String window = s.substring(i, i + k);
            long divisor = Long.parseLong(window);

            if (divisor != 0 && num % divisor == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FindKBeauty sol = new FindKBeauty();

        System.out.println(sol.divisorSubstrings(240, 2)); // 2
        System.out.println(sol.divisorSubstrings(430043, 2)); // 2
    }
}
