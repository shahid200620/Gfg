class Solution {
    public static int balanceSums(int[][] mat) {
        int n = mat.length;
        
        long[] rowSum = new long[n];
        long[] colSum = new long[n];
        
        long totalOriginalSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
                totalOriginalSum += mat[i][j];
            }
        }

        long maxCurrentSum = 0;
        for (int i = 0; i < n; i++) {
            if (rowSum[i] > maxCurrentSum) {
                maxCurrentSum = rowSum[i];
            }
            if (colSum[i] > maxCurrentSum) {
                maxCurrentSum = colSum[i];
            }
        }
        
        long targetSum = maxCurrentSum;
        
        long totalOperations = (long)n * targetSum - totalOriginalSum;

        return (int) totalOperations;
    }
}