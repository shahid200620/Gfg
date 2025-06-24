class Solution {
    public static String maxSubseq(String s, int k) {
        int n = s.length();
        int resLen = n - k;
        StringBuilder result = new StringBuilder();

        int currentStartIndex = 0;

        for (int i = 0; i < resLen; i++) {
            char maxChar = ' '; 
            int maxCharIndex = -1;

            int searchEndIndex = n - (resLen - i);

            for (int j = currentStartIndex; j <= searchEndIndex; j++) {
                char currentChar = s.charAt(j);
                if (currentChar > maxChar) {
                    maxChar = currentChar;
                    maxCharIndex = j;
                }
            }
            
            result.append(maxChar);
            currentStartIndex = maxCharIndex + 1;
        }

        return result.toString();
    }
}