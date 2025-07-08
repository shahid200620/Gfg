import java.util.*;

class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            result.add(-1);
        }

         for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && frequency.get(arr[stack.peek()]) < frequency.get(arr[i])) {
                 result.set(stack.pop(), arr[i]);
            }
            stack.push(i); }

        return result;
    }
}
