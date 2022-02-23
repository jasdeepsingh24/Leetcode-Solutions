/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int j = 1; j < dp[0].length; j++)
            dp[0][j] = Integer.MAX_VALUE - 1;
        for (int j = 1; j < dp[0].length; j++) {
            if (j % coins[0] == 0)
                dp[1][j] = j / coins[0];
            else
                dp[1][j] = Integer.MAX_VALUE - 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1] == Integer.MAX_VALUE - 1 ? -1 : dp[dp.length - 1][dp[0].length - 1];
    }

}
// @lc code=end
