/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    HashMap<Integer,ArrayList<Integer>> map;
    HashSet<Integer> h;
    HashSet<Integer> leafs;
    int countRemoved;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map=new HashMap<>();
        h=new HashSet<>();
        leafs=new HashSet<>();
        countRemoved=0;
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<prerequisites.length;i++)
        {
            int a=prerequisites[i][1];
            int b=prerequisites[i][0];
            
            if(!map.containsKey(b))
                map.put(b,new ArrayList<Integer>());
            map.get(b).add(a);
        }
        for(int i=0;i<numCourses;i++)
        {
            ArrayList<Integer> smallAns=DFS(i);
            if(smallAns.size()==0)
                return new int[0];
            ans.addAll(smallAns);
        }
        int[] ansArray=new int[ans.size()-countRemoved];
        int c=0;
        for(int i=0;i<ans.size();i++)
        {
            if(ans.get(i)==-1) continue;
            ansArray[c++]=ans.get(i);
        }
        return ansArray;
        
    }
    private ArrayList<Integer> DFS(int nodeData)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        if(h.contains(nodeData))
            return ans;
        if(!map.containsKey(nodeData))
        {
            if(!leafs.contains(nodeData))
                ans.add(nodeData);
            else
            {
                countRemoved++;
                ans.add(-1);
            }
            leafs.add(nodeData);
            return ans;
        }
        leafs.add(nodeData);
        h.add(nodeData);
        ArrayList<Integer> list=map.get(nodeData);
        for(int i=0;i<list.size();i++)
        {
            ArrayList<Integer> smallAns=DFS(list.get(i));
            if(smallAns.size()==0)
                return new ArrayList<Integer>();
            ans.addAll(smallAns);
        }
        // ans.add(0,nodeData);
        ans.add(nodeData);
        h.remove(nodeData);
        map.remove(nodeData);
        return ans;
    }
}
// @lc code=end

