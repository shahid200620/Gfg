class Solution {
    int minToggle(int[] arr) {
        int cnt_total_0 = 0;
        int cnt_total_1 = 0;
        
        for(int bit : arr){
            if(bit == 0) cnt_total_0++;
            else cnt_total_1++;
        }
        
        int till_cnt_0 = 0;
        int till_cnt_1 = 0;
        int minToggles = Integer.MAX_VALUE;
        //Case 1 ---> left side all 1s and right side all 1s
        minToggles = Math.min(minToggles , cnt_total_0);
            
        //Case 2 ---> left side all 0s and right side all 0s
        minToggles = Math.min(minToggles , cnt_total_0);
        
        for(int bit : arr){
            if(bit == 0) till_cnt_0++;
            else till_cnt_1++;
            
            //Case 3 ---> left side all 0s and right side all 1s
            minToggles = Math.min(minToggles , (till_cnt_1 + (cnt_total_0 - till_cnt_0)));
        }
        return minToggles;
    }
}

