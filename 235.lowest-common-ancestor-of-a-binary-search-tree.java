/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.val == p.val || root.val == q.val)
            return root;
        if (q.val > root.val && p.val < root.val || q.val < root.val && p.val > root.val)
            return root;
        TreeNode left = null;
        TreeNode right = null;
        if (p.val < root.val && q.val < root.val)
            left = lowestCommonAncestor(root.left, p, q);
        if (q.val > root.val && p.val > root.val)
            right = lowestCommonAncestor(root.right, p, q);

        if (left != null)
            return left;
        return right;
    }
}
// @lc code=end
