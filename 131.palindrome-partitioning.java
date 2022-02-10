/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    public HashMap<String, Boolean> p;
    public HashMap<String, List<List<String>>> map;

    public List<List<String>> partition(String s) {
        p = new HashMap<>();
        map = new HashMap<>();
        List<List<String>> ans = rec(s);
        // for(String key:map.keySet())
        // {
        // List<List<String>> l=map.get(key);
        // System.out.println(key+"-------------------------------------------");
        // for(int i=0;i<l.size();i++)
        // {
        // for(int j=0;j<l.get(i).size();j++)
        // System.out.print(l.get(i).get(j)+",");
        // }
        // System.out.println();
        // System.out.println(key+"-------------------------------------------");
        // }
        return ans;
    }

    public List<List<String>> rec(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s.length() == 0) {
            map.put(s, ans);
            return ans;
        }
        // if(map.containsKey(s))
        // return map.get(s);
        if (isPalindrome(s)) {
            List<String> t = new ArrayList<>();
            t.add(s);
            ans.add(t);
        }
        for (int i = 1; i < s.length(); i++) {
            String x = s.substring(0, i);
            if (!isPalindrome(x))
                continue;
            List<List<String>> sm = rec(s.substring(i));
            if (sm.size() == 0) {
                List<String> temp = new ArrayList<>();
                temp.add(x);
                sm.add(temp);
            } else {
                for (int j = 0; j < sm.size(); j++) {
                    sm.get(j).add(0, x);
                }
            }
            ans.addAll(sm);
        }
        // map.put(s,ans);
        return ans;
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 1 || s.length() == 0)
            return true;
        if (p.containsKey(s))
            return p.get(s);

        int n = s.length();
        boolean ans = isPalindrome(s.substring(1, n - 1));
        ans = ans && s.charAt(0) == s.charAt(n - 1);
        p.put(s, ans);
        return ans;
    }
}
// @lc code=end
