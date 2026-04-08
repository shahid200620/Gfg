class Solution {
    void segregate0and1(int[] arr) {
        int index = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                arr[index++] = 0;
            }
        }
        for(int i=index; i<arr.length; i++) {
            arr[i] = 1;
        }
        
        Arrays.sort(arr);
    }
}