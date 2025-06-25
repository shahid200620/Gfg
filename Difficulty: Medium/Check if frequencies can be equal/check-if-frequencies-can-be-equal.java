import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    boolean sameFreq(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Map<Character, Integer> charFrequencies = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequencies.put(c, charFrequencies.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> freqCounts = new HashMap<>();
        for (int freq : charFrequencies.values()) {
            freqCounts.put(freq, freqCounts.getOrDefault(freq, 0) + 1);
        }

        if (freqCounts.size() == 1) {
            return true;
        } else if (freqCounts.size() == 2) {
            Set<Integer> distinctFrequencies = freqCounts.keySet();
            int freq1 = -1, freq2 = -1;
            for (int freq : distinctFrequencies) {
                if (freq1 == -1) {
                    freq1 = freq;
                } else {
                    freq2 = freq;
                }
            }

            if (freq1 > freq2) {
                int temp = freq1;
                freq1 = freq2;
                freq2 = temp;
            }

            if (freqCounts.get(freq1) == 1 && freq1 == 1) {
                return true;
            }
            
            if (freqCounts.get(freq2) == 1 && (freq2 - freq1 == 1)) {
                return true;
            }
        }

        return false;
    }
}