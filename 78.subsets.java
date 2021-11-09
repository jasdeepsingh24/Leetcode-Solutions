/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    private List<List<Integer>> subsets(int[] nums, int i) {
        List<List<Integer>> ans = new ArrayList<>();
        if (i == nums.length) {
            List<Integer> t = new ArrayList<>();
            ans.add(t);
            return ans;
        }

        List<List<Integer>> smallAns = subsets(nums, i + 1);

        for (int j = 0; j < smallAns.size(); j++) {
            List<Integer> l = new ArrayList<Integer>();
            List<Integer> sm = smallAns.get(j);
            l.add(nums[i]);
            l.addAll(sm);
            ans.add(l);
        }
        ans.addAll(smallAns);
        return ans;
    }
}
// @lc code=end
