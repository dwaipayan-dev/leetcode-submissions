# Last updated: 6/25/2026, 8:32:53 AM
class Solution:
    def findMiddleIndex(self, nums: List[int]) -> int:
        totalSum = 0
        leftSum = 0
        totalSum = self.totalArraySum(nums)
        for i in range(len(nums)):
            leftSum = self.totalArraySum(nums[0: i])
            if(2*leftSum == (totalSum - nums[i])):
                return i
        return -1
    
    def totalArraySum(self, arr):
        arrSum = 0
        for element in arr:
            arrSum += element
        return arrSum
        
        