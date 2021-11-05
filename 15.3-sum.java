/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        Arrays.sort(nums);
        HashSet<String> h=new HashSet<>();
        
        
        for(int i=0;i<nums.length;i++)
        {
            int j=i+1;
            int k=nums.length-1;
            
            while(j<k)
            {
                if(nums[i]+nums[j]+nums[k]==0)
                {
                    ArrayList<Integer> ll=new ArrayList<>();
                    ll.add(nums[i]);
                    ll.add(nums[j]);
                    ll.add(nums[k]);
                    String x=nums[i]+""+nums[j]+""+nums[k]+"";
                    
                    if(!h.contains(x)){
                        l.add(ll);
                        h.add(x);
                    }
                    
                    j++;
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k]>0)
                    k--;
                else
                    j++;
            }
        }
        return l;
    }
}
// @lc code=end

