// Last updated: 6/25/2026, 8:39:54 AM
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            if(dp[i] == true){
                for(int j = 1; j <= nums[i]; j++){
                    if(i+j < nums.length - 1){
                        dp[i+j] = true;
                    }
                    if(i+j == nums.length - 1) return true;
                }
            }
        }
        return dp[nums.length - 1];
    }
}