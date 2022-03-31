/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int threshHold = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) > threshHold)
                return x;
        }
        return 0;
    }
}
// @lc code=end

