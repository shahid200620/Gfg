import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public ArrayList<Integer> countLessEq(int[] a, int[] b) {
        Arrays.sort(b);
        ArrayList<Integer> resultList = new ArrayList<>();
        
        for (int i = 0; i < a.length; i++) {
            int low = 0;
            int high = b.length - 1;
            int currentElement = a[i];
            int count = 0;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (b[mid] <= currentElement) {
                    count = mid + 1;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            resultList.add(count); // Add to ArrayList
        }
        return resultList; 
    }
}