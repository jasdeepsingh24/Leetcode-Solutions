/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++)
            q.add(nums[i]);
        int ans = 0;
        while (k > 0) {
            ans = q.poll();
            k--;
        }
        return ans;
    }
}
// @lc code=end
