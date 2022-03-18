/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            left[i] = maxLeft;
            // System.out.print(left[i]);
        }
        // System.out.println();
        for (int i = n - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            right[i] = maxRight;
            // System.out.print(right[i]);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int maxHold = Math.min(left[i], right[i]);
            ans += maxHold - height[i];
        }
        return ans;
    }
}
// @lc code=end
