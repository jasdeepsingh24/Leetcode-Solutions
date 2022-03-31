/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Stack<Pair> s=new Stack<>();
        ArrayList<Pair> l=new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            l.add(new Pair(intervals[i][0],intervals[i][1]));
        }
        Collections.sort(l);
        s.push(l.get(0));
        for(int i=1;i<l.size();i++)
        {
            Pair t=s.peek();
            if(t.r>=l.get(i).l && t.l<=l.get(i).r)
            {
                Pair x=new Pair(Math.min(t.l,l.get(i).l),Math.max(l.get(i).r,t.r));
                s.pop();
                s.push(x);
            }
            else
            {
                Pair x=new Pair(l.get(i).l,l.get(i).r);
                s.push(x);
            }
        }
        int[][] ans=new int[s.size()][2];
        int i=0;
        while(!s.isEmpty())
        {
            Pair tt=s.pop();
            ans[i][0]=tt.l;
            ans[i][1]=tt.r;
            i++;
        }
        return ans;
    }
    class Pair implements Comparable<Pair>{
        int l;
        int r;
        Pair(){};
        Pair(int l,int r)
        {
            this.l=l;
            this.r=r;
        }
        public int compareTo(Pair e)
        {
            return l-e.l;
        }
    }
}
// @lc code=end

