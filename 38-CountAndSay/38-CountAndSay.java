// Last updated: 6/25/2026, 8:40:11 AM
class Solution {
    public String countAndSay(int n) {
        String[] dp = new String[n];
        dp[0] = "1";
        for(int i = 1; i < n; i++){
            int count = 0;
            char prev = '.';
            String res = "";
            for(int j = 0; j < dp[i-1].length(); j++){
                char curr = dp[i-1].charAt(j);
                if(j == 0) prev = curr;
                if(prev == curr){
                    count++;
                }
                if(prev != curr ){
                    res += ""+count+""+prev;
                    count = 1;
                    prev = curr;
                }
                if(j == dp[i-1].length() - 1){
                    res += ""+count+""+prev;
                }
            }
            
            dp[i] = res;
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}