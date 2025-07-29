import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public ArrayList<Integer> asciirange(String s) {
        int n = s.length();
        
        int[] firstOccur = new int[26];
        int[] lastOccur = new int[26];
        
        Arrays.fill(firstOccur, -1);
        Arrays.fill(lastOccur, -1);
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int charIndex = c - 'a';
            
            if (firstOccur[charIndex] == -1) {
                firstOccur[charIndex] = i;
            }
            lastOccur[charIndex] = i;
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < 26; i++) {
            int firstIdx = firstOccur[i];
            int lastIdx = lastOccur[i];
            
            if (firstIdx != -1 && firstIdx != lastIdx) {
                int currentSum = 0;
                
                for (int k = firstIdx + 1; k < lastIdx; k++) {
                    currentSum += s.charAt(k);
                }
                
                if (currentSum != 0) {
                    result.add(currentSum);
                }
            }
        }
        
        return result;
    }
}