import java.util.Stack;

/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        int popped = s1.pop();
        while (!s2.isEmpty())
            s1.push(s2.pop());
        return popped;
    }

    public int peek() {
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        int popped = s1.peek();
        while (!s2.isEmpty())
            s1.push(s2.pop());
        return popped;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
