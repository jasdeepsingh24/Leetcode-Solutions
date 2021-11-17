/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] > target)
                col = j - 1;
            else if (j == matrix[0].length - 1 && matrix[0][j] <= target)
                col = j;
        }
        while (col >= 0) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][col] == target)
                    return true;
            }
            --col;
        }
        return false;
    }
}
// @lc code=end
