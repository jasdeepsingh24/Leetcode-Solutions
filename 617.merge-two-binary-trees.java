/*
 * @lc app=leetcode id=617 lang=java
 *
 * [617] Merge Two Binary Trees
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        int rt = 0;
        if (root1 != null)
            rt += root1.val;
        if (root2 != null)
            rt += root2.val;
        TreeNode root = new TreeNode(rt);

        root.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        root.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
        return root;
    }
}
// @lc code=end