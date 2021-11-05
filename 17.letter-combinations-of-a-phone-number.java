/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        {
            List<String> l=new ArrayList<>();
            return l;
        }
        List<String> smallAns=letterCombinations(digits.substring(1));
        char x=digits.charAt(0);
        String r=getLetters(Integer.parseInt(x+""));
        List<String> ans=new ArrayList<>();
        
        for(int i=0;i<r.length();i++)
        {
            String itemi=r.charAt(i)+"";
            for(int j=0;j<smallAns.size();j++)
            {
                String item="";
                item=itemi+smallAns.get(j)+"";
                ans.add(item);
            }
            if(smallAns.size()==0)
                ans.add(itemi);
        }
        return ans;
    }
    private String getLetters(int x)
    {
        String r="";
        switch(x)
        {
            case 2:
                r="abc";
                break;
            case 3:
                r="def";
                break;
            case 4:
                r="ghi";
                break;
            case 5:
                r="jkl";
                break;
            case 6:
                r="mno";
                break;
            case 7:
                r="pqrs";
                break;
            case 8:
                r="tuv";
                break;
            case 9:
                r="wxyz";
                break;   
        }
        return r;
    }
}
// @lc code=end

