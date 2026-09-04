class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        // code here
        int l=arr.size(),pref[]=new int[l+1];
        for(int i=0;i<l;i++){
            pref[i+1]=pref[i]+arr.get(i);
        }
        int ans=0;
        int d=m/l;
        ans+=pref[l]*d;
        m=m%l;
        for(int i=0;i<l;i++){
            if(i+m>=l){
                int extra=m-(l-i);
                ans=Math.max(ans,pref[l]-pref[i]+pref[extra]);
            }
            else ans=Math.max(ans,pref[i+m]-pref[i]);
        }
        return ans;
    }
}