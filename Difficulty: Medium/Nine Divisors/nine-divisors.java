import java.util.ArrayList;

class Solution {
    public static int countNumbers(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[(int) Math.sqrt(n) + 1];
        for (int i = 0; i <= (int) Math.sqrt(n); i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                primes.add(p);
                for (int i = p * p; i <= (int) Math.sqrt(n); i += p) {
                    isPrime[i] = false;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if ((long) primes.get(i) * primes.get(i) * primes.get(j) * primes.get(j) <= n) {
                    count++;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < primes.size(); i++) {
            if ((long) Math.pow(primes.get(i), 8) <= n) {
                count++;
            }
        }

        return count;
    }
}