import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxKPower(int n, int k) {
        Map<Integer, Integer> primeFactorsK = new HashMap<>();
        int tempK = k;
        for (int i = 2; i * i <= tempK; i++) {
            while (tempK % i == 0) {
                primeFactorsK.put(i, primeFactorsK.getOrDefault(i, 0) + 1);
                tempK /= i;
            }
        }
        if (tempK > 1) {
            primeFactorsK.put(tempK, primeFactorsK.getOrDefault(tempK, 0) + 1);
        }

        int minPower = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : primeFactorsK.entrySet()) {
            int prime = entry.getKey();
            int exponentK = entry.getValue();
            int countInNFactorial = 0;
            long p = prime;
            while (p <= n) {
                countInNFactorial += n / p;
                if (p > n / prime) break; 
                p *= prime;
            }
            minPower = Math.min(minPower, countInNFactorial / exponentK);
        }
        return minPower;
    }
}