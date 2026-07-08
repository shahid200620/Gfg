class Solution {
    
    private int[] dix = {-1, 1, 0, 0};
    private int[] diy = {0, 0, 1, -1};
    
    public int countCoordinates(int[][] mat) {
        // code here
        int cnt = 0, n = mat.length, m = mat[0].length;
        Queue<int[] > p = new ArrayDeque<>();
        Queue<int[] > q = new ArrayDeque<>();
        boolean[][] pv = new boolean[n][m];
        boolean[][] qv = new boolean[n][m];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i == 0 || j == 0) {
                    p.offer(new int[]{i, j});
                    pv[i][j] = true;
                }
                
                if(i == n-1 || j == m-1) {
                    q.offer(new int[]{i, j});
                    qv[i][j] = true;
                }
            }
        }
        
        while(!p.isEmpty()) {
            int[] curr = p.poll();
            int x = curr[0], y = curr[1];
            
            for(int i=0;i<4;i++) {
                int nx = x + dix[i], ny = y + diy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && 
                    !pv[nx][ny] && mat[x][y] <= mat[nx][ny]) {
                        pv[nx][ny] = true;
                        p.offer(new int[]{nx, ny});
                }
            }
        }
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            
            for(int i=0;i<4;i++) {
                int nx = x + dix[i], ny = y + diy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && 
                    !qv[nx][ny] && mat[x][y] <= mat[nx][ny]) {
                        qv[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                }
            }
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(pv[i][j] && qv[i][j]) cnt++;
            }
        }
        
        return cnt;
    }
}

