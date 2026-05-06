/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    public int getSize(Node root) {
        // code here
        if(root==null)return 0;
        int leftSize=getSize(root.left);
        int rightSize=getSize(root.right);
        return rightSize+leftSize+1;
    }
}