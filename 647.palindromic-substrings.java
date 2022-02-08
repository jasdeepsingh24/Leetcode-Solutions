/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int c = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                dp[i][j] = true;
        }
        for (int k = 1; k < n; k++) {
            int i = 0, j = k;
            while (j < n) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j])
                        c++;
                } else
                    dp[i][j] = false;
                j++;
                i++;
            }
        }
        return c;
    }
}
// @lc code=end
