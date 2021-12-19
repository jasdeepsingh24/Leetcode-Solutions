/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        ArrayList<Character> list = new ArrayList<Character>(map.keySet());

        // A simple way of sorting a HashMap on the basis of Values.
        Collections.sort(list, (a, b) -> map.get(b).compareTo(map.get(a)));
        String ans = "";

        for (int j = 0; j < list.size(); j++) {
            char c = list.get(j);
            int x = map.get(c);
            String sm = "";
            for (int i = 0; i < x; i++)
                sm += c + "";
            ans += sm + "";
        }
        return ans;
    }
}
// @lc code=end
