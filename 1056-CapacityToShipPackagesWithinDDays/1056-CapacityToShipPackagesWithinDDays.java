// Last updated: 6/25/2026, 8:36:29 AM
class Solution {
    public boolean isValid(int[] weights, int candidate, int target) {
        int weightCount = 0;
        int daysCount = 1;
        for(int i = 0; i < weights.length; i++) {
            weightCount += weights[i];
            if(weightCount > candidate) {
                // Start from here the next day
                weightCount = weights[i];
                daysCount++;
            }
        }
        return daysCount <= target;
    }
    public int shipWithinDays(int[] weights, int days) {
        // Max Weight is lower bound, to ship all packages
        int low = 0;
        // high is sum of all weights to ship all packages in 1 day
        int high = 0;
        for(int i = 0; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        int ans = high;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(isValid(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}