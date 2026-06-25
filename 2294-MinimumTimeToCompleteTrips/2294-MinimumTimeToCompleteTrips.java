// Last updated: 6/25/2026, 8:32:37 AM
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo = Integer.MAX_VALUE;
        long hi;
        for (int t: time) {
            lo = Math.min(lo, t);
        }

        hi = lo * totalTrips;
        long ans = hi;
        while(lo <= hi) {
            long mid = lo + (hi - lo)/2;
            if(isValid(time, totalTrips, mid)) {
                // Is Valid so we seek next min
                ans = mid;
                hi = mid - 1;
            } else {
                // Try a bigger candidate
                lo = mid + 1;
            }
        }
        return ans;
    }

    public boolean isValid(int[] time, int totalTrips, long candidate) {
        long currTrips = 0;
        for(int t: time) {
            currTrips += candidate/t;
        }
        return currTrips >= totalTrips;
    }


}