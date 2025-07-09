import java.util.Stack;

class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        long result = 0;
        int mod = 1000000007;
        
        for (int i = 0; i < n; i++) {
            long count = (i - left[i]) * (right[i] - i) % mod;
            result = (result + arr[i] * count) % mod;
        }
        
        return (int) result;
    }
}
