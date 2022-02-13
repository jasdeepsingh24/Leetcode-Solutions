/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int j = 0; j < dp[0].length; j++)
            dp[0][j] = -1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] <= j) {
                    if (dp[i - 1][j] != -1) {
                        if (dp[i][j - coins[i - 1]] != -1)
                            dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
                        else
                            dp[i][j] = dp[i - 1][j];
                    } else {
                        if (dp[i][j - coins[i - 1]] != -1)
                            dp[i][j] = dp[i][j - coins[i - 1]] + 1;
                        else
                            dp[i][j] = -1;
                    }
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
// @lc code=end
