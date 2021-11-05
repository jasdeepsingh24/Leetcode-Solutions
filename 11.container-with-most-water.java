/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=0;
        while(i<j)
        {
            int diff=j-i;
            int min=Math.min(height[i],height[j]);
            
            max=Math.max(max,min*diff);
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return max;
    }
}
// @lc code=end

