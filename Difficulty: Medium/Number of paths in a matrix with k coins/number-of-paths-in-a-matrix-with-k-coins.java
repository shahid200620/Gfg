class Solution {
    public int recursion(int[][] mat, int k, int i, int j, int[][][] dp){
        if(i>=mat.length || j>=mat[0].length || k<0){ // if out of boud or k becomes negative
            return 0; // not a valid way
        }
        if(i==mat.length-1 && j==mat[0].length-1){ // at destination
            if(k==mat[i][j]) return 1; // if exaclty k coin collected after deat => valid way
            else return 0; // if not k coins => not a valid way
        }
        
        if(dp[i][j][k]!=-1){ // if already evaluated
            return dp[i][j][k]; // immediately return it
        }
        
        // move down + move left => exlpore
        return dp[i][j][k] = recursion(mat, k-mat[i][j], i+1, j, dp) + recursion(mat, k-mat[i][j], i, j+1, dp);
        
    }
    public int numberOfPath(int[][] mat, int k) {
        int[][][] dp = new int[mat.length][mat[0].length][k+1];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return recursion(mat, k, 0, 0, dp);
    }
}