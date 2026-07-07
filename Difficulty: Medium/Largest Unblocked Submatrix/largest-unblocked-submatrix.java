class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        int count = 0;
        int maxRow = 0;
        int maxCol = 0;
        Set<Integer> xRows = new HashSet<>();
        Set<Integer> xCols = new HashSet<>();
        
        // Getting blocked rows and cols
        for(int[] a: arr) {
            xRows.add(a[0]);
            xCols.add(a[1]);
        }
        
        // Max row, search cols
        for(int i = 1; i <= m; i++) {
            if(xCols.contains(i)) {
                maxRow = Math.max(maxRow, count);
                count = 0;
            }
            else {
                count++;
            }
        }
        
        // Last row and reset
        maxRow = Math.max(maxRow, count);
        count = 0;
    
        // Max col, search rows
        for(int i = 1; i <= n; i++) {
            if(xRows.contains(i)) {
                maxCol = Math.max(maxCol, count);
                count = 0;
            }
            else {
                count++;
            }
        }
        
        // Last col
        maxCol = Math.max(maxCol, count);
        
        return maxRow * maxCol;
    }
}