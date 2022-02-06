/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    boolean[] dp;

    public boolean canJump(int[] nums) {
        dp = new boolean[nums.length];
        boolean ans = topdown(nums);
        return ans;
    }

    public boolean topdown(int[] a) {
        dp[a.length - 1] = true;
        int trueIndex = a.length - 1;
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] + i >= trueIndex) {
                trueIndex = i;
                dp[i] = true;
            } else
                dp[i] = false;
        }
        return dp[0];
    }
}
// @lc code=end
