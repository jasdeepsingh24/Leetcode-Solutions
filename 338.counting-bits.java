/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] a = new int[n + 1];
        int k = 0;
        for (int i = 1; i <= n; i++) {
            int d = a[i / 2];
            int r = i % 2;
            a[i] = d + r;
        }
        return a;
    }
}
// @lc code=end
