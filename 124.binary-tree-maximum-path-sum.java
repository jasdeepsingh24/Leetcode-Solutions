/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
    static int global;

    public int maxPathSum(TreeNode root) {
        global = Integer.MIN_VALUE;
        fun(root);
        return global;
    }

    public int fun(TreeNode root) {
        if (root == null)
            return 0;
        int l = fun(root.left);
        int r = fun(root.right);

        int max_num = root.val + Math.max(l, r);
        int totalSum = root.val + l + r;
        totalSum = Math.max(totalSum, Math.max(root.val, max_num));

        global = Math.max(global, totalSum);
        return Math.max(max_num, root.val);

    }
}
// @lc code=end
