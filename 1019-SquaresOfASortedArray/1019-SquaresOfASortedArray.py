# Last updated: 6/25/2026, 8:36:31 AM
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        low = 0
        high = len(nums) - 1
        result = []
        for i in range(len(nums)):
            if(abs(nums[low]) > abs(nums[high])):
                result.append(nums[low] ** 2)
                low += 1
            else:
                result.append(nums[high] ** 2)
                high -= 1
        return result[::-1]
                
        