/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    class Pair {
        long smallest;
        long largest;
        boolean isBST;
    }

    public boolean isValidBST(TreeNode root) {
        // if(root==null || (root.left==null && root.right==null)) return true;
        return help(root).isBST;
    }

    private Pair help(TreeNode root) {
        Pair p = new Pair();
        p.smallest = (long) Integer.MAX_VALUE + 8;
        p.largest = (long) Integer.MIN_VALUE - 8;
        p.isBST = true;

        if (root == null)
            return p;

        Pair l = help(root.left);
        Pair r = help(root.right);

        if (l.isBST && r.isBST) {
            if (root.val > l.largest && root.val < r.smallest) {
                p.isBST = true;
                p.smallest = Math.min(root.val, l.smallest);
                p.largest = Math.max(root.val, r.largest);
            } else
                p.isBST = false;
        } else
            p.isBST = false;
        return p;

    }
}
// @lc code=end
