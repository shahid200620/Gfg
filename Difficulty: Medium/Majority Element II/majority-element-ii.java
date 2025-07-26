import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }
}