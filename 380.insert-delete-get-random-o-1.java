/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {
    HashSet<Integer> h;

    public RandomizedSet() {
        // l=new ArrayList<>();
        h = new HashSet<>();
        // i=0;
    }

    public boolean insert(int val) {
        if (h.contains(val))
            return false;
        h.add(val);
        // l.add(val);
        // i++;
        return true;
    }

    public boolean remove(int val) {
        if (h.contains(val)) {
            h.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        Random random = new Random();
        Integer[] temp = h.toArray(new Integer[0]);
        return temp[random.nextInt(h.size())];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
// @lc code=end
