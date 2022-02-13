/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    int x = dp[j];
                    if (dp[i] <= x) {
                        dp[i] = x + 1;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
// @lc code=end
