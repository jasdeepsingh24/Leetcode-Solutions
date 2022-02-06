/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        // map=new HashMap<>();
        // return rec(word1,word2);
        return dp(word1, word2);
    }

    public int dp(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = i;
        for (int j = 0; j < dp[0].length; j++)
            dp[0][j] = j;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
// @lc code=end
