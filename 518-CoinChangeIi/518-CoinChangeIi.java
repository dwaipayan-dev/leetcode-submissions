// Last updated: 6/25/2026, 8:37:18 AM
class Solution {
    public int dpUtils(int[][] temp, int amt, int[]coins, int i, int j){
        if(j == 0){
            return 1;
        }
        if(j < 0 || i == 0){
            return 0;
        }
        if(temp[i][j] != -1){
            return temp[i][j];
        }
        temp[i][j] = dpUtils(temp, amt, coins, i-1, j) + 
        dpUtils(temp, amt, coins, i, j-coins[i-1]);
        return temp[i][j];
    }
    public int change(int amount, int[] coins) {
        int temp[][] = new int[coins.length+1][amount + 1];
        for(int i = 0; i < coins.length + 1; i++){
            for(int j = 0; j < amount + 1; j++){
                temp[i][j] = -1;
            }
        }
        //System.out.println(temp.length + " " + temp[0].length);
        int res = dpUtils(temp, amount, coins, coins.length, amount);
        return res;
        //return 0;
    }
}