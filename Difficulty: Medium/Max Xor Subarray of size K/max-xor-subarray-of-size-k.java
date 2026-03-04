class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int ans=Integer.MIN_VALUE;
        int xor=0;
        int n=arr.length;
        for(int i=0;i<k;i++)
        {
            xor=xor^arr[i];
        }
        ans=Math.max(ans,xor);
        for(int i=k;i<n;i++)
        {
            xor=xor^arr[i];
            xor=xor^arr[i-k];
            ans=Math.max(ans,xor);
        }
        
        return ans;
    }
}

