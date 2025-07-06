import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.AbstractMap.SimpleEntry;

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = a.length;

        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        HashSet<SimpleEntry<Integer, Integer>> visited = new HashSet<>();

        pq.offer(new int[]{a[n - 1] + b[n - 1], n - 1, n - 1});
        visited.add(new SimpleEntry<>(n - 1, n - 1));

        while (k > 0 && !pq.isEmpty()) {
            int[] current = pq.poll();
            int sum = current[0];
            int i = current[1];
            int j = current[2];

            result.add(sum);
            k--;

            if (i - 1 >= 0) {
                SimpleEntry<Integer, Integer> nextPair = new SimpleEntry<>(i - 1, j);
                if (!visited.contains(nextPair)) {
                    pq.offer(new int[]{a[i - 1] + b[j], i - 1, j});
                    visited.add(nextPair);
                }
            }

            if (j - 1 >= 0) {
                SimpleEntry<Integer, Integer> nextPair = new SimpleEntry<>(i, j - 1);
                if (!visited.contains(nextPair)) {
                    pq.offer(new int[]{a[i] + b[j - 1], i, j - 1});
                    visited.add(nextPair);
                }
            }
        }
        return result;
    }
}
