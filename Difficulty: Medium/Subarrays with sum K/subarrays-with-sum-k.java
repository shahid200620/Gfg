import java.util.HashMap;

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> prefixSumCounts = new HashMap<>();
        
        prefixSumCounts.put(0, 1); 
        
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            
            if (prefixSumCounts.containsKey(currentSum - k)) {
                count += prefixSumCounts.get(currentSum - k);
            }
            
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}