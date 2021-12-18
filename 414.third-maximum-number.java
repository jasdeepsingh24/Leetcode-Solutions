/*
 * @lc app=leetcode id=414 lang=java
 *
 * [414] Third Maximum Number
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        int prev=Integer.MAX_VALUE;
        int c=3;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--)
        {
            if(prev!=nums[i])
            {
                c--;
                prev=nums[i];
                if(c==0) return prev;
            }
        } 
        return nums[nums.length-1];
    }
}
// @lc code=end

