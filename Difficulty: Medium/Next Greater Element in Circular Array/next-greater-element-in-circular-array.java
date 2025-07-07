import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }
        for (int i = 0; i < 2 * n; i++) {
            int curr = arr[i % n];
            
            while (!stack.isEmpty() && arr[stack.peek()] < curr) {
                int idx = stack.pop();
                if (result.get(idx) == -1) {
                    result.set(idx, curr);
                }
            }
            if (i < n) {
                stack.push(i);
            }
        }
                return result;
    }
}
