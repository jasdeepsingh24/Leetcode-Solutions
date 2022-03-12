/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        char start = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == start) {
                    boolean vis[][] = new boolean[board.length][board[0].length];
                    boolean ans = fun(board, word, 0, i, j, vis);
                    if (ans)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean fun(char[][] board, String word, int p, int i, int j, boolean[][] vis) {
        if (p == word.length())
            return true;
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || vis[i][j] || board[i][j] != word.charAt(p))
            return false;

        vis[i][j] = true;
        boolean a = fun(board, word, p + 1, i, j - 1, vis);
        boolean b = fun(board, word, p + 1, i, j + 1, vis);
        boolean c = fun(board, word, p + 1, i + 1, j, vis);
        boolean d = fun(board, word, p + 1, i - 1, j, vis);

        boolean ans = a | b | c | d;
        if (!ans)
            vis[i][j] = false;
        return ans;
    }
}
// @lc code=end
