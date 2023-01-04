import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode id=1078 lang=java
 *
 * [1078] Occurrences After Bigram
 */

// @lc code=start
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> ans = new ArrayList<>();
        Stack<String> s = new Stack<>();

        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (!s.isEmpty() && s.peek().equals(second)) {
                String sec = s.pop();

                if (!s.isEmpty() && s.peek().equals(first)) {
                    ans.add(arr[i]);
                }
                s.push(sec);
            }
            s.push(arr[i]);
        }
        return ans.toArray(new String[0]);
    }
}
// @lc code=end
