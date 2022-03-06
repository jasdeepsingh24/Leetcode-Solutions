/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    // HashMap<String,Integer> map;
    public List<List<Integer>> permute(int[] nums) {
        // map=new HashMap<>();
        List<Integer> l = new ArrayList<>();
        String key = "";
        for (int i = 0; i < nums.length; i++) {
            l.add(nums[i]);
            key += nums[i] + ",";
        }
        return fun(l);
    }

    public List<List<Integer>> fun(List<Integer> l) {
        List<List<Integer>> ans = new ArrayList<>();
        // if(map.containsKey(key))
        // return map.get(key);
        for (int i = 0; i < l.size(); i++) {
            int t = l.remove(i);

            List<List<Integer>> x = fun(l);
            l.add(i, t);
            if (x.size() == 0) {
                List<Integer> temp = new ArrayList<>();
                temp.add(t);
                ans.add(temp);
            } else {
                for (int j = 0; j < x.size(); j++) {
                    x.get(j).add(t);
                }
            }

            ans.addAll(x);
        }
        // map.put(key,ans);
        return ans;
    }
}
// @lc code=end
