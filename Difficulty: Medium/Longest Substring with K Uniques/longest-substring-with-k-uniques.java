import java.util.HashMap;

class Solution {
    public int longestKSubstr(String s, int k) {
        int maxLength = -1;
        HashMap<Character, Integer> charCount = new HashMap<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            charCount.put(rChar, charCount.getOrDefault(rChar, 0) + 1);

            while (charCount.size() > k) {
                char lChar = s.charAt(left);
                charCount.put(lChar, charCount.get(lChar) - 1);
                if (charCount.get(lChar) == 0) {
                    charCount.remove(lChar);
                }
                left++;
            }

            if (charCount.size() == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}