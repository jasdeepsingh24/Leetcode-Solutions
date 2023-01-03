/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
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
    HashMap<Integer, Integer> map;
    int paths;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        map = new HashMap<>();
        map.put(0, 1);
        paths = 0;
        path(root, targetSum, root.val);
        return paths;
    }

    public void path(TreeNode root, int targetSum, int currSum) {
        if (root == null)
            return;

        int r = currSum - targetSum;
        if (map.containsKey(r))
            paths += map.get(r);

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        if (root.left != null)
            path(root.left, targetSum, currSum + root.left.val);
        if (root.right != null)
            path(root.right, targetSum, currSum + root.right.val);
        if (map.get(currSum) > 1)
            map.put(currSum, map.get(currSum) - 1);
        else
            map.remove(currSum);
    }
}
// @lc code=end
