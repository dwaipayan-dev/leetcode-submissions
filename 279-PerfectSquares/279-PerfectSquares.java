// Last updated: 6/25/2026, 8:37:58 AM
class Solution {
    public int numSquares(int n) {
        int maxRoot = (int)Math.floor(Math.sqrt(n));
        int[][] dp = new int[maxRoot][n+1];
        for(int i = 0; i < maxRoot; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0) dp[i][j] = j;
                if(j == 0) dp[i][j] = 0;
                if(i!= 0 && j!= 0){
                    if(j < (i+1)*(i+1)){
                        dp[i][j] = dp[i-1][j];
                    } else {
                        int t = (i+1) * (i+1);
                        dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-t]);
                    }
                }
                
            }
            //System.out.println(Arrays.toString(dp[i]));
        }
        return dp[maxRoot - 1][n];
    }
}