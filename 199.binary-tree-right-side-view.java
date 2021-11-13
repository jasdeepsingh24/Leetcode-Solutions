/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        help(root, 0, map);

        Set<Integer> keys = map.keySet();
        List<Integer> l = new ArrayList<>();
        for (Integer key : keys)
            l.add(map.get(key));
        return l;
    }

    private void help(TreeNode root, int i, HashMap<Integer, Integer> map) {
        if (root == null)
            return;
        if (!map.containsKey(i))
            map.put(i, root.val);
        help(root.right, i + 1, map);
        help(root.left, i + 1, map);
    }
}
// @lc code=end
