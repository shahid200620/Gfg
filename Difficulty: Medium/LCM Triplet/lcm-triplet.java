class Solution {
    long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd(a, b)) * b;
    }

    int lcmTriplets(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 6;

        long ans = 0;

        if (n % 2 != 0) {
            ans = (long) n * (n - 1) * (n - 2);
        } else {
            ans = (long) (n - 1) * (n - 2) * (n - 3);
            ans = Math.max(ans, lcm(lcm(n, n - 1), n - 2));
            if (n % 3 == 0) {
                ans = Math.max(ans, lcm(lcm(n - 1, n - 2), n - 3));
            } else {
                 ans = Math.max(ans, lcm(lcm(n, n - 1), n - 3));
            }
        }
        return (int) ans;
    }
}