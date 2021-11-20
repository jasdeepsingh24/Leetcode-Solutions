/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {
    int i;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null,";

        String ans = root.val + ",";
        ans += serialize(root.left);
        ans += serialize(root.right);
        return ans;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] a = data.split(",");
        i = 0;
        return deserialize(a);
    }

    private TreeNode deserialize(String[] a) {
        if (i >= a.length)
            return null;
        if (a[i].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(a[i]));
        i++;
        root.left = deserialize(a);
        i++;
        root.right = deserialize(a);
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
