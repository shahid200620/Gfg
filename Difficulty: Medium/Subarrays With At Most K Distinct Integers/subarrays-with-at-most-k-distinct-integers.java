import java.util.HashMap;

class Solution {
    public int countAtMostK(int arr[], int k) {
        int left = 0;
        int count = 0;
        HashMap<Integer, Integer> charCount = new HashMap<>(); 
        
        for (int right = 0; right < arr.length; right++) {
            int rNum = arr[right];
            charCount.put(rNum, charCount.getOrDefault(rNum, 0) + 1);

            while (charCount.size() > k) {
                int lNum = arr[left];
                charCount.put(lNum, charCount.get(lNum) - 1);
                if (charCount.get(lNum) == 0) {
                    charCount.remove(lNum);
                }
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}