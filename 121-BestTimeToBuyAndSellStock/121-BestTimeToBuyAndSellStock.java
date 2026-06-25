// Last updated: 6/25/2026, 8:39:04 AM
class Solution {
    public int maxProfit(int[] prices) {
        int pSell = 0; // No Stock on Day -1
        int pBuy = Integer.MIN_VALUE; // Have Stock on Day -1, impossible profit

        //Recurrence relation depends on day i, transaction k and have Stock or not(0/1)
        // T[i][k][1] = Math.max(T[i-1][k][1], T[i-1][k-1][0] - price[i]) // Buying stock
        // T[i][k][0] = Math.max(T[i-1][k][0], T[i][k][1] + price[i]) // Selling stock
        // On last day we should not hold stock hence return T[i][k][0]
        for(int i: prices) {
            
            pSell = Math.max(pSell, i + pBuy);
            pBuy = Math.max(pBuy, -i);
        }
        return pSell;
    }
}