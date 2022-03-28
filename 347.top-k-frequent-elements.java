/*
* @lc app=leetcode id=347 lang=java
*
* [347] Top K Frequent Elements
*/

// @lc code=start
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer>[] arr = new ArrayList[nums.length + 1];
        Arrays.fill(arr, new ArrayList<>());
        for (Integer x : map.keySet()) {
            int p = map.get(x);
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(arr[p]);
            temp.add(x);
            arr[p] = temp;
        }
        int[] ans = new int[k--];
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i].size() == 0)
                continue;
            for (int j = 0; j < arr[i].size() && k >= 0; j++) {
                ans[k--] = arr[i].get(j);
            }
        }
        return ans;
    }
}
// @lc code=end
