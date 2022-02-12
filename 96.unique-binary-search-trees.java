/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    static int[] dp;

    public int numTrees(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return rec(n);
    }

    public int rec(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;
        if (n < 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = rec(i);
            int r = rec(n - 1 - i);
            int smallAns = 0;
            if (l == 0)
                smallAns = r;
            else if (r == 0)
                smallAns = l;
            else
                smallAns = l * r;
            ans += smallAns;
        }
        return dp[n] = ans;
    }
}
// @lc code=end
