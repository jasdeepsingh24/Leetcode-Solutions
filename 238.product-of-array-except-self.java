/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        boolean containsZero = false;
        HashSet<Integer> h = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                product = product * nums[i];
            else {
                containsZero = true;
                h.add(i);
            }

        }
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && containsZero == false)
                ans[i] = product / nums[i];
            else if (nums[i] == 0 && containsZero == true) {
                if (h.size() == 1)
                    ans[i] = product;
                else
                    ans[i] = 0;
            } else
                ans[i] = 0;
        }
        return ans;
    }
}
// @lc code=end
