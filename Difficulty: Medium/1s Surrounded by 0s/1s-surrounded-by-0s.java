class Solution {
    int []dr={-1,1,0,0};
    int []dc={0,0,-1,1};
    int cntOnes(int[][] grid) {
        // code here
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(i==0 || i==n-1 || j==0 || j==m-1 && grid[i][j]==1){
                    dfs(grid,i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int [][]grid , int x, int y){
        int n=grid.length;
        int m=grid[0].length;
        if(x<0 || x>n-1 || y<0 || y>m-1 || grid[x][y]!=1){
            return;
        }
        //make visited
        grid[x][y]=-1;
        for(int k=0;k<4;++k){
            dfs(grid,x+dr[k],y+dc[k]);
        }
    }
}; 