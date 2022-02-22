/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        // String x=inorder(root);
        // String y=revinorder(root);
        // return x.equals(y);
        if (root == null)
            return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode rl, TreeNode rr) {
        if (rl == null || rr == null)
            return rl == rr;
        if (rl.val != rr.val)
            return false;
        return check(rl.left, rr.right) && check(rl.right, rr.left);
    }
}
// @lc code=end
