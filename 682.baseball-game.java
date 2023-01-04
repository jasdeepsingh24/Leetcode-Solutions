import java.util.Stack;

/*
 * @lc app=leetcode id=682 lang=java
 *
 * [682] Baseball Game
 */

// @lc code=start
class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];

            switch (op) {
                case "+":
                    int first = s.pop();
                    int second = s.peek();
                    s.push(first);
                    s.push(first + second);
                    break;
                case "C":
                    s.pop();
                    break;
                case "D":
                    s.push(2 * s.peek());
                    break;
                default:
                    s.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while (!s.isEmpty()) {
            sum += s.pop();
        }
        return sum;
    }
}
// @lc code=end
