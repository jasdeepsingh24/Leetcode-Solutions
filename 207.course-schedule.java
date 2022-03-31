/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    HashMap<Integer,ArrayList<Integer>> map;
    HashSet<Integer> h;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length<1 || prerequisites[0].length<2)
            return true;
        
        map=new HashMap<>();
        h=new HashSet<>();
        for(int i=0;i<prerequisites.length;i++)
        {
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            
            if(!map.containsKey(b))
            {
                
                map.put(b,new ArrayList<Integer>());
            }
            ArrayList<Integer> lb=map.get(b);
            lb.add(a);
        }
        for(int i=0;i<numCourses;i++)
        {
            if(!DFS(i))
                return false;
        }
        return true;
    }
    private boolean DFS(int nodeData)
    {
        if(!map.containsKey(nodeData))
            return true;
        if(h.contains(nodeData))
            return false;
        h.add(nodeData);
        ArrayList<Integer> list=map.get(nodeData);
        for(int i=0;i<list.size();i++)
        {
            if(!DFS(list.get(i)))
                return false;
        }
        map.remove(nodeData);
        h.remove(nodeData);
        return true;
    }
}
// @lc code=end

