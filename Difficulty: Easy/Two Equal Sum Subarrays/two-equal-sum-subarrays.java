class Solution {
    public boolean canSplit(int nums[]) {
        int l = 0;
        int r = nums.length - 1;
        int sum = 0;
        
        while(l <= r) {
            // Left side
            if(sum <= 0) {
                sum += nums[l];
                l++;
            }
            // Right Side
            else {
                sum -= nums[r];
                r--;
            }
        }
        
        return (sum == 0) ? true : false;
    }
}