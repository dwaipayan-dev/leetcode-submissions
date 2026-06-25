// Last updated: 6/25/2026, 8:36:53 AM
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], n);
        }
        for(int[] mine: mines){
            dp[mine[0]][mine[1]] = 0;
        }
        int max = 0;
        int idx = 0;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(dp[i][j] == 0) count = 0;
                else{
                    dp[i][j] = Math.min(dp[i][j], ++count);
                }
                //max = Math.max(dp[i][j], max);
            }
            count = 0;
            for(int j = n-1; j >= 0; j--){
                if(dp[i][j] == 0) count = 0;
                else{
                    dp[i][j] = Math.min(dp[i][j], ++count);
                }
                //max = Math.max(dp[i][j], max);
            }
            count = 0;
            for(int j = 0; j < n; j++){
                if(dp[j][i] == 0) count = 0;
                else{
                    dp[j][i] = Math.min(dp[j][i], ++count);
                }
                //max = Math.max(dp[j][i], max);
            }
            count = 0;
            for(int j = n-1; j >= 0; j--){
                if(dp[j][i] == 0) count = 0;
                else{
                    dp[j][i] = Math.min(dp[j][i], ++count);
                }
            }
            //max = Math.max(max, dp[i][idx++]);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}