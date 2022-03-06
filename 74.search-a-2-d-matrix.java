/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (matrix[i][m - 1] < target)
                continue;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
            return false;
        }
        return false;
    }
}
// @lc code=end
