# Last updated: 6/25/2026, 8:38:35 AM
class Solution:
    def reverse(self, i: int, j: int, nums: List[int]):
        low = i
        high = j-1
        while(low < high):
            t = nums[low]
            nums[low] = nums[high]
            nums[high] = t
            low += 1
            high -= 1
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        pivot = len(nums) - (k%len(nums))
        self.reverse(0, pivot, nums)
        self.reverse(pivot, len(nums), nums)
        self.reverse(0, len(nums), nums)
        
        