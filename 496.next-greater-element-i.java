/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (j < nums2.length) {
                if (nums2[j] == nums1[i])
                    break;
                j++;
            }
            while (j < nums2.length) {
                if (nums2[j] > nums1[i])
                    ans[i] = nums2[j];
            }
            if (ans[i] == 0)
                ans[i] = -1;
        }
        return ans;
    }
}
// @lc code=end
