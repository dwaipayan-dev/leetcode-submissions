// Last updated: 6/25/2026, 8:36:54 AM
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int i = 0;
        for(i = 2; i < dp.length - 1; i++){
            dp[i] = Math.min(dp[i-2], dp[i-1]) + cost[i];
        }
        return Math.min(dp[i-2], dp[i-1]);
    }
}