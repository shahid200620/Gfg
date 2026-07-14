class Solution {
    public int find(int[] arr) {
        int req = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            req = (req + arr[i] + 1) / 2;   // ceil((req + arr[i]) / 2)
        }

        return Math.max(req, 1);
    }
}