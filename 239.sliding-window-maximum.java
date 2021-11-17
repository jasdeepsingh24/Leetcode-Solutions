/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    class Pair {
        int index;
        int val;

        Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> q = new PriorityQueue(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return b.val - a.val;
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int j = 0;
        ArrayList<Integer> l = new ArrayList<>();
        int[] ans = new int[n - k + 1];
        int z = 0;
        for (int i = 0; i < n; i++) {
            if (j >= k)
                break;
            q.add(new Pair(i, nums[i]));
            j++;

        }
        Pair t = q.peek();
        ans[z++] = t.val;
        map.put(0, nums[0]);

        for (int i = k; i < n; i++) {
            q.add(new Pair(i, nums[i]));
            Pair polled = q.peek();
            int f = 0;
            while (map.containsKey(polled.index)) {
                polled = q.poll();
                f = 1;
            }
            ans[z++] = polled.val;
            if (f == 1)
                q.add(polled);
            map.put(i + 1 - k, nums[i + 1 - k]);
        }
        return ans;
    }
}
// @lc code=end
