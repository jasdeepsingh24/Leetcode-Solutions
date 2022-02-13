/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    static int[] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rec(nums, 0);
    }

    public int rec(int[] nums, int p) {
        if (p >= nums.length)
            return 0;
        if (dp[p] != -1)
            return dp[p];
        int x = rec(nums, p + 1);
        int y = rec(nums, p + 2) + nums[p];

        return dp[p] = Math.max(x, y);
    }
}
// @lc code=end
