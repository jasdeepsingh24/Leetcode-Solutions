/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (is > ie)
            return null;
        TreeNode root = new TreeNode(preorder[ps]);

        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        int PSL = ps + 1;
        int PEL = rootIndex - is + ps;
        int PSR = PEL + 1;
        int PER = pe;

        int ISL = is;
        int IEL = rootIndex - 1;
        int ISR = rootIndex + 1;
        int IER = ie;

        root.left = buildTree(preorder, inorder, PSL, PEL, ISL, IEL);
        root.right = buildTree(preorder, inorder, PSR, PER, ISR, IER);

        return root;
    }
}
// @lc code=end
