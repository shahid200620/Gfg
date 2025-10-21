class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
       
        int[] cloned = arr.clone();
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> h = new HashMap<>();
        
        
        Arrays.sort(arr);
        int n = arr.length;
        
        long[] catalan = new long[n+1];
        catalan[0] = catalan[1] = 1;
        
        for(int i = 2;i<=n;i++){
            catalan[i] = 0;
            for(int j = 0; j<i;j++){
                catalan[i] += (catalan[j] * catalan[i-j-1]);
            }
        }
        
        
        for(int i = 0;i < n; i++){
            int L = i; 
            int R = n-i-1; 
            long bstsPossible = catalan[L] * catalan[R];
            
            h.put(arr[i],(int) bstsPossible);
        }
        
        
        for(int num: cloned){
            ans.add(h.get(num));
        }
        
        return ans;
    }
}