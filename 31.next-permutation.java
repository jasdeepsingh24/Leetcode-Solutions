/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            // sortRemainingArray(nums,0);
            Arrays.sort(nums);
            return;
        }
        int minNext = Integer.MAX_VALUE;
        int nexti = -1;
        // PriorityQueue<Integer> q=new PriorityQueue<Integer>();
        for (int i = index + 1; i < n; i++) {

            if (nums[i] > nums[index] && nums[i] < minNext) {
                minNext = nums[i];
                nexti = i;
            }
        }
        if (nexti == -1)
            return;

        int temp = nums[index];
        nums[index] = nums[nexti];
        nums[nexti] = temp;
        sortRemainingArray(nums, index + 1);

    }

    public void sortRemainingArray(int[] nums, int p) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = p; i < nums.length; i++)
            q.add(nums[i]);
        for (int i = p; i < nums.length; i++)
            nums[i] = q.poll();
    }
}
// @lc code=end
