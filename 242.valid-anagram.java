/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        // 95% sol
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        for (char c : t.toCharArray())
            count[c - 'a']--;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;

        // 10% sol
        // if(s.length()!=t.length()) return false;
        // HashMap<Character,Integer> map=new HashMap<>();
        // for(int i=0;i<t.length();i++)
        // {
        // map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        // }

        // for(int i=0;i<s.length();i++)
        // {
        // char x=s.charAt(i);
        // if(!map.containsKey(x))
        // return false;
        // else
        // {
        // int c=map.get(x);
        // --c;
        // if(c>0)
        // map.put(x,c);
        // else
        // map.remove(x);
        // }
        // }
        // return true;
    }
}
// @lc code=end
