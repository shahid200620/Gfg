import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countValid(int n, int[] arr) {
        Set<Integer> targetDigits = new HashSet<>();
        for (int digit : arr) {
            targetDigits.add(digit);
        }

        long totalNdigitNumbers = 9; 
        for (int i = 0; i < n - 1; i++) {
            totalNdigitNumbers *= 10;
        }

        long numbersWithoutTargetDigits = 0;
        int countNonTargetDigits = 0;
        for (int i = 0; i <= 9; i++) {
            if (!targetDigits.contains(i)) {
                countNonTargetDigits++;
            }
        }

        if (countNonTargetDigits == 0) {
            return (int) totalNdigitNumbers;
        }

        if (n == 1) {
            numbersWithoutTargetDigits = 0;
            for (int i = 1; i <= 9; i++) {
                if (!targetDigits.contains(i)) {
                    numbersWithoutTargetDigits++;
                }
            }
        } else {
            // Calculate numbers where no target digit appears
            // For the first digit (1-9)
            int firstDigitOptions = 0;
            for (int i = 1; i <= 9; i++) {
                if (!targetDigits.contains(i)) {
                    firstDigitOptions++;
                }
            }

            numbersWithoutTargetDigits = firstDigitOptions;
            
            // For the remaining n-1 digits (0-9)
            for (int i = 0; i < n - 1; i++) {
                numbersWithoutTargetDigits *= countNonTargetDigits;
            }
        }
        
        long result = totalNdigitNumbers - numbersWithoutTargetDigits;
        return (int) result;
    }
}