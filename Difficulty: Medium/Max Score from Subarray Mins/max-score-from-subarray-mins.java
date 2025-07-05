class Solution {
    public int maxSum(int[] arr) {
        int maxScore = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int currentSum = arr[i] + arr[i + 1];
            if (currentSum > maxScore) {
                maxScore = currentSum;
            }
        }
        return maxScore;
    }
}
