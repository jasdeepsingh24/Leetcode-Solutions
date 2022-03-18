/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    class Pair {
        int val;
        int min;

        Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Stack<Pair> s;
    int size;

    public MinStack() {
        s = new Stack<>();
        size = 0;
    }

    public void push(int val) {
        if (!s.isEmpty()) {
            int prevMin = s.peek().min;
            if (val < prevMin)
                s.push(new Pair(val, val));
            else
                s.push(new Pair(val, prevMin));
        } else
            s.push(new Pair(val, val));
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek().val;
    }

    public int getMin() {
        return s.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
