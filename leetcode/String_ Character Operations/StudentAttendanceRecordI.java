// LeetCode 551: Student Attendance Record I
// https://leetcode.com/problems/student-attendance-record-i/
// Difficulty: Easy

public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int absentCount = 0;
        int consecutiveLate = 0;

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absentCount++;
                if (absentCount >= 2) {
                    return false; // more than one absence
                }
            }

            if (c == 'L') {
                consecutiveLate++;
                if (consecutiveLate >= 3) {
                    return false; // 3 or more consecutive lates
                }
            } else {
                consecutiveLate = 0; // reset streak on any non-'L' day
            }
        }

        return true;
    }

    public static void main(String[] args) {
        StudentAttendanceRecordI solution = new StudentAttendanceRecordI();

        System.out.println(solution.checkRecord("PPALLP")); // Expected: true
        System.out.println(solution.checkRecord("PPALLL")); // Expected: false
    }
}
