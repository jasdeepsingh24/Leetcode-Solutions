/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 2 != 0)
            return false;
        sum /= 2;
        return subset(nums, sum);

    }

    public boolean subset(int[] a, int x) {
        boolean[][] dp = new boolean[a.length + 1][x + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - a[i - 1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
// @lc code=end
