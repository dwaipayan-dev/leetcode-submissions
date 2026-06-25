# Last updated: 6/25/2026, 8:40:01 AM
import sys
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maxSum = -(sys.maxsize)
        currentSum = 0
        for i in range(len(nums)):
            """
            Kadane's Algorithm
            """
            firstOption = nums[i]
            secondOption = nums[i] + currentSum
            currentSum = max(firstOption, secondOption)
            maxSum = max(maxSum, currentSum)
        return maxSum
            
            