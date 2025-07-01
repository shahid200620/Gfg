import java.util.HashMap;

class Solution {
    int substrCount(String s, int k) {
        int count = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int distinctCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (freqMap.getOrDefault(currentChar, 0) == 0) {
                distinctCount++;
            }
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);

            if (i >= k) {
                char charToRemove = s.charAt(i - k);
                freqMap.put(charToRemove, freqMap.get(charToRemove) - 1);
                if (freqMap.get(charToRemove) == 0) {
                    distinctCount--;
                }
            }

            if (i >= k - 1) {
                if (distinctCount == k - 1) {
                    count++;
                }
            }
        }
        return count;
    }
}