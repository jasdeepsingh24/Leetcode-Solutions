/*
 * @lc app=leetcode id=396 lang=java
 *
 * [396] Rotate Function
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        int F=0;
        int n=nums.length;
        
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            F+=nums[i]*i;
        }
        int max=F;
        for(int i=n-1;i>0;i--)
        {
            F+=sum-n*nums[i];
            max=Math.max(F,max);
        }
        return max;
    }
}
// @lc code=end

