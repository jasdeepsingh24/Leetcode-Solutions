/*
 * @lc app=leetcode id=1128 lang=java
 *
 * [1128] Number of Equivalent Domino Pairs
 */

// @lc code=start
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> count = new HashMap<>();
        for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            // Use a string to represent the domino
            String key = a < b ? a + "-" + b : b + "-" + a;
            count.put(key, count.getOrDefault(key, 0) + 1);
        }

        // Calculate the number of pairs
        int pairs = 0;
        for (int c : count.values()) {
            pairs += c * (c - 1) / 2;
        }
        return pairs;
    }
}
// @lc code=end
