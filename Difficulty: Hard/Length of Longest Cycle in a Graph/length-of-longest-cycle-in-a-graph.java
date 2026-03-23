class Solution {
    int maxLength = -1;
    int[] next;
    public int longestCycle(int V, int[][] edges) {
        next = new int[V];
        Arrays.fill(next, -1);
        
        for(int[] e : edges) {
            next[e[0]] = e[1];
        }
        
        for(int i=0; i<V; i++){
            
            int[] vis = new int[V];
            Arrays.fill(vis, -1);
            dfs(i, vis, edges, 0);
        }
        return maxLength;
    }
    void dfs(int node, int[] vis, int[][] edges, int steps){
        if(node == -1) return;
        if(vis[node] != -1) {
            maxLength = Math.max(steps - vis[node], maxLength);
            return;
        }
        vis[node] = steps++;
        dfs(next[node], vis, edges, steps);
    }
}