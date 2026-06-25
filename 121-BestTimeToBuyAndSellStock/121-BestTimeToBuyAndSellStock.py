# Last updated: 6/25/2026, 8:39:10 AM
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxSum = 0
        maxCurrProfit = 0
        for i in range(1, len(prices)):
            maxCurrProfit += prices[i] - prices[i-1]
            maxCurrProfit = max(0, maxCurrProfit)
            maxSum = max(maxSum, maxCurrProfit)
        return maxSum
        