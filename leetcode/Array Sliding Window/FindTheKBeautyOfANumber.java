// LeetCode 2269: Find the K-Beauty of a Number
// https://leetcode.com/problems/find-the-k-beauty-of-a-number/
// Difficulty: Easy

public class FindTheKBeautyOfANumber {

    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int count = 0;

        // Slide a window of size k over the digit string
        for (int i = 0; i + k <= s.length(); i++) {
            String window = s.substring(i, i + k);
            int divisor = Integer.parseInt(window);
            if (divisor != 0 && num % divisor == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FindTheKBeautyOfANumber solution = new FindTheKBeautyOfANumber();

        System.out.println(solution.divisorSubstrings(240, 2)); // Expected: 2
        System.out.println(solution.divisorSubstrings(430043, 2)); // Expected: 2
    }
}
