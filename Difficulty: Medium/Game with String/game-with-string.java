class Solution {
    public int minValue(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Max-heap
        for (int freq : freqMap.values()) {
            pq.add(freq);
        }
        while (k > 0 && !pq.isEmpty()) {
            int currentFreq = pq.poll();
            currentFreq--;
            if (currentFreq > 0) {
                pq.add(currentFreq);
            }
            k--;
        }
        int minValue = 0;
        while (!pq.isEmpty()) {
            int freq = pq.poll();
            minValue += freq * freq;
        }
        return minValue;
    }
}