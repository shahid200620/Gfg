class Solution {
    public int countSubarrays(int[] arr, int k) {
         return solve(arr,k)-solve(arr,k-1);
    }
    public int solve(int[]arr,int k)
    {
        int n=arr.length;
        int c=0,oc=0,left=0;
        for(int right=0;right<n;right++)
        {
            if(arr[right]%2==1)
            {
                oc++;
            }
            while(oc>k)
            {
                if(arr[left]%2==1)
                    oc--;
                left++;
            }
            c+=(right-left+1);
        }
        return c;
        
    }
}
