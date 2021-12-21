/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = "";
        for (int i = 0; i < s.length() / 2; i++) {
            str += s.charAt(i) + "";
            if (s.length() % str.length() == 0) {
                boolean x = check(str, 0, s);
                if (x)
                    return true;
            }
        }
        return false;
    }

    private boolean check(String str, int i, String s) {
        if (i >= s.length())
            return true;

        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) != s.charAt(i))
                return false;
            i++;
        }
        return check(str, i, s);
    }
}
// @lc code=end
