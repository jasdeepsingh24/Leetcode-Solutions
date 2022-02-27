/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        return fun(nums, target, 0, nums.length - 1);
    }

    public int fun(int[] nums, int target, int l, int r) {
        if (l > r)
            return -1;
        int m = (l + r) / 2;
        if (nums[m] == target)
            return m;
        int x = fun(nums, target, l, m - 1);

        int y = fun(nums, target, m + 1, r);
        return Math.max(x, y);
    }
}
// @lc code=end
