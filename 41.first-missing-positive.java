/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                nums[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < 0 || index >= nums.length)
                continue;
            else {
                if (nums[index] == 0)
                    nums[index] = (nums.length + 1) * -1;
                else if (nums[index] < 0)
                    continue;
                else
                    nums[index] *= -1;
            }
        }
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0)
                return ans;
            ans++;
        }
        return ans;
    }
}
// @lc code=end
