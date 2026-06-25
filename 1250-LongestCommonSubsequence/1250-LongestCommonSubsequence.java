// Last updated: 6/25/2026, 8:36:18 AM
class Solution {
    public int dpUtils(char[] text1, char[] text2, int i, int j, int[][] dp){
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        //System.out.println(text1[i-1] + " " + text2[j-1]);
        if(text1[i-1] == text2[j-1]){
            //System.out.println("1");
            dp[i][j] = 1 + dpUtils(text1, text2, i-1, j-1, dp);
        } else {
            dp[i][j] = Math.max(dpUtils(text1, text2, i-1, j, dp), 
                                dpUtils(text1, text2, i, j-1, dp));
        }
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1arr = text1.toCharArray();
        char[] text2arr = text2.toCharArray();
        int t1n = text1arr.length;
        int t2n = text2arr.length;
        int[][] dp = new int[t1n + 1][t2n + 1];
        for(int i = 0; i <= t1n; i++){
            for(int j = 0; j <= t2n; j++){
                dp[i][j] = -1;
            }
        }
        return dpUtils(text1arr, text2arr, t1n, t2n, dp);
    }
}