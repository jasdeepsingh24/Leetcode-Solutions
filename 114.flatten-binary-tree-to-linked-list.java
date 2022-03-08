/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        root = fun(root).start;

    }

    public Pair fun(TreeNode root) {
        if (root == null) {
            return null;
        }

        Pair left = fun(root.left);
        Pair right = fun(root.right);

        root.left = null;

        if (left == null && right == null)
            return new Pair(root, root);
        else if (left == null) {
            root.right = right.start;
            return new Pair(root, right.end);
        } else if (right == null) {
            root.right = left.start;
            return new Pair(root, left.end);
        } else {
            root.right = left.start;
            left.end.right = right.start;
            return new Pair(root, right.end);
        }

    }

    class Pair {
        TreeNode start;
        TreeNode end;

        Pair() {
        }

        Pair(TreeNode start, TreeNode end) {
            this.start = start;
            this.end = end;
        }
    }
}
// @lc code=end
