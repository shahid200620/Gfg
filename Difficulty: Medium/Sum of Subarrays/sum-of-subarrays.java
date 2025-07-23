class Solution {
    public int subarraySum(int[] arr) {
        long totalSum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            totalSum += (long) arr[i] * (i + 1) * (n - i);
        }
        return (int) totalSum;
    }
}