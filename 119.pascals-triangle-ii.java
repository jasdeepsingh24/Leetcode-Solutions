/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if (rowIndex == 0) {
            ans.add(1);
            return ans;
        }
        if (rowIndex == 1) {
            ans.add(1);
            ans.add(1);
            return ans;
        }

        List<Integer> smallAns = getRow(rowIndex - 1);

        ans.add(smallAns.get(0));
        for (int i = 0; i < smallAns.size() - 1; i++) {
            ans.add(smallAns.get(i) + smallAns.get(i + 1));
        }
        ans.add(smallAns.get(smallAns.size() - 1));
        return ans;
    }
}
// @lc code=end
