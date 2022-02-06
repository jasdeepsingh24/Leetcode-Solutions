/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    int[] dp;

    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climb(n);
    }

    public int climb(int n) {
        if (n < 0)
            return -1;
        if (n == 0)
            return dp[n] = 1;
        if (dp[n] != -1)
            return dp[n];
        int x = climb(n - 1);
        int y = climb(n - 2);
        int ans = 0;
        if (x == -1)
            ans = y;
        else if (y == -1)
            ans = x;
        else
            ans = x + y;
        return dp[n] = ans;
    }
}
// @lc code=end
