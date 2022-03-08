/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        left.push(root);
        while (!left.isEmpty() || !right.isEmpty()) {
            if (left.isEmpty()) {
                left.push(right.pop());
            } else {
                TreeNode curr = left.pop();
                ans.add(curr.val);

                if (curr.left != null)
                    left.push(curr.left);
                if (curr.right != null)
                    right.push(curr.right);
            }

        }
        return ans;
    }
}
// @lc code=end
