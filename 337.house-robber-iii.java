/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public int rob(TreeNode root) {
        Pair ans = fun(root);
        return Math.max(ans.inc, ans.exc);
    }

    public Pair fun(TreeNode root) {
        if (root == null) {
            Pair p = new Pair(0, 0);
            return p;
        }
        if (root.left == null && root.right == null) {
            Pair p = new Pair(root.val, 0);
            return p;
        }
        Pair l = fun(root.left);
        Pair r = fun(root.right);

        int include = root.val + l.exc + r.exc;
        int exclude = Math.max(l.inc, l.exc) + Math.max(r.inc, r.exc);

        Pair ans = new Pair(include, exclude);
        return ans;
    }

    class Pair {
        int inc;
        int exc;

        Pair() {
        }

        Pair(int inc, int exc) {
            this.inc = inc;
            this.exc = exc;
        }
    }
}
// @lc code=end
