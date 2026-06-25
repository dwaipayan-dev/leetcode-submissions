// Last updated: 6/25/2026, 8:37:45 AM
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] temp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i <= coins.length; i++) {
            Arrays.fill(temp[i], Integer.MAX_VALUE);
            temp[i][0] = 0;
        }

        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j - coins[i-1] >= 0) {
                    int t = temp[i][j - coins[i-1]];
                    temp[i][j] = Math.min(temp[i-1][j], t + ( t == Integer.MAX_VALUE ? 0: 1));
                } else {
                    temp[i][j] = temp[i-1][j];
                }
            }
        }

        int res = temp[coins.length][amount];
        
        return res== Integer.MAX_VALUE? -1: res;
    }
}