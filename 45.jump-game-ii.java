/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    int[] dp;

    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rec(nums, 0);
    }

    public int rec(int[] a, int i) {
        if (i >= a.length)
            return -1;
        int ans = Integer.MAX_VALUE;
        if (i == a.length - 1)
            return dp[i] = 0;
        if (dp[i] != -1)
            return dp[i];
        for (int j = 1; j <= a[i]; j++) {
            int smallAns = rec(a, i + j) + 1;
            if (smallAns > 0)
                ans = Math.min(ans, smallAns);
        }
        return dp[i] = ans;
    }
}
// @lc code=end
