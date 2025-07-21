class Solution {
    public int cntCoprime(int[] arr) {
        int maxVal = 0;
        for (int x : arr) {
            maxVal = Math.max(maxVal, x);
        }

        int[] freq = new int[maxVal + 1];
        for (int x : arr) {
            freq[x]++;
        }

        long count = 0;
        
        // Sieve for Mobius function
        int[] mu = new int[maxVal + 1];
        Arrays.fill(mu, 0);
        mu[1] = 1;
        
        for (int i = 1; i <= maxVal; i++) {
            for (int j = 2 * i; j <= maxVal; j += i) {
                mu[j] -= mu[i];
            }
        }
        
        for (int g = 1; g <= maxVal; g++) {
            if (mu[g] == 0) continue; 
            long currentMultiples = 0;
            for (int i = g; i <= maxVal; i += g) {
                currentMultiples += freq[i];
            }
            count += mu[g] * (currentMultiples * (currentMultiples - 1) / 2);
        }
        
        return (int) count;
    }
}