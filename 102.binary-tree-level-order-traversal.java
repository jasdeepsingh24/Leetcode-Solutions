/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        ans.add(temp);

        temp = new ArrayList<>();
        TreeNode flag = root;
        TreeNode t = root;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                q.add(curr.left);
                temp.add(curr.left.val);
                t = curr.left;
            }
            if (curr.right != null) {
                q.add(curr.right);
                temp.add(curr.right.val);
                t = curr.right;
            }
            if (curr == flag && !temp.isEmpty()) {
                flag = t;
                ans.add(temp);
                temp = new ArrayList<>();
            }
        }
        return ans;
    }
}
// @lc code=end
