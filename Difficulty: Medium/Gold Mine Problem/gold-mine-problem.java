class Solution {
    public int maxGold(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        
        int[][] dp = new int[R][C];
        
        for (int r = 0; r < R; r++) {
            dp[r][0] = mat[r][0];
        }
        
        for (int c = 1; c < C; c++) {
            for (int r = 0; r < R; r++) {
                int right = dp[r][c - 1];
                
                int rightUp = 0;
                if (r - 1 >= 0) {
                    rightUp = dp[r - 1][c - 1];
                }
                
                int rightDown = 0;
                if (r + 1 < R) {
                    rightDown = dp[r + 1][c - 1];
                }
                
                dp[r][c] = mat[r][c] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }
        
        int maxGoldCollected = 0;
        for (int r = 0; r < R; r++) {
            maxGoldCollected = Math.max(maxGoldCollected, dp[r][C - 1]);
        }
        
        return maxGoldCollected;
    }
}