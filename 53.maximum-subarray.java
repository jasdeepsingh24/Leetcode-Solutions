/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int maxh = 0, maxf = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxh += nums[i];
            maxf = Math.max(maxf, maxh);
            if (maxh < 0)
                maxh = 0;
        }
        return maxf;
    }
}
// @lc code=end
