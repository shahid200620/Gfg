class Solution {
    static long isPallindrome(long N) {
        String binary = Long.toBinaryString(N);
        int left = 0, right = binary.length() - 1;
        while (left < right) {
            if (binary.charAt(left) != binary.charAt(right)) {
                return 0; 
            }
            left++;
            right--;
        }
        return 1;
    }
}