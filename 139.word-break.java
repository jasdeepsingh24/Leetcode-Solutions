/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> h = new HashSet<>();
        for (String w : wordDict)
            h.add(w);
        int[] dp = new int[s.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                String checkWord = s.substring(j, i + 1);
                if (h.contains(checkWord)) {
                    if (j > 0)
                        dp[i] += dp[j - 1];
                    else
                        dp[i] += 1;
                }
            }
        }
        return dp[dp.length - 1] > 0;
    }
}
// @lc code=end
