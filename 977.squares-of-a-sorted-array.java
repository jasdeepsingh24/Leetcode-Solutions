/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        int[] ans = new int[nums.length];

        for (int p = nums.length - 1; p >= 0; p--) {
            if (Math.pow(nums[l], 2) > Math.pow(nums[r], 2)) {
                ans[p] = nums[l] * nums[l];
                l++;
            } else {
                ans[p] = nums[r] * nums[r];
                r--;
            }
        }
        return ans;
    }
}
// @lc code=end
