import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingNumber(int[] arr) {
        Set<Integer> presentNumbers = new HashSet<>();
        for (int num : arr) {
            if (num > 0) {
                presentNumbers.add(num);
            }
        }

        int smallestPositive = 1;
        while (presentNumbers.contains(smallestPositive)) {
            smallestPositive++;
        }

        return smallestPositive;
    }
}