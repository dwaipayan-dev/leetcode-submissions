// Last updated: 6/25/2026, 8:36:27 AM
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[][] dp = new int[2][n];
        dp[0][1] = values[0] + values[1] - 1;
        dp[1][0] = values[0]; 
        for(int i = 1; i < n; i++){
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1] + values[i] - i);
            dp[1][i] = Math.max(dp[1][i-1], values[i] + i);
        }
        return dp[0][n-1];
    }
}