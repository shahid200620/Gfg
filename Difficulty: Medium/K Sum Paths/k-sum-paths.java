class Solution {
    public int res = 0;
    
    public int countAllPaths(Node root, int k) {
        count(root, k);
        return res;
    }
    
    public void count(Node curr, int k){
        if(curr == null){
            return;
        }
        
        helper(curr, k, 0);   // start path from this node
        
        count(curr.left, k);  // try starting from left node
        count(curr.right, k); // try starting from right node
    }
    
    public void helper(Node curr, int k, int currSum){
        if(curr == null){
            return;
        }
        
        currSum += curr.data;   // include current node
        
        if(currSum == k){
            res++;              // found a valid path
        }
        
        helper(curr.left, k, currSum);
        helper(curr.right, k, currSum);
    }
}