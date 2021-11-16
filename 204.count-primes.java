/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
import java.util.*;

class Solution {
    public int countPrimes(int n) {
        if (n < 2)
            return 0;
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i * i < primes.length; i++) {
            for (int j = i; j * i < primes.length; j++) {
                primes[i * j] = false;
            }
        }
        int c = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i])
                c++;
        }
        return c;
    }
}
// @lc code=end
