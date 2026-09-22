// LeetCode 657: Robot Return to Origin
// https://leetcode.com/problems/robot-return-to-origin/
// Difficulty: Easy

public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'U': y++; break;
                case 'D': y--; break;
                case 'L': x--; break;
                case 'R': x++; break;
            }
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        RobotReturnToOrigin solution = new RobotReturnToOrigin();

        System.out.println(solution.judgeCircle("UD"));   // Expected: true
        System.out.println(solution.judgeCircle("LL"));   // Expected: false
        System.out.println(solution.judgeCircle("UDLR")); // Expected: true
    }
}
