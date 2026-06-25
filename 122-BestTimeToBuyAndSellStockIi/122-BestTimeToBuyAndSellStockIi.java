// Last updated: 6/25/2026, 8:39:03 AM
class Solution {
    public int maxProfit(int[] prices) {
        //On day 0 no stock, profit 0
        int P0 = 0;
        //On day 0 stock, profit impossible
        int P1 =Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            P0 = Math.max(P0, P1 + prices[i]);
            P1 = Math.max(P1, P0 - prices[i]);
        }
        return P0;
    }
}