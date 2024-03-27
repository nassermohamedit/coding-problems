/**
 * tags: dp
 * statement: https://leetcode.com/problems/climbing-stairs/description/
 */

class ClimbingStairs {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        for (int i=2; i<=n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
