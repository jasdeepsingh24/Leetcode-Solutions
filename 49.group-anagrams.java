/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String sorted = sort(strs[i]);
            if (map.containsKey(sorted)) {
                List<String> l = map.get(sorted);
                l.add(strs[i]);
                map.put(sorted, l);
            } else {
                List<String> tt = new ArrayList<>();
                tt.add(strs[i]);
                map.put(sorted, tt);
            }
        }
        Set<String> keys = map.keySet();
        for (String key : keys) {
            ans.add(map.get(key));
        }
        return ans;
    }

    private String sort(String x) {
        char[] t = x.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
}
// @lc code=end
