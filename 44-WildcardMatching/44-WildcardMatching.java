// Last updated: 6/25/2026, 8:40:05 AM
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        if(m > 0 && s.charAt(0) == '*'){
            dp[1][0] = true;
        }
        if(n > 0 && p.charAt(0) == '*'){
            dp[0][1] = true;
        }
        if(m == 0 && n == 0){
            return true;
        }
        if(m == 0){
            String temp = "";
            for(int i = 0; i < n; i++){
                temp += '*';
            }
            return(temp.equals(p));
        }
        if(n == 0){
            String temp = "";
            for(int i = 0; i < m; i++){
                temp += '*';
            }
            return(temp.equals(s));
        }
        for(int i = 1; i <= m; i++){
            if(s.charAt(i-1) == '*'){
                dp[i][0] = dp[i-1][0]; 
            }
        }
        for(int j = 1; j <= n; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1]; 
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i-1) == '*' || p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else if(s.charAt(i-1) == '?' || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}