import java.util.HashMap;

class Solution {
    public int totalElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        HashMap<Integer, Integer> distinctCount = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {
            distinctCount.put(arr[right], distinctCount.getOrDefault(arr[right], 0) + 1);

            while (distinctCount.size() > 2) {
                distinctCount.put(arr[left], distinctCount.get(arr[left]) - 1);
                if (distinctCount.get(arr[left]) == 0) {
                    distinctCount.remove(arr[left]);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}