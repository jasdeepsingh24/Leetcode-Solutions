/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int[][] a=new int[matrix.length][matrix[0].length];
        int n=matrix.length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=matrix[i][j];
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[j][n-1-i]=a[i][j];
            }
        }
    }
}
// @lc code=end

