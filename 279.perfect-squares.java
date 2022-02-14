/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[][] dp = new int[(int) Math.sqrt(n) + 1][n + 1];
        for (int j = 0; j < dp[0].length; j++)
            dp[0][j] = Integer.MAX_VALUE;
        for (int i = 1; i < dp.length; i++) {
            int t = i * i;
            for (int j = 1; j < dp[0].length; j++) {
                if (t <= j) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - t] + 1);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
// @lc code=end
