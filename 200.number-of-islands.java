/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int c = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    c++;
                    markVisited(grid, i, j, vis);
                }
            }
        }
        return c;
    }

    private void markVisited(char[][] a, int i, int j, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length)
            return;
        if (a[i][j] != '1' || vis[i][j])
            return;

        vis[i][j] = true;
        markVisited(a, i, j + 1, vis);
        markVisited(a, i + 1, j, vis);
        markVisited(a, i, j - 1, vis);
        markVisited(a, i - 1, j, vis);
    }
}
// @lc code=end
