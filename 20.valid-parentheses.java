/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String str) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char x=str.charAt(i);
            if(x=='('||x=='{'||x=='[')
                s.push(x);
            else
            {
                if(!s.isEmpty()){
                    if( x==')'&& s.peek()=='(' || x=='}'&& s.peek()=='{'||x==']'&& s.peek()=='[')
                        s.pop();
                    else
                        s.push(x);
                }
                else
                    s.push(x);
            }
        }
        if(s.size()==0) return true;
        return false;
    }
}
// @lc code=end

