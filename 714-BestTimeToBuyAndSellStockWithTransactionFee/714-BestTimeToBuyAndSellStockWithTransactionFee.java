// Last updated: 6/25/2026, 8:37:01 AM
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int T0 = 0;
        int T1 = -prices[0];
        //System.out.println(T1);
        for(int i = 0; i < prices.length; i++){
            T0 = Math.max(T0, T1 + prices[i] - fee);
            T1 = Math.max(T1, T0 - prices[i]);
            //System.out.println(T0 + " " + T1);
        }
        return T0;
    }
}