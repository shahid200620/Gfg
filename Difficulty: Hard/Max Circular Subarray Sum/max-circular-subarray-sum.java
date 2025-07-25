class Solution {
    public int maxCircularSum(int arr[]) {
        int n = arr.length;
        int maxKadane = arr[0];
        int currentMax = arr[0];
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxKadane = Math.max(maxKadane, currentMax);
        }
        int totalSum = 0;
        for (int x : arr) {
            totalSum += x;
        }
        int minKadane = arr[0];
        int currentMin = arr[0];
        for (int i = 1; i < n; i++) {
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minKadane = Math.min(minKadane, currentMin);
        }
        if (totalSum == minKadane) {
            return maxKadane;
        }
        return Math.max(maxKadane, totalSum - minKadane);
    }
}