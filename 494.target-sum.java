/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int cz = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] == 0)
                cz++;
        }
        int s = sum + target;
        int s1 = s / 2;
        if (target > sum || s % 2 != 0)
            return 0;
        if (s1 < 0)
            s1 *= -1;
        int ans = countSubset(nums, s1);
        return ans * (int) Math.pow(2, cz);
    }

    public int countSubset(int[] a, int x) {
        int[][] dp = new int[a.length + 1][x + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a[i - 1] > j || a[i - 1] == 0)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i - 1]];
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
// @lc code=end
