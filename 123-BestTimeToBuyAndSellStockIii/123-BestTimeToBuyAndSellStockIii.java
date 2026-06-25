// Last updated: 6/25/2026, 8:39:02 AM
class Solution {
    public int maxProfit(int[] prices) {
        //On day -1;
        int T10 = 0;
        int T11 = -Integer.MAX_VALUE + 1;
        int T20 = 0;
        int T21 = -Integer.MAX_VALUE + 1;
        for(int i = 0; i < prices.length; i++){
            T10 = Math.max(T10, T11 + prices[i]);
            T11 = Math.max(T11, -prices[i]);
            //T10 = Math.max(T10, T11 + prices[i]);
            T20 = Math.max(T20, T21 + prices[i]);
            T21 = Math.max(T21, T10 - prices[i]);
            
        }
        return T20;
    }
}