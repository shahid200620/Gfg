import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countBalanced(String[] arr) {
        long resultCount = 0;
        
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        
        long currentPrefixSum = 0;
        
        for (String s : arr) {
            int vowelCount = 0;
            int consonantCount = 0;
            
            for (char c : s.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
            
            currentPrefixSum += (long)vowelCount - consonantCount;
            
            if (prefixSumCount.containsKey(currentPrefixSum)) {
                resultCount += prefixSumCount.get(currentPrefixSum);
            }
            
            prefixSumCount.put(currentPrefixSum, prefixSumCount.getOrDefault(currentPrefixSum, 0) + 1);
        }
        
        return (int)resultCount;
    }
}