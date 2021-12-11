/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int j=0;j<s.length();j++)
        {
            char x=s.charAt(j);
            int n=map.getOrDefault(x,0);
            map.put(x,n+1);
        }
        int i=0;
        while(i<s.length())
        {
            char c=s.charAt(i);
            System.out.println(c+"--"+map.get(c));
            if(map.get(c)<2)
                return i;
            i++;
        }
        return -1;
    }
}
// @lc code=end

