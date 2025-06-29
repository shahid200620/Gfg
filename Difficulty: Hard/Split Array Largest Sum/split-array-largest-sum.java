import java.util.Arrays;

class Solution {
    public int splitArray(int[] nums, int k) {
        long low = 0;
        long high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    private boolean isPossible(int[] nums, int k, long maxSumAllowed) {
        int currentSubarrays = 1;
        long currentSum = 0;

        for (int num : nums) {
            if (currentSum + num <= maxSumAllowed) {
                currentSum += num;
            } else {
                currentSubarrays++;
                currentSum = num;
            }
            if (currentSubarrays > k) {
                return false;
            }
        }
        return true;
    }
}