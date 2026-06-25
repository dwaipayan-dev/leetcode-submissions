// Last updated: 6/25/2026, 8:38:36 AM
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] buySellMat = new int[2][k];
        for(int i = 0; i < k; i++){
            buySellMat[0][i] = Integer.MAX_VALUE;
            buySellMat[1][i] = 0;
        }
        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < k; j++){
                if(j == 0){
                    buySellMat[0][j] = Math.min(buySellMat[0][j], prices[i]);
                    buySellMat[1][j] = Math.max(buySellMat[1][j], prices[i] - buySellMat[0][j]);
                } else{
                    buySellMat[0][j] = Math.min(buySellMat[0][j], prices[i] - buySellMat[1][j-1]);
                    buySellMat[1][j] = Math.max(buySellMat[1][j], prices[i] - buySellMat[0][j]);
                }
            }
        }
        return buySellMat[1][k-1];
    }
}