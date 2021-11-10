/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] a = new Integer[rowIndex + 1];
        Arrays.fill(a, 0);
        a[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--)
                a[j] += a[j - 1];
        }

        return Arrays.asList(a);
    }
}
// @lc code=end
