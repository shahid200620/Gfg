class Solution {
    public int minDiff(int k, int[] arr) {
        int l=arr.length;
        int[] pref=new int[l+1],suff=new int[l+1];
        int[] prefmx=new int[l+1],suffmx=new int[l+1];
        int mn=Integer.MAX_VALUE,mx=0;
        int ans=mn;
        pref[0]=Integer.MAX_VALUE;
        prefmx[0]=0;
        for(int i=0;i<l;i++){
            mn=Math.min(mn,arr[i]);
            mx=Math.max(mx,arr[i]);
            pref[i+1]=mn;
            prefmx[i+1]=mx;
        }
        mn=Integer.MAX_VALUE;
        mx=0;
        suff[l]=Integer.MAX_VALUE;
        suffmx[l]=0;
        for(int i=l-1;i>=0;i--){
            mn=Math.min(mn,arr[i]);
            mx=Math.max(mx,arr[i]);
            suff[i]=mn;
            suffmx[i]=mx;
        }
        for(int i=0;i<=l-k;i++){
            mn=Math.min(pref[i],suff[i+k]);
            mx=Math.max(prefmx[i],suffmx[i+k]);
            ans=Math.min(ans,mx-mn);
        }
        return ans;
    }
}