class Solution {
    public static int findPages(int[] arr, int k) {
        if(k > arr.length) return -1;
        int start = 0, end = 0;
        
         for(int i : arr){
            end += i;
            if(i > start) start = i;
        }
        
       while(start <= end){
            int mid = start + (end-start)/2;
            
            if(canDo(arr, mid, k)) end = mid-1;
            
            else start = mid+1;
        }
        return start;
    }
    private static boolean canDo(int[] arr, int mid, int k){
        int student = 1, currentSum = 0;
        
        for(int i : arr){
             if(i > mid) return false;
            
            if(currentSum + i > mid){
                student++;
               currentSum = i;
                
                 if(student > k) return false;
            }
             else currentSum += i;
        }
        return true;
    }
}