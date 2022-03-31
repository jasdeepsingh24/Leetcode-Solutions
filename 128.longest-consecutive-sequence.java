/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int ans = 0;
        int t = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1])
                t++;
            else if (nums[i] + 1 < nums[i + 1])
                t = 0;
            ans = Math.max(ans, t);
        }
        return ans + 1;
    }
}
// @lc code=end

