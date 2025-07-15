class Solution {
    public boolean divby13(String s) {
        int remainder = 0;
        int[] powersOf10Mod13 = {1, 10, 9, 12, 3, 4}; // Precomputed 10^i % 13 for i = 0 to 5

        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - '0';
            int position = (s.length() - 1 - i);
            remainder = (remainder + (digit * powersOf10Mod13[position % 6])) % 13;
        }

        return remainder == 0;
    }
}