# Last updated: 6/25/2026, 8:37:57 AM
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        p = 0
        for i in range(len(nums)):
            if(nums[i] != 0):
                nums[p] = nums[i]
                p += 1
        while(p < len(nums)):
            nums[p] = 0
            p += 1
            
            
        
        