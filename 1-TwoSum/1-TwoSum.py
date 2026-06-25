# Last updated: 6/25/2026, 8:40:29 AM
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        freqMap = {}
        for i in range(len(nums)):
            if((target - nums[i]) in freqMap) == True:
                j = freqMap[target - nums[i]]
                return [j, i]
            freqMap[nums[i]] = i 