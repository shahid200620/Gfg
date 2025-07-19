import java.util.HashMap;
import java.util.Map;

class Solution {
    public int vowelCount(String s) {
        Map<Character, Integer> vowelOccurrences = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelOccurrences.put(c, vowelOccurrences.getOrDefault(c, 0) + 1);
            }
        }

        long count = 1;
        int numUniqueVowels = vowelOccurrences.size();

        if (numUniqueVowels == 0) {
            return 0;
        }

        for (int occ : vowelOccurrences.values()) {
            count *= occ;
        }

        for (int i = 1; i <= numUniqueVowels; i++) {
            count *= i;
        }

        return (int) count;
    }
}