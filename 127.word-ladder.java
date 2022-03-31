/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> h=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        Queue<String> qq=new LinkedList<>();
        q.add(beginWord);
        
        for(int i=0;i<wordList.size();i++)
        {
            h.add(wordList.get(i));
        }
        int depth=0;
        while(!q.isEmpty())
        {
            String curr=q.poll();
            for(int i=97;i<=122;i++)
            {
                char x=(char)i;
                for(int j=0;j<curr.length();j++)
                {
                    String t=curr.substring(0,j)+x+curr.substring(j+1);
                    if(h.contains(t) && !t.equals(curr))
                    {
                        if(t.equals(endWord))
                            return depth+2;
                        h.remove(t);
                        qq.add(t);
                    }
                }
            }
            if(q.isEmpty())
            {
                depth++;
                while(!qq.isEmpty())
                    q.add(qq.poll());
            }
        }
        return 0;
    }
}
// @lc code=end

