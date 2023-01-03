import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start
class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int popped = q1.poll();
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        return popped;
    }

    public int top() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int popped = q1.poll();
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        q1.add(popped);
        return popped;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
