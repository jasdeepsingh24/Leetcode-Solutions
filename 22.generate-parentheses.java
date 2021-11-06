/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        return help(n,0,0,"");
    }
    private List<String> help(int n,int open,int close,String str)
    {
        List<String> ans=new ArrayList<>();
        if(close>open || open>n ||close>n)
        {
            return ans;
        }
        if(open==close && close==n)
        {
            ans.add(str);
            return ans;
        }
        List<String> x=help(n,open+1,close,str+"(");
        List<String> y=help(n,open,close+1,str+")");
        
        x.addAll(y);
        return x;
        
    }
}
// @lc code=end

