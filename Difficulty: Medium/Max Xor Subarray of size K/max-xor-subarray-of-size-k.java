class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        int wXor = arr[0];
        for(int i = 1; i < k; i++){
            wXor ^= arr[i];
        }
        
        int currXor = wXor;
        
        for(int i = k; i < arr.length; i++){
            currXor ^= arr[i];
            currXor ^= arr[i - k];
            wXor = Math.max(currXor, wXor);
        }
        return wXor;
    }
}