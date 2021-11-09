/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        List<String> x = help(n);
        List<Integer> ans = new ArrayList<>();
        for (String t : x) {
            ans.add(Integer.parseInt(t, 2));
        }
        return ans;
    }

    private List<String> help(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 1) {
            ans.add("0");
            ans.add("1");
            return ans;
        }

        List<String> smallAns = help(n - 1);
        for (int i = 0; i < smallAns.size(); i++) {
            ans.add("0" + smallAns.get(i));
        }
        for (int i = smallAns.size() - 1; i >= 0; i--) {
            ans.add("1" + smallAns.get(i));
        }
        return ans;
    }
}
// @lc code=end
