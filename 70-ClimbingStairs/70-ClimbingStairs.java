// Last updated: 6/25/2026, 8:39:46 AM
class Solution {
    public int climbStairs(int n) {
        //All combinations are needed hence similar to combination sum 4 we consider all the entries
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            if(i == 1){
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
}