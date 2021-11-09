/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        HashMap<Integer, Boolean> x = new HashMap<>();
        HashMap<Integer, Boolean> y = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    x.put(i, true);
                    y.put(j, true);
                }
            }
        }
        Set<Integer> xk = x.keySet();
        for (int t : xk) {
            for (int j = 0; j < matrix[0].length; j++)
                matrix[t][j] = 0;
        }
        Set<Integer> xy = y.keySet();
        for (int t : xy) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][t] = 0;
        }
    }
}
// @lc code=end
