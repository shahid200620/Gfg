class Solution {
    public static class DiaPair{
        boolean isBst=true;
        int minimum=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int num=0;
        
    }
     static int count=0;
     static int numMax=0;

    static int largestBst(Node root) {
        count=0;
        bst(root);
        return count;
        
    }
    public  static DiaPair bst(Node root){
        if(root==null) return new DiaPair();
        DiaPair left=bst(root.left);
        DiaPair right=bst(root.right);
        DiaPair node=new DiaPair();
        node.minimum=Math.min(root.data,left.minimum);
        node.max=Math.max(root.data,right.max);
        node.isBst=root.data>left.max &&root.data<right.minimum && left.isBst 
        && right.isBst?true:false;
        node.num=left.num+right.num+1;
        if(node.isBst && node.num>count) {
            count=node.num;
            numMax=node.num;
        }
        return node;
    }
}