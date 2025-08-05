class Solution {
    public boolean isPalinSent(String s) {
        if (s == null) {
            return true;
        }

        StringBuilder cleanedString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleanedString.append(Character.toLowerCase(c));
            }
        }

        String processed = cleanedString.toString();
        int left = 0;
        int right = processed.length() - 1;

        while (left < right) {
            if (processed.charAt(left) != processed.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}