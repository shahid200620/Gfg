import java.util.Arrays;

class Solution {
    public int getSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
               
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                
                secondLargest = num;
            }
        }
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        } else {
            return secondLargest;
        }
    }
}