/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int m = 0;
        int r = nums.length - 1;

        while (m <= r) {
            if (nums[m] == 0) {
                int temp = nums[m];
                nums[m] = nums[l];
                nums[l] = temp;
                l++;
                m++;
            } else if (nums[m] == 1) {
                m++;
            } else {
                int temp = nums[m];
                nums[m] = nums[r];
                nums[r] = temp;
                r--;
            }
        }
    }
}
// @lc code=end
