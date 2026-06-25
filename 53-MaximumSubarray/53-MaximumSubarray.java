// Last updated: 6/25/2026, 8:39:57 AM
class Solution {
    public int maxSubArray(int[] nums) {
        int curr = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            curr = Math.max(curr, 0) + nums[i];
            max = Math.max(max, curr);
        }
        return max;
    }
}