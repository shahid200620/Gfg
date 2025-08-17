class Solution {
    public void rearrange(int[] arr, int x) {
        // code here
        Integer[] temp=new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        Arrays.sort(temp,(a,b) -> Math.abs(a-x)-Math.abs(b-x));
        for(int i=0;i<arr.length;i++){
            arr[i]=temp[i];
        }
    }
}