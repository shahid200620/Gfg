import java.util.*;

class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int[] tail = new int[n];
        int[] lisIndex = new int[n];
        int len = 0;

        for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(tail, 0, len, arr[i]);
            if (pos < 0) pos = -pos - 1;
            tail[pos] = arr[i];
            lisIndex[i] = pos + 1;
            if (pos == len) len++;
        }

        int lisLength = len;
        int[] result = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (lisIndex[i] == lisLength && (max == Integer.MIN_VALUE || arr[i] < max)) {
                result[i] = 1;
                lisLength--;
                max = arr[i];
            }
        }

        int total = 0;
        for (int num : arr) total += num;
        int lisSum = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] == 1) lisSum += arr[i];
        }

        return total - lisSum;
    }
}
