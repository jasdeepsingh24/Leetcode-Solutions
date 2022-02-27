/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = getIndex(nums, target, 0, nums.length - 1);
        int[] ans = new int[2];

        if (index <= -1) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        } else {
            int t = index;
            while (t >= 0) {
                if (nums[t] != target)
                    break;
                t--;
            }
            ans[0] = t + 1;
            t = index;
            while (t <= nums.length - 1 && nums[t] == target)
                t++;
            ans[1] = t - 1;
            return ans;
        }

    }

    public int getIndex(int[] nums, int target, int l, int r) {
        if (l > r)
            return -1;
        int m = (l + r) / 2;
        if (nums[m] == target)
            return m;

        int x = getIndex(nums, target, l, m - 1);
        int y = getIndex(nums, target, m + 1, r);
        return Math.max(x, y);
    }
}
// @lc code=end
