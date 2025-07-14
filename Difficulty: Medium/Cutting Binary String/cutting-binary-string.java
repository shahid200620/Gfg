import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public int cuts(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        Set<Long> powersOf5 = new HashSet<>();
        long power = 1;
        for (int i = 0; i <= 29; i++) { // Max power of 5 such that it fits in a 30-bit binary number
            powersOf5.add(power);
            if (Long.MAX_VALUE / 5 < power) break; 
            power *= 5;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (sub.charAt(0) == '0' && sub.length() > 1) {
                    continue;
                }
                
                long decimalValue;
                try {
                    if (sub.length() > 29) { // A 30-character binary string can exceed Long.MAX_VALUE if it starts with 1
                        continue;
                    }
                    decimalValue = Long.parseLong(sub, 2);
                } catch (NumberFormatException e) {
                    continue; 
                }

                if (powersOf5.contains(decimalValue)) {
                    if (dp[j] != n + 1) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n] == n + 1 ? -1 : dp[n];
    }
}