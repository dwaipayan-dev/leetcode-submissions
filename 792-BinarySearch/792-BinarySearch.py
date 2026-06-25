# Last updated: 6/25/2026, 8:36:47 AM
class Solution(object):
    def search(self, nums, target):
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = (low + high)//2
            if(nums[mid] == target):
                return mid
            if(nums[mid] < target):
                low = mid + 1
            if(nums[mid] > target):
                high = mid - 1
        return -1
        