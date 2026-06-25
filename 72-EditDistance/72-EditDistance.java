// Last updated: 6/25/2026, 8:39:45 AM
class Solution {
    public int minDistance(String word1, String word2) {
        //Assuming word1 is greater than word2;
        if(word2.length() > word1.length()){
            String temp = word2;
            word2 = word1;
            word1 = temp;
        }
        char[] chArr1 = word1.toCharArray();
        char[] chArr2 = word2.toCharArray();
        int len1 = chArr1.length;
        int len2 = chArr2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++){
            dp[i][len2] = len1 - i;
        }
        for(int i = 1; i <= len2; i++){
            dp[len1][i] = len2 - i;
        }
        for(int i = len1 - 1; i >= 0; i--){
            for(int j = len2 - 1; j >= 0; j--){
                if(chArr1[i] == chArr2[j]){
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i+1][j+1], 
                    Math.min(dp[i+1][j], dp[i][j+1]));
                }
            }
            
        }
        return dp[0][0];

    }
}