/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] a = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    a[i][j] = 1;
                    ans = 1;
                } else
                    a[i][j] = 0;
            }
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                if (a[i][j] != 0) {
                    int min = Integer.MAX_VALUE;
                    min = Math.min(min, a[i - 1][j]);
                    min = Math.min(min, a[i - 1][j - 1]);
                    min = Math.min(min, a[i][j - 1]);
                    if (min != 0) {
                        a[i][j] = min + 1;
                        ans = Math.max(ans, a[i][j]);
                    }
                }
            }
        }
        return ans * ans;
    }
}
// @lc code=end
