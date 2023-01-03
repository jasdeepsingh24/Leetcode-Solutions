import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                s.push(c);
            else {
                if (s.isEmpty())
                    return false;
                else {
                    if (c == ')' && s.peek() == '(' || c == ']' && s.peek() == '[' || c == '}' && s.peek() == '{')
                        s.pop();
                    else
                        return false;
                }
            }
        }
        return s.isEmpty();
    }
}
// @lc code=end
