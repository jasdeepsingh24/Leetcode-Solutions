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
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(map.containsKey(c))
                map.put(c,-1);
            else
                map.put(c,i);
        }
        int min=Integer.MAX_VALUE;
        int f=0;
        Set<Character> keys=map.keySet();
        for(Character k:keys)
        {
            if(map.get(k)>-1){
                min=Math.min(min,map.get(k));
                f=1;
            }
        }
        if(f==0) return -1;
        return min;
        
    }
}
// @lc code=end

