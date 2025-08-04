class Solution {
    public int maxRectSum(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < m; left++) {
            int[] temp = new int[n];
            for (int right = left; right < m; right++) {
                for (int i = 0; i < n; i++) {
                    temp[i] += mat[i][right];
                }
                int currentSum = kadane(temp);
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    private int kadane(int[] arr) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        boolean allNegative = true;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                allNegative = false;
            }
            max_ending_here += arr[i];
            if (max_ending_here > max_so_far) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        
        if (allNegative) {
            max_so_far = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max_so_far) {
                    max_so_far = arr[i];
                }
            }
        }
        
        return max_so_far;
    }
}